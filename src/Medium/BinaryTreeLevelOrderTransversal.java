package src.Medium;
// Time Complexity: O(n)

import java.util.*;
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
  public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) return new ArrayList<List<Integer>>();
      List<List<Integer>> rv = new ArrayList<List<Integer>>();
      Queue<Packet> q = new LinkedList<Packet>();
      q.add(new Packet(root, 0));
      while(!q.isEmpty()){
          Packet curr = q.poll();
          int level = curr.level;
          if (level >= rv.size()) {
              rv.add(new ArrayList<Integer>());
          }
          rv.get(level).add(curr.node.val);
          if (curr.node.left != null) {
              q.add(new Packet(curr.node.left, curr.level + 1));
          }
          if (curr.node.right != null) {
              q.add(new Packet(curr.node.right, curr.level + 1));
          }
      }
      
      return rv;
  }
}

class Packet {
  int level;
  TreeNode node;
  Packet(TreeNode node, int level) {
      this.level = level;
      this.node = node;
  }
}