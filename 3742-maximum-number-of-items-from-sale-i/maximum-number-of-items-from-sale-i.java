class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    cnt++;
                }
            }
            value[i] = 1 + cnt;
        }

        // dp[b] = max copies using first-purchases with total cost <= b
        int[] dp = new int[budget + 1];
        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + value[i]);
            }
        }

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b] + (budget - b) / minPrice);
        }
        return ans;
    }
}