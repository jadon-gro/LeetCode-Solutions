package src.Easy;
//Time complexity: O(n^2)

import java.util.*;
class Solution {
  public boolean hasGroupsSizeX(int[] deck) {
      Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
      for(int element : deck) counter.put(element, counter.getOrDefault(element, 0) + 1);
      Set<Integer> remainingFactors = factors(counter.get(deck[0]));
      for(int key : counter.keySet()){
          Set<Integer> factors = factors(counter.get(key));
          Set<Integer> temp = new HashSet<Integer>(remainingFactors);
          for(int factor : temp) {
              if (!factors.contains(factor)) remainingFactors.remove(factor);
          }
      }
      return remainingFactors.size() > 1 ? true : false;
  }
  
  public Set<Integer> factors(int factorize) {
      Set<Integer> factors = new HashSet<Integer>();
      for(int i = factorize; i > 0; i--) {
          if (factorize % i == 0) factors.add(i);
      }
      return factors;
  }
}