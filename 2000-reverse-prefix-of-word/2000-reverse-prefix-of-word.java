class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        int idx = word.indexOf(ch);
        if (idx == -1) return word;
        int left = 0, right = idx;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }
}
