package src.Easy;
//Time Complexity: O(n)

import java.util.*;
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> rv = new ArrayList<Double>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            rv.add(sum / size);
        }
        return rv;
    }
}