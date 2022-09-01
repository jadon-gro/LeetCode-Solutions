package src.Easy;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return sum(root, 0, targetSum);
        
    }
    public boolean sum(TreeNode curr, int sum, int targetSum) {
        sum += curr.val;
        if (curr.left == null && curr.right == null) {
            return sum == targetSum;
        }
        boolean left = curr.left == null ? false : sum(curr.left, sum, targetSum);
        boolean right = curr.right == null ? false : sum(curr.right, sum, targetSum);
        sum -= curr.val;
        
        return left || right;
    }
}