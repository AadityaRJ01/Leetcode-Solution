class Solution {

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            int[] current = pq.poll();
            int effort = current[0];
            int r = current[1];
            int c = current[2];
            if (r == n - 1 && c == m - 1) {
                return effort;
            }

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m) {

                    int edgeDiff =
                        Math.abs(heights[r][c] -
                                 heights[nr][nc]);
                    int newEffort =
                        Math.max(effort, edgeDiff);
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.offer(
                            new int[]{newEffort, nr, nc}
                        );
                    }
                }
            }
        }
        return 0;
    }
}