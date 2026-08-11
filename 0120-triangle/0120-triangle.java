class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        return solve(0, 0, triangle, dp, visited);
    }

    public int solve(int i, int j, List<List<Integer>> triangle,
                     int[][] dp, boolean[][] visited) {

        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (visited[i][j]) {
            return dp[i][j];
        }

        int down = triangle.get(i).get(j)
                + solve(i + 1, j, triangle, dp, visited);

        int diagonal = triangle.get(i).get(j)
                + solve(i + 1, j + 1, triangle, dp, visited);

        visited[i][j] = true;

        return dp[i][j] = Math.min(down, diagonal);
    }
}