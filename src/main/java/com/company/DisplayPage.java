package com.company;
import java.util.*;

public class DisplayPage {

    public DisplayPage() {

    }

    public List<String> displayPages(List<String> input, int pageSize) {
        // one page has only 12 items
        // output should separate each 12 items by space
        // each user might have more than 1 listing in the input.
        // for the response, we want to optimize for all users to show their listing
        // instead of showing one user's listing several times

        Iterator<String> iter = input.iterator();
        List<String> result = new ArrayList<>();
        int count = 0;
        // use this to make sure no duplicate in the id
        Set<String> set = new HashSet<>();
        boolean isEnd = false;
        while(iter.hasNext()) {
            String cur = iter.next();
            String user_id = cur.split(",")[0];
            if(!set.contains(user_id) || isEnd) {
                set.add(user_id);
                result.add(cur);
                iter.remove();
                count +=1;
            }
            if(count == pageSize) {
                if(!input.isEmpty()) {
                    result.add(" ");
                }
                count = 0;
                iter = input.iterator(); // ??
                set.clear();
                isEnd = false;
            }
            if(!iter.hasNext()) {
                isEnd = true;
                iter = input.iterator(); // ??
            }

        }
        return result;
    }
}
