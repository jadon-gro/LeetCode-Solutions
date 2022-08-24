package src.Medium;
// Time Limit Exceeded. Will return. Otherwise, completely functional.
import java.util.*;
class Solution {
    
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
      HashMap<String,List<List<String>>> map = new HashMap<String,List<List<String>>>();
      List<List<String>> response = new ArrayList<List<String>>();
      for(List<String> account : accounts) {
          List<List<String>> emailGroup = map.getOrDefault(account.get(0), new ArrayList<List<String>>());
          emailGroup.add(account.subList(1, account.size()));
          map.put(account.get(0), emailGroup);
      }
      for(String name : map.keySet()) {
        //bfs
          Set<Integer> visited = new HashSet<Integer>();
          List<List<String>> groups = new ArrayList<List<String>>();
          Queue<Integer> q = new LinkedList<Integer>();
          List<List<String>> accountsForName = map.get(name);
          for(int i = 0; i < accountsForName.size(); i++) {
              if (visited.contains(i)) continue;
              visited.add(i);
              Set<String> group = new HashSet<String>();
              group.addAll(accountsForName.get(i));
              for(int j = 0; j < accountsForName.size(); j++) {
                  if (j != i) {
                      boolean connected = false;
                      for (String email : accountsForName.get(j)) {
                          if (accountsForName.get(i).contains(email)) {
                              connected = true;
                              break;
                          }
                      }
                      if (!connected) continue;
                      
                      
                      q.add(j);
                      group.addAll(accountsForName.get(j));
                  }
              }
              while (!q.isEmpty()) {
                  int curr = q.poll();
                  if (visited.contains(curr)) continue;
                  visited.add(curr);
                  for(int j = 0; j < accountsForName.size(); j++) {
                      if (j != curr) {
                          boolean connected = false;
                          for (String email : accountsForName.get(j)) {
                              if (accountsForName.get(curr).contains(email)) {
                                  connected = true;
                                  break;
                              }
                          }
                          if (!connected) continue;
                          q.add(j);
                          group.addAll(accountsForName.get(j));
                      }
                  }
              }
              List<String> groupList = new ArrayList(group);
              Collections.sort(groupList);
              groupList.add(0, name);
              response.add(groupList);
          }
      }
      return response;
  }
}
