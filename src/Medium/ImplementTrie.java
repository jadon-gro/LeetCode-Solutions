package src.Medium;


import java.util.*;
class Trie {
  Node root;
  Set<String> dictionary;
  public Trie() {
      root = new Node(null);
      dictionary = new HashSet<String>();
  }
  
  public void insert(String word) {
      dictionary.add(word);
      Node curr = root;
      for (char c : word.toCharArray()) {
          if (curr.nexts.containsKey(c)) {
              curr = curr.nexts.get(c);
          } else {
              Node temp = new Node(c);
              curr.nexts.put(c, temp);
              curr = temp;
          }
      }
  }
  
  public boolean search(String word) {
      return dictionary.contains(word);
  }
  
  public boolean startsWith(String prefix) {
      Node curr = root;
      for(char c : prefix.toCharArray()) {
          curr = curr.nexts.getOrDefault(c, null);
          if (curr == null) return false;
      }
      return true;
  }
}


class Node {
  Character val;
  HashMap<Character, Node> nexts;
  Node(Character val) {
      this.val = val;
      nexts = new HashMap<Character, Node>();
  }
}
