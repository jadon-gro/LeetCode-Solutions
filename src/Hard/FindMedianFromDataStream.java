package src.Hard;
/*
 * Time Complexity: O(n) add
 *                  O(1) find median
 * 
 * I could get add down to O(logn) if I decided to implement binary search.
 * This is done on the second implementation found below. 
 */

 import java.util.*;
class MedianFinder {
    List<Integer> recieved;
    public MedianFinder() {
        recieved = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        int n = recieved.size();
        
        if (n == 0) recieved.add(num);
        else {
            int median = recieved.get(n / 2);
            if (num > median) { // insert from right
                int i = n - 1;
                while (true) {
                    if (recieved.get(i) < num) {
                        recieved.add(i + 1, num);
                        break;
                    }
                    i--;
                }
            } else if (num < median) { //insert from left
                int i = 0;
                while (true) {
                    if (recieved.get(i) > num) {
                        recieved.add(i, num);
                        break;
                    }
                    i++;
                }
            } else {
                recieved.add(n / 2, num);
            }
        }
    }
    
    public double findMedian() {
        int n = recieved.size();
        if (n % 2 == 1) {
            return (double) recieved.get(n / 2);
        } else {
            return (recieved.get(n / 2) + recieved.get(n / 2 - 1)) / 2.0;
        }
    }
}

class MedianFinder2 {
    List<Integer> recieved;
    public MedianFinder2() {
        recieved = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        int n = recieved.size();
        
        if (n == 0){
            recieved.add(num);
            return;
        }
        else {
            int left = 0;
            int right = n - 1;
            int mid = (left + (right - left) / 2);
            while (left < right) {
                int midVal = recieved.get(mid);
                if (num > midVal) {
                    left = mid + 1;
                } else if (num < midVal) {
                    right = mid - 1;
                } else {
                    break;
                }
                mid = (left + (right - left) / 2);
            }
            if (recieved.get(mid) < num) recieved.add(mid + 1, num);
            else recieved.add(mid, num);
        }
    }
    
    public double findMedian() {
        int n = recieved.size();
        if (n % 2 == 1) {
            return (double) recieved.get(n / 2);
        } else {
            return (recieved.get(n / 2) + recieved.get(n / 2 - 1)) / 2.0;
        }
    }
}