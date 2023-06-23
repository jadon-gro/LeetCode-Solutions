package src.Easy;

import java.util.*;
class Solution {
    private Map<Pair, Integer> memo;

    private int val(int row, int col) {
        Pair p = new Pair(row, col);
        if (col == 0 || col == row) {
            memo.put(p, 1);
            return 1;
        }
        if (memo.containsKey(p)) return memo.get(p);

        int ans = val(row - 1, col - 1) + val(row - 1, col);
        memo.put(p, ans);
        return ans;
        
    }

    public List<Integer> getRow(int rowIndex) {
        memo = new HashMap<Pair, Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) res.add(val(rowIndex, i));
        return res;
    }
}

class Pair {
    public int row;
    public int col;
    public Pair(int row, int col) { 
        this.row = row; 
        this.col = col;
    }

    @Override
    public int hashCode() {
        return row * 40 + col;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Pair) {
            Pair other = (Pair) o;
            return other.row == row && other.col == col;
        }
        return false;
    }
}