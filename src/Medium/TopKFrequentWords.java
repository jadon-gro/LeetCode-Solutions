package src.Medium;
// Time Complexity: O(nlogn)

import java.util.*;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counter = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }
        List<Package> l = new ArrayList<Package>();
        for (String s : counter.keySet()) {
            l.add(new Package(s, counter.get(s)));
        }
        Collections.sort(l);
        List<String> response = new ArrayList<String>();
        for (int i = 0; i < k; i++) {
            response.add(l.get(i).word);
        }
        return response;
    }
}

class Package implements Comparable<Package>{
    int val;
    String word;
    public Package(String word, int val) {
        this.val = val;
        this.word = word;
    }
    public int compareTo(Package o) {
        if (o.val == this.val) return word.compareTo(o.word);
        return o.val - this.val;
    }
}