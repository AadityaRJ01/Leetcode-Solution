class Solution {

    private int countSubarrays(int[] nums, int maxSum) {

        int subarrays = 1;
        int sum = 0;

        for (int num : nums) {

            if (sum + num > maxSum) {
                subarrays++;
                sum = num;
            } else {
                sum += num;
            }
        }

        return subarrays;
    }

    public int splitArray(int[] nums, int k) {

        int max = 0;
        int sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int low = max;
        int high = sum;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (countSubarrays(nums, mid) <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}