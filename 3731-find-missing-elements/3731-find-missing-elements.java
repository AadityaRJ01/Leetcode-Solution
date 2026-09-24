class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int minNum=Integer.MAX_VALUE;
        int maxNum=Integer.MIN_VALUE;
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            minNum=Math.min(minNum,num);
            maxNum=Math.max(maxNum,num);
            set.add(num);
        }
        while(minNum<maxNum){
            minNum++;
            if(!set.contains(minNum)){
                ans.add(minNum);
            }
        }
        return ans;
    }
}