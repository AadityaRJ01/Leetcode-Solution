
class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        long suffixSum = 0;

        for (int num : nums) {
            suffixSum += num;
        }

        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            suffixSum -= nums[i];

            int elements = n - i - 1;

            if ((long) nums[i] * elements > suffixSum) {
                count++;
            }
        }

        return count;
    }
}