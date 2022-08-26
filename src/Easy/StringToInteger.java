package src.Easy;
// Time Complexity: O(n) length of string before end of number
class Solution {
    public int myAtoi(String s) {
        int sum = 0;
        boolean started = false;
        boolean negative = false;
        for(char c : s.toCharArray()) {
            if (!started && c != ' ') {
                if (c == '-') {
                    negative = true;
                    started = true;
                    continue;
                } else if (c == '+') {
                    started = true;
                    continue;
                }
                started = true;
            }
            if (started) {
                if(c - '0' < 0 || c - '0' > 9) break;
                if (Integer.MAX_VALUE / 10 < sum || sum == Integer.MAX_VALUE / 10 && c - '0' > 7) {
                    if (negative) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }
                sum = sum * 10;
                
                sum += c - '0';
                
            }
        }
        if (negative) sum = sum * -1;
        return sum;
    }
}