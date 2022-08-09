package src;
// Time Complexity: O(n)

import java.util.*;
class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
      HashMap<Character, Integer> ransomLetters = new HashMap<Character, Integer>();
      HashMap<Character, Integer> magazineLetters = new HashMap<Character, Integer>();
      for(int i = 0; i < ransomNote.length(); i++){
          char c = ransomNote.charAt(i);
          ransomLetters.put(c, ransomLetters.getOrDefault(c, 0) + 1);
      }
      System.out.println(ransomLetters.get('a'));
      for(int i = 0; i < magazine.length(); i++){
          char c = magazine.charAt(i);
          magazineLetters.put(c, magazineLetters.getOrDefault(c, 0) + 1);
      }
      System.out.println(magazineLetters.get('a'));
      Iterator<Character> i = ransomLetters.keySet().iterator();
      while (i.hasNext()){
          char c = i.next();
          if (magazineLetters.getOrDefault(c, -1) == -1 || ransomLetters.get(c) > magazineLetters.get(c)) return false;
      }
      return true;
      
  }
}