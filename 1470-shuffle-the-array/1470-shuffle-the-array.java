class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[2*n];
        int left=0;
        int right=n;
        int lIndex=0;
        int rIndex=1;
        while(right<2*n){
            ans[lIndex]=nums[left];
            ans[rIndex]=nums[right];
            left++;
            right++;
            lIndex+=2;
            rIndex+=2;
        }
        return ans;
    }
}