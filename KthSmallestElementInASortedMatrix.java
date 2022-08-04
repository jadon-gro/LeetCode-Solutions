
import java.util.*;
class Solution {
  public int kthSmallest(int[][] matrix, int k) {
      int len = matrix.length;
      int initialSize = Math.min(len, k);
      PriorityQueue<Node> pq = new PriorityQueue<Node>(initialSize, new NodeComparator());
      
      
      while(initialSize-- > 0) {
          pq.offer(new Node(matrix[0][initialSize], 0, initialSize));
      }
      
      Node curr = null;
      while(k-- > 0) {
          curr = pq.poll();
          int x = curr.getX();
          int y = curr.getY();
          if (x < len - 1) {
              pq.offer(new Node(matrix[x + 1][y], x + 1, y));
          }
      }
      return curr.getValue();
  }
}

class Node {
  private int value;
  private int x;
  private int y;
  
  public Node(int value, int x, int y) {
      this.value = value;
      this.x = x;
      this.y = y;
  }
  
  public int getValue() {return value;}
  public int getX() {return x;}
  public int getY() {return y;}
}

class NodeComparator implements Comparator<Node> {
  public int compare(Node x, Node y) {
      return x.getValue() - y.getValue();
  }
}