class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }
        int ans = 0;

        while (k-- > 0) {
            int[] curr = minHeap.poll();
            int value = curr[0];
            int row = curr[1];
            int col = curr[2];

            ans = value;
            if (col + 1 < n) {
                minHeap.offer(
                    new int[]{matrix[row][col + 1], row, col + 1}
                );
            }
        }
        return ans;
    }
}