package src.Medium;
// Time Complexity: O(n)

class Solution {
  public TreeNode pruneTree(TreeNode root) {
      if (prune(root)) return null;
      return root;
  }
  
  public boolean prune(TreeNode curr) {
      if (curr == null) return true;
      if (curr.left == null && curr.right == null) {
          return curr.val == 0;
      }
      boolean left = prune(curr.left);
      boolean right = prune(curr.right);
      if (left && right) {
          if(curr.val == 0) return true;
          else {
              curr.right = null;
              curr.left = null;
              return false;
          }
      } else if (left) {
          curr.left = null;
          return false;
      } else if (right) {
          curr.right = null;
          return false;
      } else {
          return false;
      }
  }
}