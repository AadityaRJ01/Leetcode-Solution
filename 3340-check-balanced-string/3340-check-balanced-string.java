class Solution {
    public boolean isBalanced(String num) {
        int n = num.length();
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sumEven += num.charAt(i) - '0';
            } else {
                sumOdd += num.charAt(i) - '0';
            }
        }
        return sumEven == sumOdd;
    }
}