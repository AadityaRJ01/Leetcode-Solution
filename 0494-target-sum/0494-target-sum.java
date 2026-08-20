class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int x:nums){
            total+=x;
        }
        if(Math.abs(target)>total){
            return 0;
        }
        Integer[][] dp=new Integer[nums.length][2*total+1];
        return solve(nums,nums.length-1,0,target,total,dp);
    }
    public int solve(int[] nums,int index,int sum,int target,int offset,Integer[][] dp){
        if(index<0){
            return sum==target?1:0;
        }
        int key=sum+offset;
        if(dp[index][key]!=null){
            return dp[index][key];
        }
        int add=solve(nums,index-1,sum+nums[index],target,offset,dp);
        int sub=solve(nums,index-1,sum-nums[index],target,offset,dp);
        return dp[index][key]=add+sub;
    }
}