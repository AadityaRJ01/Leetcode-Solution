class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
            if (isVowel(s.charAt(i + n / 2))) {
                count--;
            }
        }
        return count == 0;
    }
    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}
