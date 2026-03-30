class Solution {
    public String foreignDictionary(String[] words) {
        if (words == null || words.length == 0) return "";

        // 1) Collect all unique characters (keep deterministic order)
        LinkedHashSet<Character> chars = new LinkedHashSet<>();
        for (String w : words) {
            for (char c : w.toCharArray()) chars.add(c);
        }

        // 2) Map chars -> node ids
        Map<Character, Integer> id = new HashMap<>();
        List<Character> rev = new ArrayList<>();
        int idx = 0;
        for (char c : chars) {
            id.put(c, idx++);
            rev.add(c);
        }

        int V = idx;
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // optional: avoid duplicate edges
        boolean[][] hasEdge = new boolean[V][V];

        // 3) Build graph from adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            int len = Math.min(s1.length(), s2.length());
            int j = 0;
            while (j < len && s1.charAt(j) == s2.charAt(j)) j++;

            // Prefix invalid case: "abc" before "ab" is impossible
            if (j == len && s1.length() > s2.length()) {
                return "";
            }

            // First differing character gives ordering constraint
            if (j < len) {
                int u = id.get(s1.charAt(j));
                int v = id.get(s2.charAt(j));
                if (!hasEdge[u][v]) {
                    adj.get(u).add(v);
                    hasEdge[u][v] = true;
                }
            }
        }

        // 4) Topo sort (DFS). If cycle -> invalid -> ""
        List<Integer> order = topoSort(V, adj);
        if (order == null) return "";

        // 5) Build answer
        StringBuilder sb = new StringBuilder();
        for (int node : order) sb.append(rev.get(node));
        return sb.toString();
    }

    // Returns topo order, or null if cycle exists
    private List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] state = new int[V]; // 0=unvisited, 1=visiting, 2=done
        List<Integer> post = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (state[i] == 0) {
                if (!dfs(i, adj, state, post)) return null; // cycle
            }
        }

        Collections.reverse(post); // reverse postorder = topo order
        return post;
    }

    private boolean dfs(int u, List<List<Integer>> adj, int[] state, List<Integer> post) {
        state[u] = 1; // visiting
        for (int v : adj.get(u)) {
            if (state[v] == 1) return false;          // back-edge => cycle
            if (state[v] == 0 && !dfs(v, adj, state, post)) return false;
        }
        state[u] = 2; // done
        post.add(u);
        return true;
    }
}

