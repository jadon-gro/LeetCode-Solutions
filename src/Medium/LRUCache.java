package src.Medium;
// Time Complexity: All Operations O(1)

import java.util.*;
class LRUCache {
    Map<Integer, doubleLinkedNode> map;
    DLL dll;
    int capacity;
    int size;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        dll = new DLL();
        map = new HashMap<Integer, doubleLinkedNode>(capacity);
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        doubleLinkedNode node = map.get(key);
        dll.moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            doubleLinkedNode node = map.get(key);
            node.value = value;
            dll.moveToFront(node);
        } else {
            if (size < capacity) {
                size++;
            } else {
                int removeKey = dll.removeLast();
                map.remove(removeKey);
            }
            doubleLinkedNode node = new doubleLinkedNode(key, value);
            dll.add(node);
            map.put(key,node);
        }
    }
}

class DLL {
    doubleLinkedNode head;
    doubleLinkedNode tail;
    public DLL() {
        head = new doubleLinkedNode(-1, -1);
        tail = new doubleLinkedNode(-1, -1, null, head);
        head.next = tail;
    }
    public void add(doubleLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public void remove(doubleLinkedNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    public int removeLast() {
        int key = tail.prev.key;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        return key;
    }
    public void moveToFront(doubleLinkedNode node) {
        this.remove(node);
        this.add(node);
    }
    public String toString() { // for debugging
        doubleLinkedNode current = head;
        String s = "";
        while(current.next.next != null) {
            s += "(" + current.next.key + ", " + current.next.value + ") ";
            current = current.next;
        }
        return s;
        
    }
    
}

class doubleLinkedNode {
    doubleLinkedNode next;
    doubleLinkedNode prev;
    int key;
    int value;
    public doubleLinkedNode(int key, int value, doubleLinkedNode next, doubleLinkedNode prev) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
    public doubleLinkedNode(int key, int value) {
        this(key, value, null, null);
    }
}