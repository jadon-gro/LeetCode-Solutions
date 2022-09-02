package src.Medium;

import java.util.*;
class Solution {
    List<String> response;
    int n;
    
    public List<String> generateParenthesis(int n) {
        this.n = n;
        response = new ArrayList<String>();
        backTrack("", 0);
        return response;
    }
    public void backTrack(String comb, int numOpen) {
        int len = comb.length();
        if (len == n*2) {
            response.add(comb);
            return;
        }
        if (numOpen < n) {
            backTrack(comb + "(", numOpen + 1);
        }
        if (len - numOpen < numOpen) {
            backTrack(comb + ")", numOpen);
        }
    }
}