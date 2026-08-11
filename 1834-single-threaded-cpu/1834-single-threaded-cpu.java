class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{
                tasks[i][0],
                tasks[i][1],
                i
            };
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
        );
        int[] ans = new int[n];

        int time = 0;
        int i = 0;
        int count = 0;
        while (count < n) {
            if (pq.isEmpty() && time < arr[i][0]) {
                time = arr[i][0];
            }
            while (i < n && arr[i][0] <= time) {
                pq.offer(new int[]{
                    arr[i][1],
                    arr[i][2]
                });
                i++;
            }

            int[] curr = pq.poll();
            ans[count++] = curr[1];
            time += curr[0];
        }
        return ans;
    }
}