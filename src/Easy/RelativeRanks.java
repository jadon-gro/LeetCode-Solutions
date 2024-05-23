package src.Easy;
// Time Complexity: O(nlogn)
import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        ArrayList<Pair> l = new ArrayList<Pair>();
        for (int i = 0; i < score.length; i++) {
            l.add(new Pair(i, score[i]));
        }
        Collections.sort(l);
        String[] result = new String[score.length];
        for (int i = 0; i < l.size(); i++) {
            int index = l.get(i).index;
            switch(i) {
                case 0:
                    result[index] = "Gold Medal";
                    break;
                case 1:
                    result[index] = "Silver Medal";
                    break;
                case 2:
                    result[index] = "Bronze Medal";
                    break;
                default:
                    result[index] = String.valueOf(i + 1);
            }
        }
        return result;
    }
}

class Pair implements Comparable<Pair> {
    int index;
    int score;
    public Pair(int index, int score) {
        this.index = index;
        this.score = score;
    }

    @Override
    public int compareTo(Pair o) {
        return o.score - this.score;
    }
}