package src.Hard;
//Time Complexity: O(|s| + |t|)

import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (n > m) return "";
        Map<Character, Integer> sm = new HashMap<Character, Integer>();
        Map<Character, Integer> tm = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            tm.put(c, tm.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        int right = 0;
        int tmSize = tm.size();
        int count = 0;
        while (right < m) {
            int num = sm.getOrDefault(s.charAt(right), 0) + 1;
            sm.put(s.charAt(right), num);
            if (num == tm.getOrDefault(s.charAt(right), -1)) count++;
            right++;
            if (count == tmSize) break;
        }
        right--;
        if (count != tmSize) return "";
        String rv = s.substring(left, right + 1);
        
        while (right < m) {
            if (tm.getOrDefault(s.charAt(left), 0).intValue() == sm.getOrDefault(s.charAt(left), -1).intValue()) { //if moving left would make it invalid
                if (rv.length() > right - left + 1) rv = s.substring(left, right + 1);
                if (right + 1 == m) break;
                sm.put(s.charAt(right + 1), sm.getOrDefault(s.charAt(right + 1), 0) + 1);
                right++; //move right;
            } else {
                sm.put(s.charAt(left), sm.get(s.charAt(left)) - 1);
                left++;
            }
        }
        return rv;
    }
}