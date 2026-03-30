class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n == 1) return 1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] vec: edges){
            int a = vec[0], b = vec[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(adj, i, visited);
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> adj, int u, boolean[] visited){
        if(visited[u]) return;
        visited[u] = true;

        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(adj, v, visited);
            }
        }
    }
}
