class Solution {
    public int secondHighest(String s) {
        int largest = -1;
        int secondLargest = -1;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                int num = ch - '0';

                if (num > largest) {
                    secondLargest = largest;
                    largest = num;
                }
                else if (num < largest && num > secondLargest) {
                    secondLargest = num;
                }
            }
        }

        return secondLargest;
    }
}
