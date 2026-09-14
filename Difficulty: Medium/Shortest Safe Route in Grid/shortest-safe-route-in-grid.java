import java.util.*;

class Solution {
    public int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] unsafe = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Step 1: mark landmines and their neighbors as unsafe
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    unsafe[i][j] = true;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d], nj = j + dy[d];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            unsafe[ni][nj] = true;
                        }
                    }
                }
            }
        }

        // Step 2: multi-source BFS from all safe cells in leftmost column
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!unsafe[i][0]) {
                dist[i][0] = 1;              // <-- start count at 1, not 0
                queue.add(new int[]{i, 0});
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if (y == m - 1) {
                return dist[x][y];           // total cells in path
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && !unsafe[nx][ny] && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }
}