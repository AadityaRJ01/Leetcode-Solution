class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int pile:piles){
            high=Math.max(high,pile);
        }
        int ans=high;
        while(low<=high){
            int mid=(low+high)/2;
            long tHours=0;
            for(int pile:piles){
                tHours+= (int) Math.ceil((double) pile/mid);
            }
            if(tHours<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}