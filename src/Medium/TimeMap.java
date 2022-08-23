package src.Medium;
// Time Complexity: set - O(1) 
//                  get - O(t) t = size of timestamp

import java.util.*;
class TimeMap {
  Map<Integer,Map<String,String>> map;
  public TimeMap() {
      map = new HashMap<Integer,Map<String,String>>();
  }
  
  public void set(String key, String value, int timestamp) {
      if (!map.containsKey(timestamp)) {
          map.put(timestamp, new HashMap<String,String>());
      }
      map.get(timestamp).put(key, value);
  }
  
  public String get(String key, int timestamp) {
      int correctTimestamp = -1;
      for(int i = timestamp; i >= 0; i--) {
          if (!(map.get(i) == null) && !(map.get(i).get(key) == null)) {
              correctTimestamp = i;
              break;
          }
      }
      if (correctTimestamp == -1) return "";
      return map.get(correctTimestamp).get(key);
  }
}