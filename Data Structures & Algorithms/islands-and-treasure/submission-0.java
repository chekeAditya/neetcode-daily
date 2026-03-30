class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();

        // 1) Add all gates (0) as BFS sources
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // 2) BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];

                // boundary + wall check
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (grid[nx][ny] == -1) continue;

                // only update empty rooms (INF)
                if (grid[nx][ny] == Integer.MAX_VALUE) {
                    grid[nx][ny] = grid[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
/*
[ 
    2147483647, -1,        0,          2147483647,
    2147483647, 2147483647,2147483647, -1,
    2147483647, -1,        2147483647, 0,
    0,          -1,        2147483647, 2147483647
*/
