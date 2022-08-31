package src.Hard;
//Time complexity: O(n)

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;
        //find first decrease
        int left = 0;
        while(left + 1 < n && height[left] <= height[left + 1]) left++;
        int[] max = new int[n];
        int maxcurr = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (height[i] > maxcurr) {
                maxcurr = height[i];
            }
            max[i] = maxcurr;
        }
        int rv = 0;
        int right = left + 1;
        int leftHeight = height[left];
        boolean lookingForStart = false;
        boolean decreasing = true;
        while(right < n && left + 1 < n) {
            if (lookingForStart) {
                //find decrease
                while(left + 1 < n && height[left] <= height[left + 1]) left++;
                right = left + 1;
                leftHeight = height[left];
                lookingForStart = false;
                decreasing = true;
            } else {
                //find next height >= left height or there has been a decrease after an increase but theres nothing heigher than a left after
                while(right + 1 < n && height[right] < leftHeight) {
                    if (leftHeight > max[right]) {
                        if (height[right - 1] < height[right]) decreasing = false;
                        if (height[right] > max[right + 1] && !decreasing && height[right + 1] < height[right]) break;
                    }
                    right++;
                }
                
                //puddle between right and left now
                int diff = Math.min(leftHeight, height[right]);
                for (int i = left + 1; i < right; i++) {
                    rv += Math.max(diff - height[i], 0);
                }
                left = right;
                lookingForStart = true;
            }
        }
        return rv;
    }
}

// This one I did after referencing the solution. Much cleaner, twice as much memory usage though and not a lot faster
class Solution2 {
    public int trap(int[] height) {
        int rv = 0;
        int n = height.length;
        int rmax = -1;
        int lmax = -1;
        int[] rmaxarr = new int[n]; // max to right
        int[] lmaxarr = new int[n]; // max to left
        for (int i = 0; i < n; i++) {
            lmax = Math.max(lmax, height[i]);
            lmaxarr[i] = lmax;
            rmax = Math.max(rmax, height[n - i - 1]);
            rmaxarr[n - i - 1] = rmax;
        }
        for (int i = 0; i < n; i++) {
            rv += Math.max(0, Math.min(rmaxarr[i], lmaxarr[i]) - height[i]);
        }
        return rv;
    }
}