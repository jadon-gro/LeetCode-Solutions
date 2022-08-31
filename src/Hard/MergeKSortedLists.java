package src.Hard;
// Time Complexity: O(nlogk) where n is num of nodes and k is num of lists

import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int numLists = lists.length;
        PriorityQueue<Packet> pq = new PriorityQueue<Packet>((Packet p1, Packet p2) -> p1.val - p2.val);
        for (int i = 0; i < numLists; i++){
            ListNode node = lists[i];
            if (node != null) {
                pq.add(new Packet(node.val, i));
            }
        }
        if (pq.isEmpty()) return null;
        int listNum = pq.poll().list;
        ListNode head = new ListNode(lists[listNum].val);
        lists[listNum] = lists[listNum].next;
        if (lists[listNum] != null) pq.add(new Packet(lists[listNum].val, listNum));
        
        ListNode curr = head;
        while (!pq.isEmpty()) {
            listNum = pq.poll().list;
            curr.next = new ListNode(lists[listNum].val);
            curr = curr.next;
            lists[listNum] = lists[listNum].next;
            if (lists[listNum] != null) pq.add(new Packet(lists[listNum].val, listNum));
        }
        return head;
    }
}

class Packet {
    int list;
    int val;
    public Packet(int val, int list) {
        this.val = val;
        this.list = list;
    }
}