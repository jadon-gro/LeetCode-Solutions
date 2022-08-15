package src.Medium;
// Time Complexity: O(n)
// It beats 99.73% of java submissions in runtime and 75.44% in memory!

import java.util.*;
class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
      if (intervals.length == 0) {
          int[][] rv = new int[1][2];
          rv[0] = newInterval;
          return rv;
      }
      List<int[]> rv = new ArrayList<int[]>();
      int len = intervals.length;
      boolean startPlaced = false;
      boolean endPlaced = false;
      int newStart = newInterval[0];
      int newEnd = newInterval[1];
      int thisStart = -1;
      int thisEnd = -1;
      for(int i = 0; i < len; i++) {
          int beg = intervals[i][0];
          int end = intervals[i][1];
          if (startPlaced && endPlaced || newStart > end) {
              int[] arr = {beg, end};
              rv.add(arr);
              continue;
          }
          if (!startPlaced) {
              if (newStart < beg) { // the new interval starts before current interval
                  thisStart = newStart;
                  startPlaced = true;
              } else if (newStart >= beg && newStart <= end) { // the new interval starts inside the current interval
                  startPlaced = true;
                  thisStart = beg;
              } else { // the new interval starts after this interval
                  thisStart = beg;
              }
          }
          
          //Place end
          if (startPlaced && !endPlaced) {
              if (newEnd < beg) { // new interval ends before this one. This one needs to be revisited
                  i--;
                  thisEnd = newEnd;
                  endPlaced = true;
              } else if (i == len - 1) { // this is the last interval
                  thisEnd = Math.max(end, newEnd);
                  endPlaced = true;
              } else if (newEnd <= end) {// the new interval ends in this interval
                  thisEnd = end;
                  endPlaced = true;
              }
          }
          
          if (startPlaced && endPlaced) {
              int[] arr = {thisStart, thisEnd};
              rv.add(arr);
              thisStart = -1;
              thisEnd = -1;
          }
      }
      if (!startPlaced) {
          rv.add(newInterval);
      }
      return rv.toArray(new int[rv.size()][2]);
      
  }
}