package src.Medium;

import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = 0;
        int plen = p.length();
        
        List<Integer> response = new ArrayList<Integer>();
        
        Map<Character, Integer> pmap = new HashMap<Character, Integer>();
        for(int i = 0; i < plen; i++) pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);
        Map<Character, Integer> smap = new HashMap<Character, Integer>();
        
        int left = 0;
        int right = 0;
        boolean complete = false;
        while (right < s.length()) {
            char cr = s.charAt(right);
            if (!complete) {
                int count = smap.getOrDefault(cr, 0) + 1;
                if (count <= pmap.getOrDefault(cr, 0)) { // increment
                    slen++;
                    if (slen == plen) { // found a complete anagram
                        complete = true;
                        response.add(left);
                        slen = 0;
                        smap.clear();
                        right++;
                    } else {
                        smap.put(cr, count);
                        right++;
                    }
                    
                } else { // reset
                    if (!pmap.containsKey(cr)) {
                        right++;
                        left = right;

                    } else {
                        left++;
                        right = left;
                    }
                    smap.clear();
                        slen = 0;
                   
                }
            } else {
                if (cr == s.charAt(left)) {
                    left++;
                    right++;
                    response.add(left);
                } else {
                    complete = false;
                    if (!pmap.containsKey(cr)) {
                        right++;
                        left = right;
                    } else {
                        left++;
                        right = left;
                    }
                }
            }
        }
        return response;
    }
}