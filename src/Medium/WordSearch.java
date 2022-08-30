package src.Medium;
// Should have used backtracking. may revisit

import java.util.*;
class Solution {
    public boolean exist(char[][] board, String word) {
        //dfs
        int m = board.length; //y
        int n = board[0].length; //x
        char start = word.charAt(0);
        char[] cs = word.toCharArray();
        int len = word.length();
        
        Set<Character> set = new HashSet<Character>();
        for (char c : cs) {
            set.add(c);
        }
        Set<Character> set2 = new HashSet<Character>();
        for (char[] cl : board) {
            for (char c : cl) {
                set2.add(c);
            }
        }
        for (char c : set) {
            if (!set2.contains(c)) return false;
        }
        
        
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (board[y][x] == start) {
                    if (len == 1) return true;
                    Stack<Coord> stack = new Stack<Coord>();
                    Set<Coord> visited = new HashSet<Coord>();
                    stack.add(new Coord(x, y, 0));
                    int last = -1;
                    while(!stack.isEmpty()) {
                        Coord curr = stack.pop();
                        int index = curr.wordIndex;
                        Set<Coord> temp = new HashSet<Coord>(visited);
                        if (index <= last) {
                            for (Coord coord : temp) {
                                if (coord.wordIndex >= index) visited.remove(coord);
                            }
                        }
                        last = index;
                        visited.add(curr);
                        if (visited.size() == len) return true;
                        int qx = curr.x;
                        int qy = curr.y;
                        char next = cs[index + 1];
                        if (qx - 1 >= 0 && !visited.contains(new Coord(qx - 1, qy)) && board[qy][qx-1] == next) {
                            stack.push(new Coord(qx - 1, qy, index + 1));
                        }
                        if (qy - 1 >= 0 && !visited.contains(new Coord(qx, qy - 1)) && board[qy-1][qx] == next) {
                            stack.push(new Coord(qx, qy-1, index + 1));
                        }
                        if (qx + 1 < n && !visited.contains(new Coord(qx + 1, qy)) && board[qy][qx+1] == next) {
                            stack.push(new Coord(qx + 1, qy, index + 1));
                        }
                        if (qy + 1 < m && !visited.contains(new Coord(qx, qy + 1)) && board[qy+1][qx] == next) {
                            stack.push(new Coord(qx, qy+1, index + 1));
                        }
                    }
                    
                }
            }
        }
        return false;
    }
}
class Coord {
    int x;
    int y;
    int wordIndex;
    public Coord(int x, int y, int wordIndex) {
        this.x = x;
        this.y = y;
        this.wordIndex = wordIndex;
    }
    public Coord(int x, int y) {
        this(x, y, -1);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Coord) {
            Coord other = (Coord) o;
            return (x == other.x && y == other.y);
        } 
        return false;
    }
    @Override
    public int hashCode() {
        return 1000*x + y;
    }
    @Override
    public String toString() { // for debugging
        return "x:" + x +", y:" + y;
    }
}
