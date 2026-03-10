class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1000000007;
        
        Stack<Integer> stack = new Stack<>();
        int[] ple = new int[n];
        int[] nle = new int[n];
        
        // Previous Less Element
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        // Next Less Element
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        long ans = 0;
        
        for(int i=0;i<n;i++){
            long left = i - ple[i];
            long right = nle[i] - i;
            ans = (ans + arr[i] * left * right) % mod;
        }
        
        return (int)ans;
    }
}