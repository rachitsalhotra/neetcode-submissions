class DSU {
    private int[] parent, size;

    public DSU(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        if (node != parent[node]) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            return false;
        }
        if (size[pu] >= size[pv]) {
            size[pu] += size[pv];
            parent[pv] = pu;
        } else {
            size[pv] += size[pu];
            parent[pu] = pv;
        }
        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            if (!dsu.union(edges[i][0], edges[i][1])) {
                return new int[] {edges[i][0], edges[i][1]};
            }
        }
        return new int[0];
    }
}
