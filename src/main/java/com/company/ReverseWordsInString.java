package com.company;

public class ReverseWordsInString {


    public ReverseWordsInString() {

    }

    public String reverseWords(String s) {

        int st = 0;
        int len = s.length();
        if(len == 0) {
            return s;
        }
        int end = len-1;

        while(st < len && s.charAt(st) == ' ') {
            st+=1;
        }

        while(end >=0 && s.charAt(end) == ' ') {
            end -=1;
        }
        String trims = s.substring(st, end+1);


        st = 0;
        len = trims.length();
        StringBuilder sb = new StringBuilder();
        String result = "";
        while(st < len) {
            end = this.findNext(trims, st);
            String word = trims.substring(st, end);
            result = word + " " + result;
            st = end +1;
            while(st < len && trims.charAt(st) == ' ') {
                st +=1;
            }
        }

        return result.substring(0, result.length()-1);

    }


    public int findNext(String cur, int pos) {
        int end = pos;
        while(end<cur.length() && cur.charAt(end) != ' ') {
            end+=1;
        }
        return end;
    }
}
