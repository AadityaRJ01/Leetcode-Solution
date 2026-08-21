class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;
        Integer[][] dp = new Integer[n][n + 1];

        return solve(words, 0, -1, dp);
    }

    private int solve(String[] words, int ind, int prev, Integer[][] dp) {
        if (ind == words.length) {
            return 0;
        }

        if (dp[ind][prev + 1] != null) {
            return dp[ind][prev + 1];
        }

        int notTake = solve(words, ind + 1, prev, dp);

        int take = 0;

        if (prev == -1 || isPredecessor(words[prev], words[ind])) {
            take = 1 + solve(words, ind + 1, ind, dp);
        }

        return dp[ind][prev + 1] = Math.max(take, notTake);
    }

    private boolean isPredecessor(String s, String t) {
        if (t.length() != s.length() + 1) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}