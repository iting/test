package com.company;
import java.util.*;


public class PyramidTransitionMatrix {


    Map<String, List<String>> map;

    public PyramidTransitionMatrix(String[] lines) {
        this.map = new HashMap<>();
        for(String line : lines) {
            String[] splits = line.split(",");
            String key = splits[0] + splits[1];
            if(!this.map.containsKey(key)) {
                this.map.put(key, new ArrayList<>());
            }
            for(int i=0; i<splits[2].length(); i++) {
                this.map.get(key).add(String.valueOf(splits[2].charAt(i)));
            }

        }

    }
    public boolean check(String input) {
        return this.helper(input);
    }

    public void getCombo(String input, int pos, List<String> result, StringBuilder sb) {
        if(pos == input.length()-1) {
            result.add(sb.toString());
            return;
        }

        String curKey = input.substring(pos, pos+2);
        List<String> list = this.map.get(curKey);

        for(String each: list) {
            sb.append(each);
            this.getCombo(input, pos+1,result, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public boolean helper(String input) {
        if(input.length() ==1) {
            return true;
        }
        for(int i=0; i<input.length()-1; i++) {
            String key = input.substring(i, i+2);
            if(!this.map.containsKey(key)) {
                return false;
            }
        }
        List<String> combi = new ArrayList<>();
        this.getCombo(input, 0, combi, new StringBuilder());

        for(String each: combi) {
            if(this.helper(each)) {
                return true;
            }
        }
        return false;
    }
}
