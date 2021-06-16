package com.company;


// 给substring 用 html的<b></b>加粗：
//
//        # input_string #String - 'abcxyz'
//
//        # substrings #Array[String] - ['abc', 'bcx']
//
//        # output: #String '<b>abcx</b>yz'
import java.util.*;

public class EnBoldText {

    public EnBoldText() {

    }

    public String enBold(String input, String[] arr) {

        List<int[]> intervals = new ArrayList<>();

        for(String each: arr) {
            String curInput = input;

            int index= curInput.indexOf(each);
            while(index != -1 && !curInput.isEmpty()) {
                // 0 3 (0, 1, 2, 3)
                // 1 3 (1, 2, 3, 4)
                intervals.add(new int[]{index, index+each.length()-1}); // (st, end)
                curInput = curInput.substring(index+each.length());
                index= curInput.indexOf(each);
            }
        }

        // sort interval by starting time
        Collections.sort(intervals, (a, b) -> (a[0]-b[0]));

        // merge interval
        int[] prev = intervals.size() != 0 ? intervals.get(0): null;

        List<int[]> result = new ArrayList<>();
        result.add(prev);

        for(int i=1; i<intervals.size(); i++) {
            int[] cur = intervals.get(i);
            if(prev[1]>=cur[0]) {
                // merge
                result.remove(result.size()-1);
                result.add(new int[]{Math.min(prev[0], cur[0]), Math.max(prev[1], cur[1])});
            } else {
                result.add(cur);
            }
            prev = result.get(result.size()-1);
        }

        StringBuilder sb = new StringBuilder();

        int g_st = 0;
        for(int[] each: result) {
            int st = each[0];
            int end = each[1];
            String before_cur = input.substring(g_st, st);
            String cur = input.substring(st, end+1);
            sb.append(before_cur);
            sb.append("<b>");
            sb.append(cur);
            sb.append("</b>");
            g_st = end +1;
        }
        int[] lastOne = result.get(result.size()-1);
        sb.append(input.substring(lastOne[1]));

        return sb.toString();
    }
}
