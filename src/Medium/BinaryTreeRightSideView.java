package src.Medium;
// Time Complexity: O(n)

import java.util.*;
class Solution {
  List<Integer> response;
  int maxHeight;
  public List<Integer> rightSideView(TreeNode root) {
      response = new ArrayList<Integer>();
      maxHeight = 0;
      recursiveHelper(root, 1);
      return response;
  }
  public void recursiveHelper(TreeNode curr, int height) {
      if (curr == null) return;
      if (height > maxHeight){
          response.add(curr.val);
          maxHeight = height;
      }
      recursiveHelper(curr.right, height + 1);
      recursiveHelper(curr.left, height + 1);
  }
}