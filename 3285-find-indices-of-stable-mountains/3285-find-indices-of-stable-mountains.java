class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> mount=new ArrayList<>();
        for(int i=1;i<height.length;i++){
            if(height[i-1]>threshold){
                mount.add(i);
            }
        }
        return mount;
    }
}