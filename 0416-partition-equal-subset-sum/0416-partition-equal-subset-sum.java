class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;

        for (int x : nums)
            total += x;

        if (total % 2 != 0)
            return false;

        int target = total / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return solve(nums, nums.length - 1, target, dp);
    }

    private boolean solve(int[] nums, int index, int target, Boolean[][] dp) {
        if (target == 0)
            return true;

        if (index == 0)
            return nums[0] == target;

        if (dp[index][target] != null)
            return dp[index][target];

        boolean notPick = solve(nums, index - 1, target, dp);

        boolean pick = false;

        if (nums[index] <= target) {
            pick = solve(nums, index - 1,
                        target - nums[index], dp);
        }

        return dp[index][target] = pick || notPick;
    }
}