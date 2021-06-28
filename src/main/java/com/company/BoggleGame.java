package com.company;
import java.util.*;

class BoggleTrieNode {

    Map<Character, BoggleTrieNode> map;
    boolean isEnd;
    public BoggleTrieNode() {
        this.map = new HashMap<>();
        this.isEnd = false;
    }
}
class Trie {

    BoggleTrieNode root;
    public Trie() {
        this.root = new BoggleTrieNode();

    }

    public void insertWord(String word) {
        BoggleTrieNode run = this.root;

        for(char each: word.toCharArray()) {
            if(!run.map.containsKey(each)) {
                run.map.put(each, new BoggleTrieNode());
            }
            run  = run.map.get(each);
        }
        run.isEnd = true;
    }

    public boolean hasWord(String word) {
        BoggleTrieNode run = this.root;
        for(char each: word.toCharArray()) {
            if(!run.map.containsKey(each)) {
                return false;
            }
            run = run.map.get(each);
        }
        return run.isEnd;
    }
    public boolean hasPrefixOrEnd(String word) {
        BoggleTrieNode run = this.root;
        for(char each: word.toCharArray()) {
            if(!run.map.containsKey(each)) {
                return false;
            }
            run = run.map.get(each);
        }
        return run.isEnd || run.map.size() != 0;
    }
}
public class BoggleGame {

    Trie trie;
    public BoggleGame() {
        this.trie = new Trie();
    }
    public String getWord(List<int[]> path, char[][] board) {
        StringBuilder sb = new StringBuilder();

        int row = board.length;
        int col = board[0].length;

        for(int[] each: path) {
            sb.append(board[each[0]][each[1]]);
        }
        return sb.toString();
    }
    public List<String> findMostStr(char[][] board, Set<String> dict) {
        List<List<int[]>> paths = new ArrayList<>();
        for(String word: dict) {
            this.trie.insertWord(word);
        }
        int row = board.length;
        int col = board[0].length;

        // find all words in the board
        // output is in the "paths"
        // each path in the "paths" is a word
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                boolean[][] visited = new boolean[row][col];
                visited[i][j] = true;
                List<int[]> curPath = new ArrayList<>();
                curPath.add(new int[]{i, j});
                this.getWord(board, i, j, visited, new ArrayList<>(), this.trie, paths);
            }
        }
        List<String> res = new ArrayList<>();


        return res;
    }

    public void searchLongestWords(List<String> res, List<String> curWords, List<List<int[]>> paths, int st, boolean[][] visited, char[][] board) {

        if(st == paths.size()) {
            if(curWords.size() > res.size()) {
                res.clear();
                res = new ArrayList<>(curWords);
            }
            return;
        }

        for(int i=st; i<paths.size(); i++) {
            List<int[]> curPath = paths.get(i);
            boolean canUse = true;
            for(int[] each: curPath) {
                if(visited[each[0]][each[1]]) {
                    canUse = false;
                    break;
                }
            }
            if(canUse) {
                for(int[] each: curPath) {
                    visited[each[0]][each[1]] = true;
                }
                curWords.add(getWord(curPath, board));
                this.searchLongestWords(res, curWords, paths, i+1, visited, board);
                curWords.remove(curWords.size()-1);
                for(int[] each: curPath) {
                    visited[each[0]][each[1]] = false;
                }

            }
        }
    }

    // allPaths -> each path is a word
    public void getWord(char[][] board, int i, int j, boolean[][] visited, List<int[]> curPath, Trie trie, List<List<int[]>> allPaths) {
        int row = board.length;
        int col = board[0].length;
        String curWord = getWord(curPath, board);
        if(!trie.hasPrefixOrEnd(curWord)) {
            return;
        }
        if(trie.hasWord(curWord)) {
            allPaths.add(new ArrayList<>(curPath));
        }

        int[] newPos = new int[]{0, 1, 0, -1, 0};

        for(int a=0; a<4; a++) {
            int newx = i+ newPos[a];
            int newy = j + newPos[a+1];

            if(newx<0 || newy<0 || newx>=row || newy>col || visited[newx][newy]) {
                continue;
            }
            visited[newx][newy] = true;
            curPath.add(new int[]{newx, newy});
            this.getWord(board, newx, newy, visited, curPath, trie, allPaths);
            visited[newx][newy] = false;
            curPath.remove(curPath.size()-1);

        }


    }
}
