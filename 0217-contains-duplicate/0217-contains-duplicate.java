class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> map=new HashSet<>();
        for(int a:nums){
            if(map.contains(a)){
                return true;
            }
            map.add(a);
        }
        return false;
    }
}