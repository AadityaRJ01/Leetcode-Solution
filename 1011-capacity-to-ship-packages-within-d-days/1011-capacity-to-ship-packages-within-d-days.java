class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for(int weight : weights){
            low = Math.max(low, weight);
            high += weight;
        }

        while(low <= high){

            int mid = low + (high-low)/2;

            if(canShip(weights, days, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return low;
    }

    private boolean canShip(int[] weights, int days, int capacity){

        int usedDays = 1;
        int load = 0;

        for(int weight : weights){

            if(load + weight <= capacity){

                load += weight;

            }else{

                usedDays++;
                load = weight;
            }
        }

        return usedDays <= days;
    }
}