class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int max=-1;
        int min=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>min){
                max=Math.max(max,nums[i]-min);
            }
            else{
                min=nums[i];
            }
        }
        return max;
    }
}