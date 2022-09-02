package src.Medium;
// Time Complexity: O(n)
// In place!

import java.util.Arrays;
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;
        for (int col = 0; col < n; col++) {
            if (matrix[0][col] == 0) row0 = true;
        }
        for (int row = 0; row < m; row++) {
            if (matrix[row][0] == 0) col0 = true;
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        
        for (int row = 1; row < m; row++) {
            if (matrix[row][0] == 0) {
                Arrays.fill(matrix[row], 0);
            }
        }
        for (int col = 1; col < n; col++) {
            if (matrix[0][col] == 0) {
                for(int row = 0; row < m; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        if (row0) {
            for (int col = 0; col < n; col++) {
                matrix[0][col] = 0;
            }
        }
        if (col0) {
            for (int row = 0; row < m; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}