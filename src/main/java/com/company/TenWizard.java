package com.company;
import java.util.*;



class Wizard implements Comparable<Wizard> {
    int num;
    int dist;
    public Wizard(int num) {
        this.num = num;
        this.dist = Integer.MAX_VALUE;
    }

    @Override
    public int compareTo(Wizard that) {
        return this.dist - that.dist;
    }
}

public class TenWizard {

    public TenWizard() {

    }

    public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {
        List<Integer> result = new ArrayList<>();
        // wizard[0] list: 1, 4, 5 
        //
        // wizard[4] list: 9
        //
        // wizard 0 to 9 min distance is (0-4)^2+(4-9)^2=41 (wizard[0]->wizard[4]->wizard[9])

        Map<Integer, Wizard> map = new HashMap<>();
        int len = wizards.size();
        int[] parents = new int[len];
        for(int i=0; i<len; i++) {
            map.put(i, new Wizard(i));
            parents[i] = i;
        }

        map.get(source).dist = 0;
        Queue<Wizard> qu = new LinkedList<>();
        qu.add(map.get(source));

        while(!qu.isEmpty()) {
            Wizard cur = qu.poll();

            List<Integer> neis = wizards.get(cur.num);
            for(int nei: neis) {

                int dist = Math.abs(cur.num - nei);
                int weight = dist * dist;

                if(cur.dist + weight < map.get(nei).dist) {
                    map.get(nei).dist = cur.dist + weight;
                    parents[nei] = cur.num;
                }
                qu.add(map.get(nei));
            }
        }

        int st = target;

        while(st != source) {
            result.add(0, st);
            st = parents[st];
        }
        result.add(0, source);
        return result;
    }
}
