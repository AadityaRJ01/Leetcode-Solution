class Solution {

    class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int a, int b) {

            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB)
                return false;

            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            } else {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }

            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            if (!uf.union(u, v)) {
                return edge;
            }
        }

        return new int[0];
    }
}