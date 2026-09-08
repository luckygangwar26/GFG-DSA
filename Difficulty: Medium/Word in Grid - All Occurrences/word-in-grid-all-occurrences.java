import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int n = mat.length;
        int m = mat[0].length;

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    for (int[] dir : directions) {
                        if (check(mat, word, i, j, dir[0], dir[1])) {
                            ArrayList<Integer> pos = new ArrayList<>();
                            pos.add(i);
                            pos.add(j);
                            ans.add(pos);
                            break;
                        }
                    }
                }
            }
        }

        return ans;
    }

    private boolean check(char[][] mat, String word, int row, int col, int dr, int dc) {
        int n = mat.length;
        int m = mat[0].length;

        for (int k = 0; k < word.length(); k++) {
            int nr = row + k * dr;
            int nc = col + k * dc;

            if (nr < 0 || nr >= n || nc < 0 || nc >= m ||
                mat[nr][nc] != word.charAt(k)) {
                return false;
            }
        }

        return true;
    }
}