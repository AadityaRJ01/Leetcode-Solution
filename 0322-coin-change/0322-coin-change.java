class Solution {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];

        int ans = solve(coins, amount, n - 1, dp);

        return ans >= 1000000 ? -1 : ans;
    }

    public int solve(int[] coins, int amount, int ind, Integer[][] dp) {

        if (amount == 0)
            return 0;

        if (ind == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            return 1000000;
        }

        if (dp[ind][amount] != null)
            return dp[ind][amount];

        int notPick = solve(coins, amount, ind - 1, dp);

        int pick = 1000000;

        if (coins[ind] <= amount) {
            pick = 1 + solve(coins,
                             amount - coins[ind],
                             ind,
                             dp);
        }

        return dp[ind][amount] = Math.min(pick, notPick);
    }
}