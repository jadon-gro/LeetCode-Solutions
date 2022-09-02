package src.Easy;

class Solution {
    public int missingNumber(int[] nums) {
        int bitCheck = 0;
        for(int i = 0; i < nums.length + 1; i++) bitCheck ^= i;
        for(int i = 0; i < nums.length; i++) bitCheck ^= nums[i];
        return bitCheck;
    }
}
