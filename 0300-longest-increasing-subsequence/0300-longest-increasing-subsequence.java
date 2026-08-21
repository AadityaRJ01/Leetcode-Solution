class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // prev can be -1, so shift it by +1
        Integer[][] dp = new Integer[n][n + 1];

        return solve(nums, 0, -1, dp);
    }

    private int solve(int[] nums, int ind, int prev, Integer[][] dp) {

        // Base case
        if (ind == nums.length) {
            return 0;
        }

        // prev + 1 because prev can be -1
        if (dp[ind][prev + 1] != null) {
            return dp[ind][prev + 1];
        }

        // Option 1: Don't take nums[ind]
        int notTake = solve(nums, ind + 1, prev, dp);

        // Option 2: Take nums[ind]
        int take = 0;

        if (prev == -1 || nums[ind] > nums[prev]) {
            take = 1 + solve(nums, ind + 1, ind, dp);
        }

        return dp[ind][prev + 1] = Math.max(take, notTake);
    }
}