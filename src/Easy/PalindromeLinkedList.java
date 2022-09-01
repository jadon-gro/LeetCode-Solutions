package src.Easy;
// Time Complexity: O(n)
// In place too!

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public boolean isPalindrome(ListNode head) {
        // find halfway
        if (head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode secondHalf = null;
        while(true) {
            if (fast.next == null) {
                secondHalf = slow.next;
                break;
            }
            if (fast.next.next == null) {
                secondHalf = slow.next.next;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode curr = head;
        ListNode trail = null;
        while (trail != slow) {
            ListNode temp = curr.next;
            curr.next = trail;
            trail = curr;
            curr = temp;
        }
        while (trail != null) {
            if (trail.val != secondHalf.val) return false;
            trail = trail.next;
            secondHalf = secondHalf.next;
        }
        return true;
        
    }
}