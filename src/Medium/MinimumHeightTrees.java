package src.Medium;
// Time Complexity: O(n)

// I've never done topological sorting before so I had to reference the solution.
// Makes sense now though I understand topological sorting to an extent.
import java.util.*;
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < n; i++) adjList.put(i, new HashSet<Integer>());
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            Set<Integer> toNode = adjList.get(to);
            toNode.add(from);
            Set<Integer> fromNode = adjList.get(from);
            fromNode.add(to);
        }
        
        List<Integer> leaves = new ArrayList<Integer>();
        for(int node : adjList.keySet()) {
            if (adjList.get(node).size() == 1) {
                leaves.add(node);
            }
        }
        while(adjList.size() > 2) {
            List<Integer> newLeaves = new ArrayList<Integer>();
            //trim leaves
            for (int i : leaves) {
                Integer neighbor = adjList.get(i).toArray(new Integer[1])[0];
                Set<Integer> temp = adjList.get(neighbor);
                temp.remove(i);
                adjList.remove(i);
                if (temp.size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return new ArrayList<Integer>(adjList.keySet());
    }
}
