class Solution {

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>(
                    (a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());

        StringBuilder ans = new StringBuilder();

        while(!maxHeap.isEmpty()) {

            Map.Entry<Character, Integer> entry = maxHeap.poll();

            for(int i = 0; i < entry.getValue(); i++)
                ans.append(entry.getKey());
        }

        return ans.toString();
    }
}