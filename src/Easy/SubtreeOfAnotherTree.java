package src.Easy;

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) {
            return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
        }
        boolean isSame = isSameTree(root, subRoot);
        if (!isSame) return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
        else return true;
    }
    
    public boolean isSameTree(TreeNode curr1, TreeNode curr2) {
        if (curr1 == null && curr2 == null) return true;
        if (curr1 == null || curr2 == null) return false;
        if (curr1.val != curr2.val) return false;
        return isSameTree(curr1.right, curr2.right) && isSameTree(curr1.left, curr2.left);
    }
}
