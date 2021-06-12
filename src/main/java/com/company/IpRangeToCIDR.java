package com.company;
import java.util.*;



public class IpRangeToCIDR {

    public IpRangeToCIDR() {

    }

    public List<String> convert(String ips, int n) {
        String[] split = ips.split("\\.");

        int cur_num = this.convertToInt(split);
        System.out.println(cur_num);
        List<String> res = new ArrayList<>();
        while(n>0) {
            // find number of training zeros
            // this will be the number of bits that we could use at the end which will share the same common prefix
            int couldUseBits = Integer.numberOfTrailingZeros(cur_num);
            // start with one because this is the current IP address/cur_num
            int numNewIPCount  = 1;
            int numUsedBit = 0;

            // every time you adopt a new bit, we will be able to generate (2 ^  numNewIPCount) new IPs;
            while(numNewIPCount < n &&  numUsedBit<couldUseBits) {
                numNewIPCount = numNewIPCount << 1;
                numUsedBit +=1;
            }

            // if number of new IP generated is larger than what we need, we decrease it
            if(numNewIPCount > n) {
                numNewIPCount = numNewIPCount >> 1;
                numUsedBit -=1;
            }

            // Add the result into the array
            res.add(convertToIpString(cur_num, 32-numUsedBit));

            // n minus number of new ip count
            n = n - numNewIPCount;
            // increment the cur_num by numNewIPCount
            cur_num = cur_num + numNewIPCount;
        }
        return res;
    }

    // to convert back to original IP String based 256
    private String convertToIpString(int num, int count) {
        StringBuilder sb = new StringBuilder();

        for(int i=3; i>=0; i--) {
            int tmp = (num>>(i*8))&255;
            sb.append(String.valueOf(tmp));
            if(i!=0) {
                sb.append(".");
            }
        }

        sb.append("/");
        sb.append(count);
        return sb.toString();

    }
    private int convertToInt(String[] input) {
        int sum = 0;
        for(int i=0; i<input.length; i++) {
            sum = sum * 256 + Integer.parseInt(input[i]);
        }
        return sum;
    }

}
