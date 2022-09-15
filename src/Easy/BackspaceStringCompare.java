package src.Easy;
// Time Complexity: O(n + m);

import java.util.*;
class Solution {
  public boolean backspaceCompare(String s, String t) {
      Stack<Character> stackS = new Stack<Character>();
      for(char c : s.toCharArray()) {
          if (c == '#'){
              if (!stackS.isEmpty()) stackS.pop();
          }
          else stackS.push(c);
      }
      Stack<Character> stackT = new Stack<Character>();
      for(char c : t.toCharArray()) {
          if (c == '#'){
              if (!stackT.isEmpty()) stackT.pop();
          }
          else stackT.push(c);
      }
      if (stackT.size() != stackS.size()) return false;
      while (!stackT.isEmpty()) {
          if (stackT.pop() != stackS.pop()) return false;
      }
      return true;
      
  }
}