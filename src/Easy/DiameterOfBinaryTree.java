package src.Easy;
// Time Complexity: O(n)



class Solution {
  public int diameterOfBinaryTree(TreeNode root) {
      return diameterRecursive(root).max;
  }
  public Package diameterRecursive(TreeNode curr) {
      if (curr == null) {
          return new Package(0, 0);
      }
      Package l = diameterRecursive(curr.left);
      Package r = diameterRecursive(curr.right);
      
      return new Package(Math.max(l.height + r.height, Math.max(l.max, r.max)), Math.max(l.height, r.height) + 1);
  }
}

class Package {
  int max;
  int height;
  Package (int max, int height) {
      this.max = max;
      this.height = height;
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