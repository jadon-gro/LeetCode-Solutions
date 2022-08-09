package src;
// Time Complexity: O(n)

class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode curr1 = list1;
      ListNode curr2 = list2;
      ListNode answer = new ListNode(-1);
      ListNode curr = answer;
      while (true) {
          if(curr1 == null && curr2 == null) {
              break;
          }
          if(curr1 == null || (curr2 != null && curr1.val > curr2.val)) {
              curr.next = new ListNode(curr2.val);
              curr = curr.next;
              curr2 = curr2.next;
              
          } else {
              curr.next = new ListNode(curr1.val);
              curr = curr.next;
              curr1 = curr1.next;
          }
      }
      return answer.next;
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}