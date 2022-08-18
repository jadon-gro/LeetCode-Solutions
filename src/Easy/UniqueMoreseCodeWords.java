package src.Easy;
// Time Complexity: O(n)

import java.util.Set;
import java.util.HashSet;
class Solution {
  public int uniqueMorseRepresentations(String[] words) {
      int offset = 'a';
      Set<String> rv = new HashSet<String>();
      String[] dict = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
      for(String word : words) {
          String morse = "";
          for(int i = 0; i < word.length(); i++) {
              morse = morse + dict[word.charAt(i) - offset];
          }
          rv.add(morse);
      }
      return rv.size();
  }
}