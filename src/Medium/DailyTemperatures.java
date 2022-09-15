package src.Medium;
// I optimized brute force and it beats 92% of answers lol

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
      int len = temperatures.length;
      int[] res = new int[len];
      int[] tempResponse = new int[len];
      for(int i = len - 1; i >= 0; i--) {
          int currTemp = temperatures[i];
          for(int j = i + 1; j < len; j++) {
              int futureTemp = temperatures[j];
              if (futureTemp > currTemp) {
                  res[i] = j - i;
                  tempResponse[i] = futureTemp;
                  break;
              } else if (futureTemp < currTemp && tempResponse[j] > currTemp) {
                  res[i] = res[j] + j - i;
                  break;
              } else if (futureTemp == currTemp) {
                  if (res[j] == 0) res[i] = 0;
                  else res[i] = res[j] + j - i;
                  break;
              }
          }
      }
      return res;
  }
}