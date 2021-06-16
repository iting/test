package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int num = 10000;
        // first 4000 -> 10%
        // >4000 <=8000 -> 20%
        // > 8000 -> 30%
//        Map<Int>
        double tax = helper(num);
        System.out.println(tax);
        String input = "2014-01-09T06:16:53.748849+00:00 heroku[router]: at=info method=POST path=/api/online/platforms/facebook_canvas/users/100002266342173/add_ticket host=mygame.heroku.com fwd=\"94.66.255.106\" dyno=web.12 connect=12ms service=21ms status=200 bytes=782014-01-09T06:16:53.742892+00:00 heroku[router]: at=info method=GET path=/api/users/100002266342173/count_pending_messages host=mygame.heroku.com fwd=\"94.66.255.106\" dyno=web.8 connect=9ms service=9ms status=304 bytes=02014-01-09T06:16:53.766841+00:00 heroku[router]: at=info method=POST path=/logs/save_personal_data host=mygame.heroku.com fwd=\"5.13.87.91\" dyno=web.10 connect=1ms service=42ms status=200 bytes=16";
        String[] out = input.split(" ");
        for(int i=0; i<out.length; i++) {
            System.out.println(out[i]);
        }

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
