package src;
// Time Complexity: O(n)

class Solution {
  public TreeNode invertTree(TreeNode root) {
      return invertRecursive(root);
  }
  
  public TreeNode invertRecursive(TreeNode curr) {
      if (curr == null) {
          return curr;
      }
      TreeNode tempL = invertRecursive(curr.right);
      curr.right = invertRecursive(curr.left);
      curr.left = tempL;
      return curr;
      
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
  this.val = val;
  this.left = left;
  this.right = right;
  }
}