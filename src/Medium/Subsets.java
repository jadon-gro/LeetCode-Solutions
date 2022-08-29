package src.Medium;
// I implemented it in each of the following ways-
// The first way I didn't reference any material/solutions and was the second fastest.
// The second way I got a clue about from the solution and was the fastest
// The third way I naturally came up with the intuition but saw a solution to model implmenetation after

import java.util.*;
class additive {
  public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> response = new ArrayList<List<Integer>>();
      response.add(new ArrayList<Integer>());
      int len = nums.length;
      for (int j = 0; j < len; j++) {
          for (List<Integer> curr : new ArrayList<List<Integer>>(response)) {
              if (!curr.contains(nums[j])) {
                  List<Integer> addition = new ArrayList<Integer>(curr);
                  addition.add(nums[j]);
                  response.add(addition);
              }
          }
      }
      return response;
  }
}


class BackTracking {
  public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> response = new ArrayList<List<Integer>>();
      response.add(new ArrayList<Integer>());
      int len = nums.length;
      for (int j = 0; j < len; j++) {
          for (List<Integer> curr : new ArrayList<List<Integer>>(response)) {
              if (!curr.contains(nums[j])) {
                  List<Integer> addition = new ArrayList<Integer>(curr);
                  addition.add(nums[j]);
                  response.add(addition);
              }
          }
      }
      return response;
  }
}

class BinaryMasking {
  public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> response = new ArrayList<List<Integer>>();
      List<String> masks = new ArrayList<String>();
      int ul = (int) Math.pow(2 ,nums.length);
      for (int i = 0; i < ul; i++) {
          String mask = Integer.toBinaryString(i);
          List<Integer> curr = new ArrayList<Integer>();
          for (int j = mask.length() - 1; j >= 0; j--) {
              if (mask.charAt(j) == '1'){
                  curr.add(nums[mask.length() - j - 1]);
              }
          }
          response.add(curr);
      }
      return response;
  }
}