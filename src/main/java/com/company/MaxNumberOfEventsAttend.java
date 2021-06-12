package com.company;
import java.util.*;

// LC question: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/submissions/
// wiki: https://en.wikipedia.org/wiki/Interval_scheduling#Interval_Scheduling_Maximization
// greedy
public class MaxNumberOfEventsAttend {


    // the idea is that
    // you always pick the event that ended early first
    // once you attended that one, you need to remove all other events that doesn't meet.
    public MaxNumberOfEventsAttend() {

    }

    public int getMaxNumberOfEventsToAttend(int[][] events) {
        int count = 0;
        int size = events.length;
        Arrays.sort(events, (a, b) -> (a[1]-b[1]));
        int lastEventEndTime = events[size-1][1];

        // sort by starting time
        Arrays.sort(events, (a, b)->(a[0] - b[0]));

        // to store the end time of each event
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int st = 0;

        for(int day=1; day<=lastEventEndTime; day++) {
            while(st < size && events[st][0] == day) {
                pq.add(events[st][1]);
                st +=1;
            }
            // remove those events whose end time is already less than current day
            while(!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
            if(!pq.isEmpty()) {
                pq.poll();
                count +=1;
            }
        }
        return count;
    }
}
