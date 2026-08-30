class Solution {

    public int largestIsland(int[][] grid) {

        int n = grid.length;
        Map<Integer, Integer> size = new HashMap<>();
        int id = 2;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int islandSize = dfs(grid, i, j, id);
                    size.put(id, islandSize);
                    ans = Math.max(ans, islandSize);
                    id++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    if (i > 0)
                        set.add(grid[i - 1][j]);
                    if (i < n - 1)
                        set.add(grid[i + 1][j]);

                    if (j > 0)
                        set.add(grid[i][j - 1]);

                    if (j < n - 1)
                        set.add(grid[i][j + 1]);

                    int current = 1;

                    for (int islandId : set) {
                        if (islandId > 1) {
                            current += size.get(islandId);
                        }
                    }
                    ans = Math.max(ans, current);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int r, int c, int id) {
        int n = grid.length;
        if (r < 0 || r >= n ||
            c < 0 || c >= n ||
            grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = id;
        return 1
            + dfs(grid, r - 1, c, id)
            + dfs(grid, r + 1, c, id)
            + dfs(grid, r, c - 1, id)
            + dfs(grid, r, c + 1, id);
    }
}