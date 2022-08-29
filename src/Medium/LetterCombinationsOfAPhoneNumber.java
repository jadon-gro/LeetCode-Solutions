package src.Medium;

import java.util.*;
class Solution {
  int len;
  List<String> response;
  Map<Character, char[]> dict;
  String digits;
  public List<String> letterCombinations(String digits) {
      this.len = digits.length();
      if (len == 0) return new ArrayList<String>();
      response = new ArrayList<String>();
      this.digits = digits;
      dict = new HashMap<Character, char[]>();
      char[] two = {'a', 'b', 'c'};
      dict.put('2', two);
      char[] three = {'d', 'e', 'f'};
      dict.put('3', three);
      char[] four = {'g', 'h', 'i'};
      dict.put('4', four);
      char[] five = {'j', 'k', 'l'};
      dict.put('5', five);
      char[] six = {'m', 'n', 'o'};
      dict.put('6', six);
      char[] seven = {'p', 'q', 'r', 's'};
      dict.put('7', seven);
      char[] eight = {'t', 'u', 'v'};
      dict.put('8', eight);
      char[] nine = {'w', 'x', 'y', 'z'};
      dict.put('9', nine);
      backTrack(0, new StringBuilder());
      return response;
  }
  
  public void backTrack(int start, StringBuilder comb) {
      if (comb.length() == len) {
          response.add(comb.toString());
          return;
      }
      for (char c : dict.get(digits.charAt(start))) {
          comb.append(c);
          backTrack(start + 1, comb);
          comb.deleteCharAt(comb.length() - 1);
      }
  }
}