package src.Easy;
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            int s = i;
            int count = 0;
            while (s != 0) {
                count += s & 1;
                s = s >> 1;
            }
            ans[i] = count;
        }
        return ans;
    }
}