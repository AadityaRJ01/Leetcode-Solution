class Solution {
    public int rob(int[] nums) {
        int n=nums.length;

        if(n==1){
            return nums[0];
        }
        return Math.max(robRange(nums,0,n-2),robRange(nums,1,n-1));
    }
    private int robRange(int[] nums,int start,int end){
        int[] dp=new int[nums.length+2];

        for(int i=end;i>=start;i--){
            dp[i]=Math.max(dp[i+1],nums[i]+dp[i+2]);
        }
        return dp[start];
    }
}