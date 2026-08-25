class Solution {
    public List<String> validStrings(int n) {
        List<String> ans=new ArrayList<>();
        backtrack(n,"",ans);
        return ans;
    }
    public void backtrack(int n,String s,List<String> ans){
        if(s.length()==n){
            ans.add(s);
            return;
        }
        backtrack(n,s+"1",ans);
        if(s.length()==0 || s.charAt(s.length()-1)!='0'){
            backtrack(n,s+"0",ans);
        }
    }
}