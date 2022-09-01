package src.Hard;

import java.util.*;
class Solution {
    Set<String> words;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //bfs
        Queue<String> q = new LinkedList<String>();
        Set<String> words = new HashSet<String>(wordList);
        if (!words.contains(endWord)) return 0;
        words.remove(beginWord);
        this.words = words;
        q.add(beginWord);
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                List<String> neighbors = neighbors(curr);
                for(String neighbor : neighbors) {
                    if (neighbor.equals(endWord)) return level;
                    words.remove(neighbor);
                    q.add(neighbor);
                }
            }
        }
        return 0;
    }
    
    public List<String> neighbors(String curr) {
        List<String> neighbors = new ArrayList<String>();
        for (int i = 0; i < curr.length(); i++) {
            char c = curr.charAt(i);
            StringBuilder s = new StringBuilder(curr);
            for (char change = 'a'; change <= 'z'; change++) {
                s.setCharAt(i, change);
                String check = s.toString();
                if (words.contains(check) && change != c) {
                    neighbors.add(check);
                }
            }
        }
        return neighbors;
    }
}