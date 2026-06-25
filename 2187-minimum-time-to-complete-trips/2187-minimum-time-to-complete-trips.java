class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low=1;
        long min=Integer.MAX_VALUE;
        for(int t:time){
            min=Math.min(min,t);
        }
        long high=min*totalTrips;
        while(low<=high){
            long mid=(low+high)/2;
            if(canFinish(time,totalTrips,mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private boolean canFinish(int[] time,int totalTrips,long currentTime){
        long trips=0;
        for(int t:time){
            trips+=currentTime/t;
            if(trips>=totalTrips){
                return true;
            }
        }
        return false;
    }
}