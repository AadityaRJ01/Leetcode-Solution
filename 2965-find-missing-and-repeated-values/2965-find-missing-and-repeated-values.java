class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int N=n*n;

        long actSum=0;
        long actSquareSum=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num=grid[i][j];
                actSum+=num;
                actSquareSum+=(long)num*num;
            }
        }
        long expectSum=(long) N*(N+1)/2;
        long expectSquareSum=(long) N*(N+1)*(2L*N+1)/6;

        long diff=actSum-expectSum;
        long squareDiff=actSquareSum-expectSquareSum;

        long sum=squareDiff/diff;

        int repeated=(int)((sum+diff)/2);
        int missing=(int)((sum-diff)/2);

        return new int[]{repeated,missing};
    }
}