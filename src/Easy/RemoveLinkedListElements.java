package src.Easy;
// Time Complexity: O(n)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        while(head != null && head.val == val) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            if (next.val == val) {
                curr.next = next.next;
            }
            else curr = curr.next;
        }
        return head;
    }
}