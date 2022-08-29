package src.Medium;
// Time Complexity: O(n)

import java.util.*;
class Solution {
  int preorderIndex;
  Map<Integer,Integer> inorderIndexMap;
  int[] preorder;
  public TreeNode buildTree(int[] preorder, int[] inorder) {
      if (preorder.length == 0) return null;
      this.preorder = preorder;
      inorderIndexMap = new HashMap<Integer, Integer>();
      preorderIndex = 0;
      for (int i = 0; i < inorder.length; i++) inorderIndexMap.put(inorder[i],i);
      return recursiveHelper(0, preorder.length - 1);
  }
  public TreeNode recursiveHelper(int left, int right) {
      if (right < left) return null;
      TreeNode root = new TreeNode(preorder[preorderIndex++]);
      root.left = recursiveHelper(left, inorderIndexMap.get(root.val) - 1);
      root.right = recursiveHelper(inorderIndexMap.get(root.val) + 1, right);
      return root;
  }
}