package com.company;

import java.util.*;

class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};

// LC: https://leetcode.com/problems/employee-free-time/
public class EmployeeFreeTime {

    public EmployeeFreeTime() {

    }

    public List<Interval> getFreeTime(List<List<Interval>> times) {

        List<Interval> tmp = new ArrayList<>();
        for(List<Interval> each: times) {
            tmp.addAll(each);
        }
        int size = tmp.size();
        List<Interval> res = new ArrayList<>();
        if(size <=1) {
            return res;
        }

        Interval prev = tmp.get(0);

        for(int i=1; i<size; i++) {
            Interval cur = tmp.get(i);
            if(prev.end < cur.start) {
                res.add(new Interval(prev.end, cur.start));
            }
            prev = prev.end > cur.end ? prev: cur;
        }

        return res;
    }
}
