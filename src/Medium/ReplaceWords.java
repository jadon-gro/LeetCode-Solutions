package src.Medium;
// Time Complexity: O(n)

import java.util.*;
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet<String>(dictionary);
        int len = sentence.length();
        StringBuilder sol = new StringBuilder();
        StringBuilder currWord = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char curr = sentence.charAt(i);
            currWord.append(curr);
            if (curr == ' ') {
                sol.append(currWord.toString());
                currWord = new StringBuilder();
            } else {
                if (dict.contains(currWord.toString())) {
                    while(i + 1 < len && sentence.charAt(i + 1) != ' ') i++;
                }
            }
        }
        sol.append(currWord.toString());
        return sol.toString();
    }
}