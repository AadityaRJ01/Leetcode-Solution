class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char task : tasks)
            freq[task - 'A']++;

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0)
                maxHeap.offer(f);
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            int cycle = n + 1;

            while (cycle > 0 && !maxHeap.isEmpty()) {

                int count = maxHeap.poll();

                count--;

                if (count > 0)
                    temp.add(count);

                time++;
                cycle--;
            }

            for (int count : temp)
                maxHeap.offer(count);

            if (maxHeap.isEmpty())
                break;

            time += cycle;
        }

        return time;
    }
}