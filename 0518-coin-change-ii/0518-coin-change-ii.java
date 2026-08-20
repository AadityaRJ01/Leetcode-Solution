class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp=new Integer[coins.length][amount+1];
        return solve(coins,amount,coins.length-1,dp);
    }
    public int solve(int[] coins,int amount,int index,Integer[][] dp){
        if(amount==0){
            return 1;
        }
        if(index==0){
            return amount%coins[0]==0?1:0;
        }
        if(dp[index][amount]!=null){
            return dp[index][amount];
        }
        int notPick=solve(coins,amount,index-1,dp);
        int pick=0;
        if(coins[index]<=amount){
            pick=solve(coins,amount-coins[index],index,dp);
        }
        return dp[index][amount]=pick+notPick;
    }
}