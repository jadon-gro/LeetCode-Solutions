package src.Medium;
// Time Complexity: O(nlogn)

import java.util.*;
class Solution {
  public int[][] kClosest(int[][] points, int k) {
      List<int[]> pointsList = Arrays.asList(points);
      List<int[]> rv = new ArrayList<int[]>();
      Collections.sort(pointsList, new pointComparator());
      for(int i = 0; i < k; i++) rv.add(pointsList.get(i));
      return rv.toArray(new int[rv.size()][2]);
  }
}
class pointComparator implements Comparator<int[]> {
  public int compare(int[] p1, int[] p2) {
      int check = (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]);
      return check;
  }
}