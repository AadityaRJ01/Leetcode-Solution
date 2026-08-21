class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        Integer[][] dp = new Integer[n][n + 1];

        solve(nums, 0, -1, dp);

        List<Integer> ans = new ArrayList<>();

        int ind = 0;
        int prev = -1;

        while (ind < n) {
            int notTake = solve(nums, ind + 1, prev, dp);

            if (prev == -1 || nums[ind] % nums[prev] == 0) {
                int take = 1 + solve(nums, ind + 1, ind, dp);

                if (take >= notTake) {
                    ans.add(nums[ind]);
                    prev = ind;
                }
            }

            ind++;
        }

        return ans;
    }

    private int solve(int[] nums, int ind, int prev, Integer[][] dp) {
        if (ind == nums.length) {
            return 0;
        }

        if (dp[ind][prev + 1] != null) {
            return dp[ind][prev + 1];
        }

        int notTake = solve(nums, ind + 1, prev, dp);

        int take = 0;

        if (prev == -1 || nums[ind] % nums[prev] == 0) {
            take = 1 + solve(nums, ind + 1, ind, dp);
        }

        return dp[ind][prev + 1] = Math.max(notTake, take);
    }
}