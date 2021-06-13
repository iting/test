package com.company;
import java.util.*;


// worse case,
// input is all duplicate
// [1,1,1,1,1,1]
// O(n^2)
// normal case: O(n * pageSize)
public class DisplayPage {

    public DisplayPage() {

    }

    public List<String> displayPages(List<String> input, int pageSize) {
        // one page has only 12 items
        // output should separate each 12 items by space
        // each user might have more than 1 listing in the input.
        // for the response, we want to optimize for all users to show their listing
        // instead of showing one user's listing several times

        LinkedList<String> qu = new LinkedList<String>();
        for(String each: input) {
            qu.add(each);
        }
        List<String> result = new ArrayList<>();
        int count = 0;
        // use this to make sure no duplicate in the id
        Set<String> set = new HashSet<>();
        boolean isEnd = false;
        int i = 0;

        while(!qu.isEmpty()) {

            String cur = qu.get(i);

            String user_id = cur.split(",")[0];

            // 1. try best to make sure no duplicate
            // 2. or if we reached the end of the queue, we are forced to use duplicate id
            if(!set.contains(user_id) || isEnd) {
                set.add(user_id);
                result.add(cur);
                count +=1;
                qu.remove(i);
            } else {
                i+=1;
            }

            if(count == pageSize) {
                if(!input.isEmpty()) {
                    result.add(" ");
                }
                // reset everything since we can start the next page
                count = 0;
                set.clear();
                i = 0;
                isEnd = false;
            }

            if(i == qu.size()) {
                isEnd = true;
                i = 0;
            }

        }
        return result;
    }
}
