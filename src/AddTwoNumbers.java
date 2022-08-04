package src;
// Time Complexity: O(n)

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode answer = new ListNode();
      ListNode curr = answer;
      ListNode curr1 = l1;
      ListNode curr2 = l2;
      int carry = 0;
      while (curr1 != null || curr2 != null) {
          int val1;
          int val2;
          if (curr1 == null) {
              val1 = 0;
          } else {
              val1 = curr1.val;
          }
          if (curr2 == null) {
              val2 = 0;
          } else {
              val2 = curr2.val;
          }
          
          int sum = val1 + val2 + carry;
          if (sum >= 10) {
              carry = 1;
              sum -= 10;
          } else {
              carry = 0;
          }
          curr.val = sum;
          
          if (curr1 != null) {
              curr1 = curr1.next;
          }
          if (curr2 != null) {
              curr2 = curr2.next;
          }
          if (curr1 == null && curr2 == null) {
              if (carry == 1) {
                  curr.next = new ListNode(1);
              }
          } else {
              curr.next = new ListNode();
          }
          curr = curr.next;
          
      }
      return answer;
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}