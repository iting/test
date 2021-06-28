package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here


    }

    public static double helper(int num) {
        // 400 + 800 +  600
        if(num <=4000) {
            return num * 0.1;
        } else if(num>4000 && num<=8000) {
            return (num-4000) * 0.2 + helper(4000);
        } else if(num>8000) {
            return (num-8000) * 0.3 + helper(8000);
        } else {
            return 0;
        }
    }
}
