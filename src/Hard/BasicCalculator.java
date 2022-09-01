package src.Hard;
//Time Complexity: O (n)

import java.util.*;
class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        s = "(" + s + ")";
        Stack<Integer> opens = new Stack<Integer>();
        StringBuilder b = new StringBuilder(s);
        int i = 0;
        while (i < b.length()) {
            char c = b.charAt(i);
            if (c == '(') {
                opens.add(i);
                i++;
                continue;
            }
            if (c == ')') {
                int open = opens.pop();
                b.replace(open, i + 1, evaluate(b.toString().substring(open + 1, i)));
                i = open;
                continue;
            }
            i++;
        }
        return Integer.parseInt(b.toString());
        
    }
    
    public String evaluate(String toEval) {
        toEval = toEval.replace("+-", "-");
        toEval = toEval.replace("--", "+");
        int firstMinus = 1000000;
        int j = 1;
        int len = toEval.length();
        while (j < toEval.length()) {
            if (toEval.charAt(j) == '-') {
                firstMinus = j;
                break;
            }
            j++;
        }
        int firstPlus = toEval.indexOf('+');
        if (firstPlus == -1) firstPlus = 1000000;
        if (firstPlus == 1000000 && firstMinus == 1000000) return toEval;
        int end = Math.min(firstPlus, firstMinus);
        int sum = Integer.parseInt(toEval.substring(0, end));
        int i = end;
        while(i < len) {
            char c = toEval.charAt(i);
            if(c == '+' || c == '-') {
                int start = i++;
                while(true) {
                    if (i == len) {
                        break;
                    } 
                    char curr = toEval.charAt(i);
                    if (curr == '-' || curr == '+') break;
                    i++;
                }
                sum += Integer.parseInt(toEval.substring(start, i));
            } else i++;
        }
        return Integer.toString(sum);
    }
}