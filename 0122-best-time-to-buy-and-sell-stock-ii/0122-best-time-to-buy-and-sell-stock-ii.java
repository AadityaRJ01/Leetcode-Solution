class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        Integer[][] dp=new Integer[n][2];
        return solve(0,1,prices,dp);
    }
    private int solve(int i,int buy,int[] prices,Integer[][] dp){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][buy]!=null){
            return dp[i][buy];
        }
        int profit;
        if(buy==1){
            int buyStock=-prices[i]+solve(i+1,0,prices,dp);
            int skip=solve(i+1,1,prices,dp);
            profit=Math.max(buyStock,skip);
        }
        else{
            int sellStock=prices[i]+solve(i+1,1,prices,dp);
            int hold=solve(i+1,0,prices,dp);
            profit=Math.max(sellStock,hold);
        }
        return dp[i][buy]=profit;
    }
}