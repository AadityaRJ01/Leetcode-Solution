class Solution {
    public int halveArray(int[] nums) {
        int count=0;
        PriorityQueue<Double> pq=new PriorityQueue<>(Collections.reverseOrder());
        double sum=0;
        for(int num:nums){
            sum+=num;
            pq.offer((double) num);
        }
        double sum2=0;
        while(sum2 < sum/2){
            double x=pq.poll();
            double half=x/2;
            sum2+=half;
            pq.offer(half);
            count++;
        }
        return count;
    }
}