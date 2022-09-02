package src.Easy;
// Time Complexity: O(n)

class Solution {
    public int[] sortedSquares(int[] nums) {
        int zero = 0;
        int len = nums.length;
        while (zero < len && nums[zero] < 0) zero++;
        int left = zero - 1;
        int right = zero;
        int[] response = new int[len];
        int i = 0;
        while(left >= 0 || right < len) {
            if (left >= 0 && right < len){
                if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                    response[i] = nums[left]*nums[left];
                    left--;
                } else {
                    response[i] = nums[right]*nums[right];
                    right++;
                }
            } else {
                if (left < 0) {
                    response[i] = nums[right]*nums[right];
                    right++;
                } else {
                    response[i] = nums[left]*nums[left];
                    left--;
                }
            }
            i++;
        }
        return response;
    }
}