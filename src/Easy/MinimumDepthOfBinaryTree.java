package src.Easy;
//Time Complexity: O(n)

class Solution {
    int min;
    int curr;
    public int minDepth(TreeNode root) {
        //dfs, we can go with preorder
        if (root == null) return 0;
        curr = 1;
        min = Integer.MAX_VALUE;
        preOrder(root);
        return min;
        
    }
    public void preOrder(TreeNode curr) {
        if (this.curr == min) return;
        if (curr.left == null && curr.right == null) {
            //leaf
            min = Math.min(this.curr, min);
            return;
        }
        this.curr++;
        if (curr.left != null) {
            preOrder(curr.left);
        }
        if (curr.right != null) {
            preOrder(curr.right);
        }
        this.curr--;
    }
}