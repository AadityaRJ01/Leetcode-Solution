class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        for (int i = 1; i <= 9; i++) {       // hundreds digit

            if (freq[i] == 0) {
                continue;
            }

            freq[i]--;

            for (int j = 0; j <= 9; j++) {   // tens digit

                if (freq[j] == 0) {
                    continue;
                }

                freq[j]--;

                for (int k = 0; k <= 8; k += 2) { // units digit

                    if (freq[k] > 0) {
                        count++;
                    }
                }

                freq[j]++;
            }

            freq[i]++;
        }

        return count;
    }
}