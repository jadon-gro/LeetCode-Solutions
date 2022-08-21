package src.Medium;
// All operations O(1) time

class MinStack {
  Node topNode;
  public MinStack() {
      topNode = null;
  }
  
  public void push(int val) {
      if (topNode == null) {
          topNode = new Node(val, val, null);
      } else {
          topNode.next = new Node(val, Math.min(val, topNode.min), topNode);
          topNode = topNode.next;
      }
  }
  
  public void pop() {
      topNode = topNode.prev;
      if (topNode != null) topNode.next = null;
  }
  
  public int top() {
      return topNode.val;
  }
  
  public int getMin() {
      return topNode.min;
  }
}

class Node {
  int min;
  int val;
  Node prev;
  Node next;
  Node (int val, int min, Node prev) {
      this.val = val;
      this.min = min;
      this.prev = prev;
      this.next = null;
  }
}