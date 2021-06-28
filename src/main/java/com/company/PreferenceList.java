package com.company;
import java.util.*;


public class PreferenceList {

    public PreferenceList() {

    }

    public List<Integer> getPreference(List<List<Integer>> preferences) {

        List<Integer> res = new ArrayList<>();
        // topological sorting
        Map<Integer, List<Integer>> neis = new HashMap<>();
        Map<Integer, Integer> edges = new HashMap<>();
        for(List<Integer> preference: preferences) {
            for(int each: preference) {
                edges.put(each, 0);
            }
        }

        for(List<Integer> preference: preferences) {
            int size = preference.size();

            for(int i=0; i<size-1; i++) {
                int from = preference.get(i);
                int to = preference.get(i+1);
                if(!neis.containsKey(from)) {
                    neis.put(from, new ArrayList<>());
                }
                neis.get(from).add(to);
                edges.put(to, edges.getOrDefault(to, 0)+1);
            }
        }

        Queue<Integer> qu = new LinkedList<>();
        for(int key: edges.keySet()) {
            if(edges.get(key) == 0) {
                qu.add(key);
            }
        }
        System.out.println(qu.size());
        if(qu.size() == 0) {

            return res;
        }

        while(!qu.isEmpty()) {
            int cur = qu.poll();
            res.add(cur);

            for(int each: neis.getOrDefault(cur, new ArrayList<>())) {
                edges.put(each, edges.get(each) - 1);
                if(edges.get(each) == 0) {
                    qu.add(each);
                }
            }
        }
        return res;
    }


}
