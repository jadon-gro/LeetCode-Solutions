package src.Medium;
// Time Complexity: O(n)
// In place!

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n >> 1; i++) { // ix is the column (second val)
            for (int j = i; j < n - i - 1; j++) { // jy  is the row (first val)
                int temp = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = matrix[j][i];
                int temp2 = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
                temp = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp2;
                matrix[j][i] = temp;
                
            }
        }
    }
}