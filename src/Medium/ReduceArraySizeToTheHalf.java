package src.Medium;
// Time Complexity: O(nlogn)

import java.util.*;
class Solution {
    public int minSetSize(int[] arr) {
        int size = arr.length;
        if (size == 0) return 0;
        if (size < 3) return 1;
        int half = size / 2;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer> values = new ArrayList<Integer>(map.values());
        Collections.sort(values);
        Collections.reverse(values);
        int amt = 1;
        int sum = 0;
        for (int i : values) {
            if ((sum += i) >= half) break;
            amt++;
        }
        return amt;
    }
}