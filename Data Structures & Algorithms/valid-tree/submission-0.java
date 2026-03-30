class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] vec : edges) {
            int a = vec[0], b = vec[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        if (!dfs(adj, 0, visited, -1)) return false;

        for (boolean a : visited) {
            if (!a) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int u, boolean[] visited, int parent) {
        if (visited[u]) return false;
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (v == parent) continue;
            if (!dfs(adj, v, visited, u)) return false;
        }
        return true;
    }
}
