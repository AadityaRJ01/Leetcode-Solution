class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortArr=arr.clone();
        Arrays.sort(sortArr);
        HashMap<Integer,Integer> rM=new HashMap<>();
        int rank=1;
        for(int num:sortArr){
            if(!rM.containsKey(num)){
                rM.put(num,rank);
                rank++;
            }
        }
        int[] res=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i]=rM.get(arr[i]);
        }
        return res;

    }
}