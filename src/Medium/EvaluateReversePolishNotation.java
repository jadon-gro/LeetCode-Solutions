package src.Medium;
//Time Complexity: O(n);

import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> values = new ArrayDeque<Integer>();
        for(String s : tokens) {
            if ("+-*/".contains(s)){
                int y = values.pop();
                int x = values.pop();
                if (s.equals("+")) {
                    values.push(x + y);
                } else if (s.equals("-")) {
                    values.push(x - y);
                } else if (s.equals("*")) {
                    values.push(x * y);
                } else if (s.equals("/")) {
                    values.push(x / y);
                }
            } else {
                 values.push(Integer.parseInt(s));
            }
        }
        return values.peek();
    }
}