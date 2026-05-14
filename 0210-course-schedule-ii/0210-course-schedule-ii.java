class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        int[] inDegree=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            int course=pre[0];
            int prereq=pre[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        int[] order=new int[numCourses];
        int index=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            order[index++]=curr;

            for(int neighbor:graph.get(curr)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }
        if(index!=numCourses){
            return new int[0];
        }
        return order;
    }
}