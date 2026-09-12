class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=countbits(i);
        }
        return ans;
    }
    public int countbits(int num){
        if(num==0){
            return 0;
        }
        if(num==1){
            return 1;
        }
        int count=0;
        while(num>0){
            num=num&(num-1);
            count++;
        }
        return count;
    }
}