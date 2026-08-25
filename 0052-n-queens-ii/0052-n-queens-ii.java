class Solution {
     int count=0;
    public int totalNQueens(int n) {
        boolean[] col=new boolean[n];
        boolean[] diag1=new boolean[2*n-1];
        boolean[] diag2=new boolean[2*n-1];
        backtrack(0,col,diag1,diag2,n);
        return count;
    }
    private void backtrack(int row,boolean[] col, boolean[] diag1, boolean[] diag2, int n){
        if(row==n){
            count++;
            return;
        }
        for(int c=0;c<n;c++){
            if(col[c]|| diag1[row+c]|| diag2[row-c+n-1])
            continue;
            col[c]=diag1[row+c]=diag2[row-c+n-1]=true;
            backtrack(row+1,col,diag1,diag2,n);
            col[c]=diag1[row+c]=diag2[row-c+n-1]=false;;

        }
    }
}