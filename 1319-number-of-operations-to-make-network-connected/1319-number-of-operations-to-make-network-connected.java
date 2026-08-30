class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        DSU dsu = new DSU(n);
        int components = n;

        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            if (dsu.union(u, v)) {
                components--;
            }
        }
        return components - 1;
    }
}
class DSU {

    int[] parent;
    int[] rank;

    DSU(int n) {

        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    boolean union(int u, int v) {

        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            return false;
        }
        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        }
        else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        }
        else {
            parent[pv] = pu;
            rank[pu]++;
        }
        return true;
    }
}