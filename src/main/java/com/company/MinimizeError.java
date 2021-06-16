package com.company;
import java.util.*;


public class MinimizeError {

    public static String minimizeError(String[] prices, int target) {

        PriorityQueue<Double> pq = new PriorityQueue<>();

        int sum = 0;

        for(String price: prices) {
            double cur = Double.parseDouble(price);
            int low = (int)(cur);
            int ceiling = low +1;
            if(cur != low) {
                pq.add((ceiling - cur)); // 把最小差別的放進去
            }
            sum += low;
        }

        // 如果最小的 加起來都還大於 target 那就是不可能了
        if(sum > target) {
            return "-1";
        }
        if((sum + pq.size())< target ) {
            return "-1";
        }

        int diff = target -sum;
        float error = 0;

        while(!pq.isEmpty()) {
            double cur = pq.poll();
            if(diff>0) {
                error += cur;
            } else {
                error += (1.0-cur);
            }
            diff -=1;
        }

        return String.format("%.3f",error);

    }
}
