package com.company;
import java.util.*;

public class ParseCSV {

    public ParseCSV() {

    }
    public String parse(String input) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int st = 0;
        int len = input.length();
        boolean isInQuote = false;
        while(st < len) {
            char cur = input.charAt(st);

            if(isInQuote) {
                if(cur == '\"') {
                    if(st+1 < len && input.charAt(st+1) == '\"') {
                        sb.append("\"");
                        st +=1;
                    } else {
                        isInQuote = false; // encounter the ending quote so we ende the quote
                    }
                } else {
                    sb.append(cur);
                }

            } else {
                if(cur == '\"') {
                    isInQuote = true;
                } else if (cur == ','){
                    res.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(cur);
                }
            }
            st +=1;
        }

        if(sb.length() > 0) {
            res.add(sb.toString());
        }

        return String.join("|", res);
    }
}
