class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();

        char[][] board=new char[n][n];
        for(char[] row:board) Arrays.fill(row,'.');
        boolean[] col=new boolean[n];
        boolean[] diag1=new boolean[2*n-1];
        boolean[] diag2=new boolean[2*n-1];
        backtrack(0,board,res,col,diag1,diag2,n);
        return res;
    }
    private void backtrack(int row, char[][] board, List<List<String>> res,boolean[] col, boolean[] diag1, boolean[] diag2, int n){
        if(row==n){
            List<String> temp=new ArrayList<>();
            for(char[] r:board){
                temp.add(new String(r));
            }
            res.add(temp);
            return;
        }
        for(int c=0;c<n;c++){
            if(col[c]|| diag1[row+c]|| diag2[row-c+n-1])
            continue;

            board[row][c]='Q';
            col[c]=diag1[row+c]=diag2[row-c+n-1]=true;

            backtrack(row+1,board,res,col,diag1,diag2,n);
            board[row][c]='.';
            col[c]=diag1[row+c]=diag2[row-c+n-1]=false;;

        }
    }
}