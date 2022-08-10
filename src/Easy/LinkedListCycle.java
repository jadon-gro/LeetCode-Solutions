package src.Easy;
// Time Complexity: O(n)

import java.util.*;
class Solution {
  public boolean hasCycle(ListNode head) {
      ListNode curr = head;
      Set<ListNode> seen = new HashSet<ListNode>();
      while(true) {
          if (curr == null) return false;
          if (!seen.add(curr)) return true;
          curr = curr.next;
      }

  }
}

class ListNode {
  int val;
  ListNode next;
   ListNode(int x) {
       val = x;
       next = null;
   }
}