class Solution {
    public int findComplement(int num) {
        int res=0;
        int place=1;
        while(num>0){
            if((num & 1)==0){
                res+=place;
            }
            num>>=1;
            place<<=1;
        }
        return res;
    }
}