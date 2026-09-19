class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int low=0;
        int high=n-1;
        int mid=(low+high)/2;
        int target=nums[mid];
        int sum=0;
        for(int num:nums){
            sum+=Math.abs(num-target);
        }
        return sum;
    }
}