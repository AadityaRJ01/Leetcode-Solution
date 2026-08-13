class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        int start = 0;
        for (int i = 0; i <= sb.length(); i++) {
            if (i == sb.length() || sb.charAt(i) == ' ') {
                int left = start;
                int right = i - 1;
                while (left < right) {
                    char temp = sb.charAt(left);
                    sb.setCharAt(left, sb.charAt(right));
                    sb.setCharAt(right, temp);
                    left++;
                    right--;
                }
                start = i + 1;
            }
        }
        return sb.toString();
    }
}