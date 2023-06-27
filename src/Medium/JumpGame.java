package src.Medium;

class Solution {
    public boolean canJump(int[] nums) {
        for(int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != 0) continue;
            int left = i - 1;
            while (left >= 0 &&nums[left] == 0) left--;
            if (left == -1) return false;
            int j;
            for(j = 0; j <= left; j++) {
                if (nums[j] + j > i) {
                    i = j;
                    break;
                }
            }
            if (j > left) return false;
        }
        return true;
    }
}

// Optimized after looking at solution :P
class Solution2 {
    public boolean canJump(int[] nums) {
        int furthestReachable = nums.length - 1;
        for(int i = furthestReachable; i >= 0; i--) {
            if (i + nums[i] >= furthestReachable) {
                furthestReachable = i;
            }
        }
        return furthestReachable == 0;
    }
}