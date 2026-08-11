class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        Integer[][] dp = new Integer[n][n];
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, solve(0, j, matrix, n, dp));
        }
        return ans;
    }
    public int solve(int i, int j, int[][] matrix, int n, Integer[][] dp) {
        if (i == n - 1) {
            return matrix[i][j];
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int down = solve(i + 1, j, matrix, n, dp);
        int downL = Integer.MAX_VALUE;
        if (j > 0) {
            downL = solve(i + 1, j - 1, matrix, n, dp);
        }
        int downR = Integer.MAX_VALUE;
        if (j < n - 1) {
            downR = solve(i + 1, j + 1, matrix, n, dp);
        }
        return dp[i][j] = matrix[i][j] + Math.min(down, Math.min(downL, downR));
    }
}