package src.Easy;
//Time complexity: O(n)
class Solution {
    public int subtractProductAndSum(int n) {
        char[] number = Integer.toString(n).toCharArray();
        int sum = 0;
        int mult = 1;
        for (char c : number) {
            int i = c - '0';
            sum+=i;
            mult = mult * i;
        }
        return mult - sum;
    }
}