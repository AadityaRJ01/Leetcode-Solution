class Solution {
    public int[] decode(int[] encoded, int first) {
        int l=encoded.length;
        int[] decod=new int[l+1];
        decod[0]=first;
        for(int i=0;i<l;i++){
            decod[i+1]=decod[i]^encoded[i];
        }
        return decod;
    }
}