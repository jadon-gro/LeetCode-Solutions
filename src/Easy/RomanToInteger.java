package src.Easy;
// Time Complexity: O(n)

import java.util.HashMap;
class Solution {
    public int romanToInt(String s) {
      int sum = 0;
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      map.put('I', 1);
      map.put('V', 5);
      map.put('X', 10);
      map.put('L', 50);
      map.put('C', 100);
      map.put('D', 500);
      map.put('M', 1000);
      int l = s.length();
        for (int i = 0; i < l; i++) {
          if((l-i > 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) || 
          (l-i > 2 && map.get(s.charAt(i)) == map.get(s.charAt(i + 1)) 
          && map.get(s.charAt(i)) < map.get(s.charAt(i + 2)))) {
            sum = sum - map.get(s.charAt(i));
          } else {
            sum = sum + map.get(s.charAt(i));
          }
        }
      return sum;
    }
}