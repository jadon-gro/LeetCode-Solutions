package src.Easy;
// Time Complexity: Instantiation - O(n)
//                  sumRange - O(1)
class NumArray {
    int sums[];
    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum += nums[i - 1];
            sums[i] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
