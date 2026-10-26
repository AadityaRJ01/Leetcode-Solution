class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int oddInd=1;
        int evenInd=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                ans[evenInd]=nums[i];
                evenInd+=2;
            }
            else{
                ans[oddInd]=nums[i];
                oddInd+=2;
            }
        }
        return ans;
    }
}