package src.Easy;

import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>(Arrays.asList(1)));
        for(int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<Integer>(Arrays.asList(1));
            List<Integer> last_row = res.get(res.size() - 1);
            for(int j = 1; j < i - 1; j++) {
                row.add(j, last_row.get(j - 1) + last_row.get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}