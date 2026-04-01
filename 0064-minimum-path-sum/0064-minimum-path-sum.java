class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int result[][] = new int[r+1][c+1];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
       for(int i=0; i<r; i++)
            for(int j=0; j<c; j++)
                result[i][j]=grid[i][j];
        
        for(int i=1; i<r; i++)
            result[i][0]= result[i-1][0]+result[i][0];
        
        for(int i=1; i<c; i++)
            result[0][i]= result[0][i-1]+result[0][i];

        for(int i=1; i<r; i++)
            for(int j=1; j<c; j++)
                result[i][j]= (result[i][j] + Math.min(result[i-1][j], result[i][j-1]));
        
        return result[r-1][c-1];
}
}