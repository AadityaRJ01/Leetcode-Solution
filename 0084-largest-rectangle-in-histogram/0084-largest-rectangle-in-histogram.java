import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && h < heights[st.peek()]) {
                int top = st.pop();
                int height = heights[top];
                int width;
                if (st.isEmpty()) {
                    width = i; 
                } else {
                    width = i - st.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }

    // Quick test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestRectangleArea(new int[]{2,1,5,6,2,3})); // expected 10
        System.out.println(s.largestRectangleArea(new int[]{2,4})); // expected 4
        System.out.println(s.largestRectangleArea(new int[]{})); // expected 0
    }
}
