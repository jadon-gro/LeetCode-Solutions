package src.Medium;
// Time Complexity: O(n)
// One pass

import java.util.*;
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
      
      int counter = 0;
      ListNode curr = head;
      Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
      while (curr != null) {
          map.put(counter, curr);
          curr = curr.next;
          counter++;
      }
      curr = map.get(counter - n - 1);
      if (curr == null) return head.next;
      curr.next = curr.next.next;
      return head;
  }
}