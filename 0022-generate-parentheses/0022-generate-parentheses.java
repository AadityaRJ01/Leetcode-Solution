class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(n,0,0,res,"");
        return res;
    }
    private void backtrack(int n,int open,int close,List<String> ans,String s){
        if(open==n && close==n){
            ans.add(s);
            return;
        }
        if(open<n){
            backtrack(n,open+1,close,ans,s+"(");
        }
        if(close<open){
            backtrack(n,open,close+1,ans,s+")");
        }
    }
}