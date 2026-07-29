class Solution {

    class DualHeap {

        PriorityQueue<Integer> small;
        PriorityQueue<Integer> large; 

        HashMap<Integer, Integer> delayed;

        int smallSize;
        int largeSize;
        int k;

        public DualHeap(int k) {

            this.k = k;

            small = new PriorityQueue<>(Collections.reverseOrder());

            large = new PriorityQueue<>();

            delayed = new HashMap<>();

            smallSize = 0;
            largeSize = 0;
        }

        private void prune(PriorityQueue<Integer> heap) {

            while (!heap.isEmpty()) {

                int num = heap.peek();

                if (delayed.containsKey(num)) {

                    delayed.put(num, delayed.get(num) - 1);

                    if (delayed.get(num) == 0)
                        delayed.remove(num);

                    heap.poll();

                } else {
                    break;
                }
            }
        }

        private void makeBalance() {

            if (smallSize > largeSize + 1) {

                large.offer(small.poll());

                smallSize--;
                largeSize++;

                prune(small);

            } else if (smallSize < largeSize) {

                small.offer(large.poll());

                smallSize++;
                largeSize--;

                prune(large);
            }
        }

        public void insert(int num) {

            if (small.isEmpty() || num <= small.peek()) {

                small.offer(num);

                smallSize++;

            } else {

                large.offer(num);

                largeSize++;
            }

            makeBalance();
        }

        public void erase(int num) {

            delayed.put(num, delayed.getOrDefault(num, 0) + 1);

            if (num <= small.peek()) {

                smallSize--;

                if (num == small.peek())
                    prune(small);

            } else {

                largeSize--;

                if (!large.isEmpty() && num == large.peek())
                    prune(large);
            }

            makeBalance();
        }

        public double getMedian() {

            if (k % 2 == 1)
                return small.peek();

            return ((long) small.peek() + (long) large.peek()) / 2.0;
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        DualHeap dh = new DualHeap(k);

        double[] ans = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++)
            dh.insert(nums[i]);

        ans[0] = dh.getMedian();

        for (int i = k; i < nums.length; i++) {

            dh.insert(nums[i]);

            dh.erase(nums[i - k]);

            ans[i - k + 1] = dh.getMedian();
        }

        return ans;
    }
}