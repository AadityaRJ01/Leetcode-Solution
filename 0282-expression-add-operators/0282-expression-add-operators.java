class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, String path, String num,
                           int target, int pos, long value, long prev) {

        if (pos == num.length()) {
            if (value == target)
                result.add(path);
            return;
        }

        for (int i = pos; i < num.length(); i++) {

            if (i != pos && num.charAt(pos) == '0')
                break;

            long curr = Long.parseLong(num.substring(pos, i + 1));

            if (pos == 0) {
                backtrack(result, path + curr, num, target, i + 1, curr, curr);
            } else {

                backtrack(result, path + "+" + curr,
                        num, target, i + 1, value + curr, curr);

                backtrack(result, path + "-" + curr,
                        num, target, i + 1, value - curr, -curr);

                backtrack(result, path + "*" + curr,
                        num, target, i + 1,
                        value - prev + prev * curr,
                        prev * curr);
            }
        }
    }
}