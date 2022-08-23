package src.Medium;
// Time Complexity: O(n)
class Solution {
  int p;
  int q;
  TreeNode response = null;
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      this.p = p.val;
      this.q = q.val;
      seen(root);
      return response;
  }
  public boolean seen(TreeNode curr) {
      if (curr == null) return false;
      boolean inLeft = seen(curr.left);
      boolean inRight = seen(curr.right);
      boolean inCurr = curr.val == p || curr.val == q;
      if (inRight && inLeft || inCurr && (inRight || inLeft)) {
          response = curr;
          return false;
      }
      if (inCurr || inRight || inLeft) {
          return true;
      }
      return false;
  }
}