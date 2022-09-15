package src.Easy;
// O(nlogn)
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
// O(n)
class Solution2 {
    public int[] countBits(int n) {
        int[] response = new int[n + 1];
        if (n == 0) return response;
        response[1] = 1;
        int start = 0;
        int j = 0;
        for(int i = 2; i < response.length; i++) {
            if (start == j) {
                start = i;
                j = 0;
            }
            response[i] = response[j] + 1;
            j++;
        }
        return response;
    }
}