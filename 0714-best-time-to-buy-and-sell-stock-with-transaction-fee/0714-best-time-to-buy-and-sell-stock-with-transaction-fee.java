class Solution {
    public int maxProfit(int[] prices, int fee) {
       int n=prices.length;
        Integer[][] dp=new Integer[n][2];
        return solve(0,1,prices,dp,fee);
    }
    private int solve(int i,int buy,int[] prices,Integer[][] dp,int fee){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][buy]!=null){
            return dp[i][buy];
        }
        int profit;
        if(buy==1){
            int buyStock=-prices[i]+solve(i+1,0,prices,dp,fee);
            int skip=solve(i+1,1,prices,dp,fee);
            profit=Math.max(buyStock,skip);
        }
        else{
            int sellStock=prices[i]-fee+solve(i+1,1,prices,dp,fee);
            int hold=solve(i+1,0,prices,dp,fee);
            profit=Math.max(sellStock,hold);
        }
        return dp[i][buy]=profit;
    }
}