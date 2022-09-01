package src.Easy;
//Time Complexity: O(n)

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int even = 0;
        int len = nums.length;
        int odd = len - 1;
        while(even < odd) {
            int temp = nums[even];
            if (temp % 2 == 0) {
                even++;
            } else {
                nums[even] = nums[odd];
                nums[odd] = temp;
                odd--;
            }
        }
        return nums;
    }
}