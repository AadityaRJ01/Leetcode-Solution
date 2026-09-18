class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans=new ArrayList<>();
        while(left<=right){
            if(isSelf(left)){
                ans.add(left);
            }
            left++;
        }
        return ans;
    }
    private boolean isSelf(int num){
        int original=num;
        while(num>0){
            int digit=num%10;
            if(digit==0 || original % digit != 0){
            return false;
            }
            num=num/10;
        }
        return true;
    }
}