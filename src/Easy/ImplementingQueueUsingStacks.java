package src.Easy;
// Time complexity O(1) operations amortized

import java.util.*;
class MyQueue {
  private Stack<Integer> in;
  private Stack<Integer> out;
  int front;
  public MyQueue() {
      in = new Stack<Integer>();
      out = new Stack<Integer>();
  }
  
  public void push(int x) {
      in.push(x);
  }
  
  public int pop() {
      if(out.isEmpty()) {
          while (!in.isEmpty()) {
              out.push(in.pop());
          }
      }
      return out.pop();
  }
  
  public int peek() {
      if(out.isEmpty()) {
          while (!in.isEmpty()) {
              out.push(in.pop());
          }
      }
      return out.peek();
  }
  
  public boolean empty() {
      return in.isEmpty() && out.isEmpty();
  }
}