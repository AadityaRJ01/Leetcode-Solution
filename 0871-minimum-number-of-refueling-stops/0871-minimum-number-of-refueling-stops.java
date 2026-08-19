class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int fuel=startFuel;
        int prev=0;
        int stops=0;

        for(int[] station:stations){
            int pos=station[0];
            int gas=station[1];
            fuel-=pos-prev;
            while(fuel<0 && !pq.isEmpty()){
                fuel+=pq.poll();
                stops++;
            }
            if(fuel<0){
                return -1;
            }
            pq.offer(gas);
            prev=pos;
        }
        fuel-=target-prev;
        while(fuel<0 && !pq.isEmpty()){
            fuel+=pq.poll();
            stops++;
        }
        return fuel>=0?stops:-1;
    }
}