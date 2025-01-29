//Redundant Connection
class Solution {
    int[] parent;
    int[] rank;

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);
        
        if (x_parent == y_parent) return;
        
        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[y_parent] > rank[x_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[y_parent] = x_parent;
            rank[x_parent]++;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n+1];
        rank = new int[n+1];

        for(int i = 1 ; i <= n ; i++){
            parent[i] = i;
        }


        for(int[] con : edges){
            int u = con[0];
            int v = con[1];

            if(find(u) == find(v)){
                return con;
            }

            union(u  ,v);
        }

        return new int[]{};
    }
}