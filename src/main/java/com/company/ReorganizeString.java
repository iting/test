package com.company;

// LC: https://leetcode.com/problems/reorganize-string/
//Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
//
// Return any possible rearrangement of s or return "" if not possible.
// Example:
//Input: s = "aab"
//Output: "aba"

import java.util.*;

public class ReorganizeString {

    public ReorganizeString() {

    }

    public String reOrg(String input) {

        // step1: use map to determine the max number of char
        int maxNum =0;
        char maxChar = ' ';
        if(input.isEmpty() || input.length()<=1) {
            return input;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char each: input.toCharArray()) {
            map.put(each, map.getOrDefault(each, 0) +1);
            if(map.get(each) > maxNum) {
                maxNum = map.get(each);
                maxChar = each;
            }
        }

        // we need to separate maxChar.
        // if maxChar has two, then we need to have at least maxCharNum -1 different char
        // count the number of char that is different from maxChar

        int diff = 0;
        for(char each: map.keySet()) {
            if(each != maxChar) {
                diff += map.get(each);
            }
        }
        if(diff < (maxNum -1)) {
            return "";
        }

        List<StringBuilder> arr = new ArrayList<>();
        for(int i=0; i<maxNum; i++) {
            arr.add(new StringBuilder());
            arr.get(i).append(maxChar);
        }

        // insert different char
        int pos = 0;

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            char key = entry.getKey();
            int count = entry.getValue();
            if(key == maxChar) {
                continue;
            }
            for(int i=0; i<count; i++){
                arr.get(pos).append(key);
                pos = (pos+1) % maxNum;
            }
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder each: arr) {
            res.append(each.toString());
        }
        return res.toString();

    }

}
