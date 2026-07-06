class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        int[] freq = new int[26];

        for (char c : s1.toCharArray())
            freq[c - 'a']++;

        int left = 0;
        int count = s1.length();

        for (int right = 0; right < s2.length(); right++) {

            char ch = s2.charAt(right);

            if (freq[ch - 'a'] > 0)
                count--;

            freq[ch - 'a']--;

            // Keep window size equal to s1.length()
            if (right - left + 1 > s1.length()) {

                char leftChar = s2.charAt(left);

                freq[leftChar - 'a']++;

                if (freq[leftChar - 'a'] > 0)
                    count++;

                left++;
            }

            if (count == 0)
                return true;
        }

        return false;
    }
}