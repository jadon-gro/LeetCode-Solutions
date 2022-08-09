package src;
// Time Complexity: O(n)

import java.util.*;
class Solution {
  public boolean isValid(String s) {
      HashMap<Character, Character> lookUp = new HashMap<Character, Character> ();

      lookUp.put(')', '(');
      lookUp.put(']', '[');
      lookUp.put('}', '{');
      
      Stack<Character> stack = new Stack<Character>();
      
      for(char c : s.toCharArray()) {
          if (c == '}' || c == ']' || c == ')') {
              try {
                  if(stack.pop() != lookUp.get(c)) {
                      return false;
                  }
              } catch (Exception e) {
                  return false;
              }
          } else {
              stack.push(c);
          }
      }
      if (!stack.isEmpty()) return false;
      return true;
  }
  
}