class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(sumDigit(nums[i])==i){
                return i;
            }
        }
        return -1;
    }
    private int sumDigit(int n){
        int sum=0;
        while(n>0){
            int digit=n%10;
            sum+=digit;
            n=n/10;
        }
        return sum;
    }
}