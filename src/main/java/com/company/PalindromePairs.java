package com.company;

import java.util.*;

// https://leetcode.com/problems/palindrome-pairs/
// return a list of index

class PTrieNode {
    PTrieNode[] child;
    int wordIndex;
    List<Integer> wordIndexList;
    public PTrieNode() {
        this.child = new PTrieNode[26];
        this.wordIndex = -1;
        this.wordIndexList = new ArrayList<>();
    }
}
public class PalindromePairs {
    PTrieNode root;
    public PalindromePairs() {
        this.root = new PTrieNode();
    }

    public List<List<Integer>> findPairs(String[] words) {

        List<List<Integer>> res = new ArrayList<>();
        // A + B
        // case1: A is empty, B is palindrome
        // example: |aba
        // case2: the trailing portion of A is palindrome and we are able to find a B word's reverse is the same content as first part of A
        // example: abcddd|cba
        // case3: the front part of B is palindrome
        // example: abc|dddcba

        // we could use trie and insert word reversely into the trie
        for(int i=0; i<words.length; i++) {
            this.insertWord(words[i], i);
        }

        for(int i=0; i<words.length; i++) {
            this.searchWord(words[i], res, i);
        }
        return res;
    }

    private void searchWord(String word, List<List<Integer>> result, int currentWordIndex) {

        PTrieNode cur = this.root;

        // search from the front
        char[] arr = word.toCharArray();
        int size = word.length();
        for(int i=0; i<size; i++) {
            if(cur.wordIndex != -1 && this.isPal(arr, i, size-1)) {
                result.add(Arrays.asList(currentWordIndex, cur.wordIndex));
            }
            int pos = arr[i] - 'a';
            if(cur.child[pos] == null) {
                return;
            }
            cur = cur.child[pos];
        }
        if(cur.wordIndex != -1 && cur.wordIndex != currentWordIndex) {
            result.add(Arrays.asList(currentWordIndex, cur.wordIndex ));
        }

        for(int each: cur.wordIndexList) {
            result.add(Arrays.asList(currentWordIndex, each));
        }
    }

    // insert word into the trie in reverse order
    private  void insertWord(String word, int wIndex) {
        PTrieNode cur = this.root;

        char[] arr = word.toCharArray();
        int len = arr.length;

        for(int i=len-1; i>=0; i--) {
            if(this.isPal(arr, 0, i)) {
                cur.wordIndexList.add(wIndex);
            }
            int pos = arr[i] -'a';
            if(cur.child[pos] == null) {
                cur.child[pos] = new PTrieNode();
            }
            cur = cur.child[pos];
        }
        cur.wordIndex = wIndex;

    }
    private boolean isPal(char[] arr, int st, int end) {

        while(st < end) {
            if(arr[st] != arr[end]) {
                return false;
            }
            st +=1;
            end -=1;
        }

        return true;
    }
}
