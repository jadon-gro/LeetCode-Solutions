package src.Easy;
// Time Complexity: O(nlogn)

import java.util.*;
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        int lastEndTime = -1;
        for (int[] a : intervals) {
            if (a[0] < lastEndTime) return false;
            lastEndTime = a[1];
        }
        return true;
    }
}