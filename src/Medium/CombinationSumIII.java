package src.Medium;

import java.util.*;
class Solution {
  int k;
  List<List<Integer>> result;
  public List<List<Integer>> combinationSum3(int k, int n) {
      this.k = k;
      this.result = new ArrayList<List<Integer>>();
      backTrack(n, 1, new LinkedList<Integer>());
      return result;
  }
  public void backTrack (int remain, int start, LinkedList<Integer> combination) {
      if (k < 0) return;
      if (k == combination.size()) {
          if (remain == 0) result.add(new ArrayList<Integer>(combination));
          return;
      }
      for (int i = start; i < 10; i++) {
          combination.add(i);
          backTrack(remain - i, i + 1, combination);
          combination.removeLast();
      }
  }
}