package src.Hard;
/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
      if (k <= 1) return head;
      ListNode res = head;
      for(int i = 0; i < k - 1; i++) {
          if (res == null) return head;
          res = res.next;
      }
      int len = k;
      ListNode curr = res;
      while(curr != null) {
          curr = curr.next;
          len++;
      }
      curr = head;
      int currLen = 0;
      ListNode prev = null;
      ListNode next = null;
      while(curr != null) {
          ListNode subHead = curr;
          for(int i = 0; i < k; i++) {
              next = curr.next;
              curr.next = prev;
              prev = curr;
              curr = next;
              currLen++;
          }
          if (curr != null) next = curr.next;
          
          if (len - currLen <= k){
              subHead.next = curr;
              return res;
          }
          ListNode temp = curr;
          for(int i = 0; i < k - 1; i++) {
              temp = temp.next;

          }
          subHead.next = temp;
      }
      return res;
  }
}