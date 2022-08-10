package src.Easy;
//Time Complexity O(n)

class Solution {
  public ListNode middleNode(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      while (true) {
          if (fast.next == null) {
              return slow;
          }
          ListNode nextNext = fast.next.next;
          ListNode next = slow.next;
          if (nextNext == null) {
              return next;
          }
          slow = next;
          fast = nextNext;
      }
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}