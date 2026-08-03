class Solution {
    public int compress(char[] chars) {

        int n = chars.length;
        int read = 0;
        int write = 0;
        while (read < n) {
            char current = chars[read];
            int count = 0;
            while (read < n && chars[read] == current) {
                count++;
                read++;
            }
            chars[write++] = current;
            if (count > 1) {
                String freq = String.valueOf(count);

                for (char c : freq.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write;
    }
}