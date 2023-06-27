package src.Medium;

import java.util.*;
class Solution {
    public int longestArithSeqLength(int[] nums) {
        Map<Pair, Integer> dp = new HashMap<Pair, Integer>();
        for(int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dp.put(new Pair(j, nums[j] - nums[i]), dp.getOrDefault(new Pair(i, nums[j] - nums[i]), 1) + 1);
            }
        }
        int max = 2;
        for(Pair key : dp.keySet()) {
            max = Math.max(dp.get(key), max);
        }
        return max;
    }
}

class Pair {
    int left;
    int diff;
    public Pair(int left, int diff) {
        this.left = left;
        this.diff = diff;
    }

    @Override
    public int hashCode() {
        return left * 1000 + diff;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pair) {
            Pair other = (Pair) o;
            return other.left == left && other.diff == diff;
        }
        return false;
    }
}