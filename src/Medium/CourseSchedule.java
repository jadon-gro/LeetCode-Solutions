package src.Medium;

import java.util.*;


class Solution {
  HashMap<Integer, ArrayList<Integer>> reqs;
  ArrayList<Integer> approved;
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      reqs = new HashMap<Integer, ArrayList<Integer>>();
      approved = new ArrayList<Integer>();
      for (int[] req : prerequisites){
          int course = req[0];
          ArrayList<Integer> prereqsforthisclass = reqs.getOrDefault(course, new ArrayList<Integer>());
          prereqsforthisclass.add(req[1]);
          reqs.put(course, prereqsforthisclass);
      }
      for (int course : reqs.keySet()) {
          if (!approved.contains(course)) {
              if (findLoop(course, new Stack<Integer>())) {
                  return false;
              }
          }
          
      }
      return true;
  }
  public boolean findLoop(int curr, Stack<Integer> visited) {
      if (approved.contains(curr)) return false;
      if (visited.contains(curr)) {
          visited.push(curr);
          return true;
      }
      if (!reqs.containsKey(curr)) {
          visited.push(curr);
          return false;
      }  
      visited.push(curr);
      boolean anyLoop = false;
      for (int i : reqs.get(curr)) {
          boolean loopDetected = findLoop(i, visited);
          anyLoop = anyLoop || loopDetected;
          if (anyLoop == true){
              return true;
          }
          while(visited.peek() != curr) {
              approved.add(visited.pop());
          }
          
      }
      return false;
  }
}