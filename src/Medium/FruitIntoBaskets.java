package src;
// Time Complexity: O(n)

class Solution {
  public int totalFruit(int[] fruits) {
      int maxLength = 1;
      int currLength = 1;
      int leftType = fruits[0];
      int rightType = -1;
      int sinceLastSwitch = 1;
      
      for (int i = 1; i < fruits.length; i++) {
          int currType = fruits[i];
          
          //new type
          if (leftType != currType && rightType != currType) {
              
              //replace the least recent fruit
              if (fruits[i - 1] == leftType) {
                  rightType = currType;
              } else {
                  leftType = currType;
              }
              currLength = sinceLastSwitch + 1;
              sinceLastSwitch = 1;
              if (currLength > maxLength) maxLength = currLength;
              continue;
          }
          if (currType != fruits[i - 1]) {
              sinceLastSwitch = 1;
          } else {
              sinceLastSwitch++;
          }
          //update length counters
          currLength++;
          if (currLength > maxLength) maxLength = currLength;
      }
      return maxLength;
      
      
  }
}