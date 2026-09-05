class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n=nums.length;
        int mid=nums[(n-1)/2];
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==mid){
                count++;
            }
        }
        if(count==1){
            return true;
        }
        return false;
    }
}