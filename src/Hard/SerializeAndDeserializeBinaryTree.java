package src.Hard;
// Time Complexity: O(n)

import java.util.*;
class Codec {
    String serialized;
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serialized = "";
        preorderHelper(root);
        return serialized;
    }
    public void preorderHelper(TreeNode curr) {
        if (curr == null) {
            serialized += "n";
            return;
        }
        serialized += "d" + curr.val;
        preorderHelper(curr.left);
        preorderHelper(curr.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.charAt(0) == 'n') return null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        int i = 1;
        while("nd".indexOf(data.charAt(i)) == -1) i++;
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(1, i)));
        TreeNode curr = root;
        boolean left = true;
        s.push(root);
        while(i < data.length() - 2){
            int start = i;
            char c = data.charAt(i);
            //go left
            if (left) {
                if (c == 'n'){
                    left = false;
                    i++;
                    continue;
                } else {
                    i++;
                    while("nd".indexOf(data.charAt(i)) == -1) i++;
                    TreeNode next = new TreeNode(Integer.parseInt(data.substring(start + 1, i)));
                    curr.left = next;
                    curr = next;
                    s.push(curr);
                }
            } else { // go right
                if (c == 'n'){
                    if (curr == s.peek()) s.pop();
                    while(true) {
                        curr = s.pop();
                        if (curr.right == null) break;
                    }
                    i++;
                } else {
                    i++;
                    while("nd".indexOf(data.charAt(i)) == -1) i++;
                    TreeNode next = new TreeNode(Integer.parseInt(data.substring(start + 1, i)));
                    curr.right = next;
                    curr = next;
                    left = true;
                    s.push(curr);
                }
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}