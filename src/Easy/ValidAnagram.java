package src;
// Time Complexity: O(n)

import java.util.*;
class Solution {
  public static boolean isAnagram(String s, String t) {
      HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
      HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
      int len = s.length();
      if (len != t.length()) return false;
      
      for (int i = 0; i < len; i++) {
          char sChar = s.charAt(i);
          char tChar = t.charAt(i);
          sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
          tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);
      }
      if (sMap.equals(tMap)) return true;
      return false;
  }

  public static void main(String[] args) {
    System.out.println(isAnagram("hello", "olleh"));
  }
}