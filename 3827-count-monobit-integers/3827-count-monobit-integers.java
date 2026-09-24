class Solution {
    public int countMonobit(int n) {
        int count = 1;
        int num = 1;
        while (num <= n) {
            count++;
            num = (num << 1) | 1;
        }
        return count;
    }
}