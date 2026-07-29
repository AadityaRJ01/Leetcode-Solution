class Solution {

    public String reorganizeString(String s) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder ans = new StringBuilder();

        int[] prev = null;

        while (!maxHeap.isEmpty()) {

            int[] curr = maxHeap.poll();

            ans.append((char)(curr[0] + 'a'));

            curr[1]--;

            if (prev != null && prev[1] > 0) {
                maxHeap.offer(prev);
            }

            prev = curr;
        }

        if (ans.length() != s.length())
            return "";

        return ans.toString();
    }
}