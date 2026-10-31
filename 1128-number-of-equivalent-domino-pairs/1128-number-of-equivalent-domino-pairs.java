class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count=0;
        int[] freq=new int[100];
        for(int[] d:dominoes){
            int a=Math.min(d[0],d[1]);
            int b=Math.max(d[0],d[1]);
            int key=a*10+b;
            count+=freq[key];
            freq[key]++;
        }
        return count;
    }
}