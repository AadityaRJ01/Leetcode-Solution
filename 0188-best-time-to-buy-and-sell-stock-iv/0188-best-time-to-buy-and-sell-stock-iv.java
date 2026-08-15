class Solution {
    public int maxProfit(int k,int[] prices) {
        int n=prices.length;
        Integer[][][] dp=new Integer[n][k+1][k+1];
        return solve(0,1,prices,dp,k);
    }
    private int solve(int i,int buy,int[] prices,Integer[][][] dp,int limit){
        if(i==prices.length){
            return 0;
        }
        if(limit==0){
            return 0;
        }
        if(dp[i][buy][limit]!=null){
            return dp[i][buy][limit];
        }
        int profit;
        if(buy==1){
            int buyStock=-prices[i]+solve(i+1,0,prices,dp,limit);
            int skip=solve(i+1,1,prices,dp,limit);
            profit=Math.max(buyStock,skip);
        }
        else{
            int sellStock=prices[i]+solve(i+1,1,prices,dp,limit-1);
            int hold=solve(i+1,0,prices,dp,limit);
            profit=Math.max(sellStock,hold);
        }
        return dp[i][buy][limit]=profit;
    }
}
    
