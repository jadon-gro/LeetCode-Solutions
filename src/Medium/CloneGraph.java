package src.Medium;
// Time Complexity: O(n+m)
// Where n is number of nodes and m is number of edges

import java.util.*;


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {
  public Node cloneGraph(Node node) {
      if (node == null) {
          return null;
      }
      HashMap<Node, Node> visited = new HashMap<Node, Node>();
      return cloneNode(node, visited);
  }
  public Node cloneNode(Node node, HashMap<Node, Node> visited) {
      if (visited.containsKey(node)) {
          return visited.get(node);
      }
      Node copy = new Node(node.val);
      visited.put(node, copy);
      for (Node neighbor : node.neighbors) {
          copy.neighbors.add(cloneNode(neighbor, visited));
      }
      return copy;
  }
}