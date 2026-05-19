import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {

            int diff = arr[i + 1] - arr[i];

            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        for (int i = 0; i < arr.length-1; i++) {

            int diff = arr[i + 1] - arr[i];

            if (diff == minDiff) {
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return ans;
    }
}