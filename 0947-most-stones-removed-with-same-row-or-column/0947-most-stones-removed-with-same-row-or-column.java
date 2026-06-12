class Solution {

    class UnionFind {

        int[] parent;
        int[] size;

        UnionFind(int n) {

            parent = new int[n];
            size = new int[n];

            for(int i=0;i<n;i++) {

                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {

            if(parent[x] != x)
                parent[x] = find(parent[x]);

            return parent[x];
        }

        void union(int a,int b) {

            int pa = find(a);
            int pb = find(b);

            if(pa == pb)
                return;

            if(size[pa] < size[pb]) {

                parent[pa] = pb;
                size[pb] += size[pa];

            } else {

                parent[pb] = pa;
                size[pa] += size[pb];
            }
        }
    }

    public int removeStones(int[][] stones) {

        int n = stones.length;

        UnionFind uf = new UnionFind(n);

        for(int i=0;i<n;i++) {

            for(int j=i+1;j<n;j++) {

                if(stones[i][0] == stones[j][0] ||
                   stones[i][1] == stones[j][1]) {

                    uf.union(i,j);
                }
            }
        }

        int components = 0;

        for(int i=0;i<n;i++) {

            if(uf.find(i) == i)
                components++;
        }

        return n - components;
    }
}