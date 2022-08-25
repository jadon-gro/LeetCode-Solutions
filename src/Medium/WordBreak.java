package src.Medium;

import java.util.*;
class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
      List<Integer> dp = new ArrayList<Integer>(); //dp table acts as word break indicator
      dp.add(0);
      int len = s.length();
      boolean once = false;
      while(true) {
          List<Integer> dpOG = new ArrayList<Integer>(dp);
          
          for (String word : wordDict) {
              int wordLength = word.length();
              List<Integer> temp = new ArrayList<Integer>(dp);
              for (int breakIndex : temp) {
                  if (breakIndex + wordLength > len) continue;
                  if (s.substring(breakIndex, breakIndex + wordLength).equals(word)) {
                      if (breakIndex + wordLength == len) return true;
                      if (!dp.contains(breakIndex + wordLength)) dp.add(breakIndex + wordLength);
                  }
              }
          }
          if (dpOG.equals(dp)) once = true;
          else once = false;
          if (once && dpOG.equals(dp)) return false;
      }
      
  }
}