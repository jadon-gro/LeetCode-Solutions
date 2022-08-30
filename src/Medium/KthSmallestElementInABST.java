package src.Medium;
//Time Complexity: O(n)

import java.util.*;
class Solution {
    List<Integer> list;
    int k;
    int counter;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        counter = 0;
        list = new ArrayList<Integer>();
        recursiveHelper(root);
        return list.get(k - 1);
    }
    
    public void recursiveHelper(TreeNode curr) {
        if (curr == null) return;
        recursiveHelper(curr.left);
        list.add(curr.val);
        counter++;
        if (counter == k) return;
        recursiveHelper(curr.right);
    }
}