class Solution {
    public int lastStoneWeightII(int[] stones) {

        int n = stones.length;
        int sum = 0;

        for (int x : stones) {
            sum += x;
        }

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Subset Sum DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                boolean notTake = dp[i - 1][j];

                boolean take = false;

                if (stones[i - 1] <= j) {
                    take = dp[i - 1][j - stones[i - 1]];
                }

                dp[i][j] = take || notTake;
            }
        }

        // Find minimum difference
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i <= sum / 2; i++) {
            if (dp[n][i]) {
                int diff = sum - 2 * i;
                mini = Math.min(mini, diff);
            }
        }

        return mini;
    }
}