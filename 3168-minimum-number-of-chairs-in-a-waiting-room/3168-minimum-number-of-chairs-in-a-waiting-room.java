
class Solution {
    public int minimumChairs(String s) {
        int people = 0;
        int chairs = 0;

        for (char c : s.toCharArray()) {
            if (c == 'E') {
                people++;
                chairs = Math.max(chairs, people);
            } else {
                people--;
            }
        }

        return chairs;
    }
}