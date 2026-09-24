
class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int num : nums) {
            // Update smallest
            smallest = Math.min(smallest, num);

            // Update two largest values
            if (num >= largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }

        return largest + secondLargest - smallest;
    }
}