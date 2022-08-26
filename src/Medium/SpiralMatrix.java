package src.Medium;
// Time Complexity: O(n)

import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean right = matrix[0].length > 1;
        boolean left = false;
        boolean down = !right;
        boolean up = false;
        List<Integer> response = new ArrayList<Integer>();
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        int i = 0;
        int j = 0;
        if (!right && matrix.length == 1) {
            response.add(matrix[0][0]);
            return response;
        }
        while (true) {
            response.add(matrix[i][j]);
            visited[i][j] = true;
            if (right) {
                j++;
                if (j + 1 == m || visited[i][j + 1]) {
                    if (i + 1 == n || visited[i + 1][j]) {
                        break;
                    }
                    right = false;
                    down = true;
                }
            } else if (down) {
                i++;
                if (i + 1 == n || visited[i + 1][j]) {
                    if (j - 1 < 0 || visited[i][j - 1]) {
                        break;
                    }
                    down = false;
                    left = true;
                }
            } else if (left) {
                j--;
                if (j - 1 < 0 || visited[i][j - 1]) {
                    if (i - 1 < 0 || visited[i - 1][j]) {
                        break;
                    }
                    left = false;
                    up = true;
                }
            } else if (up) {
                i--;
                if (i - 1 < 0 || visited[i - 1][j]) {
                    if (j + 1 == m || visited[i][j + 1]) {
                        break;
                    }
                    up = false;
                    right = true;
                }
            }
        }
        response.add(matrix[i][j]);
        return response;
    }
}
