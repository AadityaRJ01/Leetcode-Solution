class Solution {
    public int minElement(int[] nums) {
        int mini=Integer.MAX_VALUE;
        for(int num:nums){
            mini=Math.min(mini,digitsum(num));
        }
        return mini;
    }
    private int digitsum(int n){
        int sum=0;
        while(n>0){
            int digit=n%10;
            sum+=digit;
            n=n/10;
        }
        return sum;
    }
}