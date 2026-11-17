class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();

        int[][] cost = new int[n][n];

        // Precompute the minimum changes required
        // to make every substring a semi-palindrome.

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int len = j - i + 1;
                int min = n;

                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int count = 0;

                    for (int x = 0; x < d; x++) {

                        int left = i + x;
                        int right = j - d + 1 + x;

                        while (left < right) {

                            if (s.charAt(left) != s.charAt(right)) {
                                count++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    min = Math.min(min, count);
                }

                cost[i][j] = min;
            }
        }

        // DP
        // dp[i][j] = minimum changes required
        // to divide first i characters into j parts.

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], n);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; j++) {

                for (int prev = 0; prev < i - 1; prev++) {

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[prev][j - 1] + cost[prev][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}