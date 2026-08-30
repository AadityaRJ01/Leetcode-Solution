class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD=1_000_000_007;
        List<int[]>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] road:roads){
            int u=road[0];
            int v=road[1];
            int time=road[2];
            graph[u].add(new int[]{v,time});
            graph[v].add(new int[]{u,time});
        }
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        long[] ways=new long[n];
        dist[0]=0;
        ways[0]=1;
        PriorityQueue<long[]> pq =
            new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0])
            );
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            long d=curr[0];
            int node=(int)curr[1];
            if(d>dist[node]){
                continue;
            }
            for(int[] edge:graph[node]){
                int next=edge[0];
                int weight=edge[1];
                long newDist=d+weight;
                if(newDist<dist[next]){
                    dist[next]=newDist;
                    ways[next]=ways[node];
                    pq.offer(new long[]{newDist,next});
                }
                else if(newDist==dist[next]){
                    ways[next]=(ways[next]+ways[node])%MOD;
                }
            }
        }
        return (int)ways[n-1];
    }
}