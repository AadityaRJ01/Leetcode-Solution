class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countSub(nums,k)-countSub(nums,k-1);
    }
    public int countSub(int[] nums,int k){
        int left=0;
        int res=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]%2!=0){
                k--;
            }
            while(k<0){
                if(nums[left]%2!=0)
                    k++;
                left++;
            }
            res+=(right-left+1);
        }
        return res;

    }
}