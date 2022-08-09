package src;
// Time Complexity: O(n)

import java.util.ArrayList;
import java.util.List;
class Solution {
  public void flatten(TreeNode root) {
      if (root != null) {
          List<Integer> tree = new ArrayList<Integer>();
          preorder(root, tree);
          TreeNode current = root;
          current.left = null;
          for (int i = 1; i < tree.size(); i++) {
              current.right = new TreeNode(tree.get(i));
              current = current.right;
          }
          
      }
  }
  public void preorder(TreeNode current, List<Integer> checks) {
      if (current != null) {
          
          checks.add(current.val);
          preorder(current.left, checks);
          preorder(current.right, checks);
      }
      
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