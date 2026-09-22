
import java.util.Arrays;

class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        double minNum = Double.MAX_VALUE;

        while (left < right) {
            double avg = ((long) nums[left] + nums[right]) / 2.0;

            minNum = Math.min(minNum, avg);

            left++;
            right--;
        }

        return minNum;
    }
}