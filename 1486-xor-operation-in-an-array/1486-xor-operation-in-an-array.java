class Solution {
    public int xorOperation(int n, int start) {
        int[] nums=new int[n];
        nums[0]=start;
        int xor=start;
        for(int i=1;i<n;i++){
            nums[i]=start+2*i;
            xor^=nums[i];
        }
        return xor;
    }
}