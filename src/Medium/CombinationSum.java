package src.Medium;

import java.util.*;
class Solution {
  List<List<Integer>> result;
  int len;
  int[] candidates;
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      len = candidates.length;
      this.candidates = candidates;
      result = new ArrayList<List<Integer>>();
      backTrack(target, 0, new LinkedList<Integer>());
      return result;
  }
  
  public void backTrack(int remain, int start, LinkedList<Integer> comb) {
      if (remain < 0) return;
      if (remain == 0) {
          result.add(new ArrayList<Integer>(comb));
      }
      for (int i = start; i < len; i++) {
          comb.add(candidates[i]);
          backTrack(remain - candidates[i], i, comb);
          comb.removeLast();
      }
  }
}