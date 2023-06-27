package src.Medium;
// Backtracking with memoization


import java.util.*;
class Solution {
    String s1;
    String s2;
    String s3;
    Map<Pair, Boolean> m;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        m = new HashMap<Pair, Boolean>();
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        return backtracking(0, 0, 0);
    }

    public boolean backtracking(int i1, int i2, int i3) {
        if (m.containsKey(new Pair(i1, i2))) return m.get(new Pair(i1, i2));
        if (i3 == s3.length()) return true;
        char c1 = s1.length() == i1 ? 0 : s1.charAt(i1);
        char c2 = s2.length() == i2 ? 0 : s2.charAt(i2);
        char c3 = s3.charAt(i3);
        if (c1 != c3 && c2 != c3){
            m.put(new Pair(i1, i2), false);
            return false;
        }
        if (c1 == c3 && c2 == c3) {
            if (backtracking(i1+1, i2, i3+1) || backtracking(i1, i2 + 1, i3 + 1)){
                m.put(new Pair(i1, i2), true);
                return true;
            }
            m.put(new Pair(i1, i2), false);
            return false;
        } else {
            if (c1 == c3){
                boolean a = backtracking(i1+1, i2, i3+1);
                m.put(new Pair(i1, i2), a);
                return a;
            }
            boolean a = backtracking(i1, i2 + 1, i3 + 1);
            m.put(new Pair(i1, i2), a);
            return a;
        }
    }
}
class Pair{
    int i1;
    int i2;
    public Pair(int i1, int i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    @Override
    public int hashCode() {
        return i1 * 300 + i2;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Pair) {
            Pair other = (Pair) o;
            return other.i1 == i1 && other.i2 == i2;
        }
        return false;
    }
}