class Solution {
    public int maximumUniqueSubarray(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        int n = nums.length;
        int sum = 0;
        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {

            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            sum += nums[right];

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}