package src.Easy;
//Time Complexity: O(n)

class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      return floodFillRecursive(image, sr, sc, color, image[sr][sc]);
      
  }
  
  public int[][] floodFillRecursive(int[][] image, int r, int c, int color, int repColor) {
      image[r][c] = color;
      if (color == repColor) return image;
      if(image.length > r + 1 && image[r+1][c] == repColor) {
          floodFillRecursive(image, r+1, c, color, repColor);
      }
      if(image[r].length > c + 1 && image[r][c+1] == repColor) {
          floodFillRecursive(image, r, c+1, color, repColor);
      }
      if(r > 0 && image[r-1][c] == repColor) {
          floodFillRecursive(image, r-1, c, color, repColor);
      }
      if(c > 0 && image[r][c-1] == repColor) {
          floodFillRecursive(image, r, c-1, color, repColor);
      }
      return image;
  }
}
