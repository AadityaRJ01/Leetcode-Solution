class Solution {

    class UnionFind {

        int[] parent;
        int[] size;

        public UnionFind(int n) {

            parent = new int[n];
            size = new int[n];

            for(int i=0;i<n;i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {

            if(parent[x] != x)
                parent[x] = find(parent[x]);

            return parent[x];
        }

        public void union(int a, int b) {

            int rootA = find(a);
            int rootB = find(b);

            if(rootA == rootB)
                return;

            if(size[rootA] < size[rootB]) {

                parent[rootA] = rootB;
                size[rootB] += size[rootA];

            } else {

                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        UnionFind uf = new UnionFind(n);

        Map<String,Integer> emailToAccount = new HashMap<>();

        for(int i=0;i<n;i++) {

            List<String> account = accounts.get(i);

            for(int j=1;j<account.size();j++) {

                String email = account.get(j);

                if(emailToAccount.containsKey(email)) {

                    uf.union(i, emailToAccount.get(email));

                } else {

                    emailToAccount.put(email, i);
                }
            }
        }

        Map<Integer, TreeSet<String>> merged = new HashMap<>();

        for(int i=0;i<n;i++) {

            int root = uf.find(i);

            merged.putIfAbsent(root, new TreeSet<>());

            List<String> account = accounts.get(i);

            for(int j=1;j<account.size();j++) {

                merged.get(root).add(account.get(j));
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(int root : merged.keySet()) {

            List<String> curr = new ArrayList<>();

            curr.add(accounts.get(root).get(0));

            curr.addAll(merged.get(root));

            result.add(curr);
        }

        return result;
    }
}