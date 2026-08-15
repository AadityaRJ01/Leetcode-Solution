class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        Long[][][] dp = new Long[n][3][k + 1];
        return solve(0, 0, prices, k, dp);
    }

    private long solve(int i, int state, int[] prices, int k, Long[][][] dp) {
        if (i == prices.length) {
            return state == 0 ? 0 : Long.MIN_VALUE / 2;
        }
        if (k == 0) {
            return state == 0 ? 0 : Long.MIN_VALUE / 2;
        }
        if (dp[i][state][k] != null) {
            return dp[i][state][k];
        }
        long profit;
        if (state == 0) {
            long buy = -prices[i] + solve(i + 1, 1, prices, k, dp);
            long shortSell = prices[i] + solve(i + 1, 2, prices, k, dp);
            long skip = solve(i + 1, 0, prices, k, dp);

            profit = Math.max(skip, Math.max(buy, shortSell));

        } else if (state == 1) {
            long sell = prices[i] + solve(i + 1, 0, prices, k - 1, dp);
            long hold = solve(i + 1, 1, prices, k, dp);

            profit = Math.max(sell, hold);

        } else {
            long buyBack = -prices[i] + solve(i + 1, 0, prices, k - 1, dp);
            long hold = solve(i + 1, 2, prices, k, dp);

            profit = Math.max(buyBack, hold);
        }
        return dp[i][state][k] = profit;
    }
}