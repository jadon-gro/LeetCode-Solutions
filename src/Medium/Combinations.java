package src.Medium;

import java.util.*;
class Solution {
    private List<List<Integer>> response;
    private int[] nums;
    private int k;
    public List<List<Integer>> combine(int n, int k) {
        response = new ArrayList<List<Integer>>();
        nums = new int[n];
        this.k = k;
        for(int i = 1; i <= n; i++) nums[i - 1] = i;
        backtrack(new ArrayList<Integer>(), 0);
        return response;
    }

    public void backtrack(List<Integer> comb, int place) {
        if (comb.size() == k) {
            response.add(new ArrayList<Integer>(comb));
            return;
        }

        for(int i = place; i < nums.length; i++) {
            comb.add(nums[i]);
            backtrack(comb, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}