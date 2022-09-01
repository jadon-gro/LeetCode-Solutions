package src.Easy;
// Time Complexity: O(n)

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode sentinal = new ListNode(-1, head);
        ListNode curr = head.next;
        ListNode trail = head;
        while (curr != null) {
            if (curr.val == trail.val) {
                trail.next = curr.next;
                curr = trail.next;
            } else {
                trail = curr;
                curr = curr.next;
            }
        }
        return sentinal.next;
    }
}