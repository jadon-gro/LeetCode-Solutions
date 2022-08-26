package src.Medium;
// Time Complexity: O(n)
// Space Complexity: O(h) h = height

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

class Solution {
  public boolean isValidBST(TreeNode root) {
      return recursiveHelper(root).valid;
  }
  
  public SubtreeStats recursiveHelper(TreeNode curr) {
      if (curr == null) {
          return new SubtreeStats(null, null, true);
      }
      SubtreeStats left = recursiveHelper(curr.left);
      SubtreeStats right = recursiveHelper(curr.right);
      if (!left.valid || !right.valid || left.max != null && left.max >= curr.val || right.min != null && right.min <= curr.val) return new SubtreeStats(0,0,false);
      return new SubtreeStats(left.min == null ? curr.val : Math.min(curr.val, left.min), right.max == null ? curr.val : Math.max(curr.val, right.max), true);
  }
}

class SubtreeStats {
  Integer min;
  Integer max;
  boolean valid;
  SubtreeStats (Integer min, Integer max, boolean valid) {
      this.min = min;
      this.max = max;
      this.valid = valid;
  }
}