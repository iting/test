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

        LinkedList<String> qu = new LinkedList<String>(); // linkedList to get data in O(1) time
        for(String each: input) {
            qu.add(each);
        }
        List<String> result = new ArrayList<>();
        int count = 0;
        int ptr = 0;
        // use this to make sure no duplicate in the id
        Set<String> hosts = new HashSet<>();
        boolean reachEnd = false;

        while(!qu.isEmpty()) {

            String cur = qu.get(ptr);
            String hostID = cur.split(",")[0];

            if (!hosts.contains(hostID) || reachEnd) {
                result.add(cur);
                qu.remove(ptr);
                count += 1;
                hosts.add(hostID);
            } else {
                ptr += 1;
            }

            if (count == pageSize) {
                if (!input.isEmpty()) {
                    result.add(" ");
                }
                // reset everything
                count = 0;
                reachEnd = false;
                hosts = new HashSet<>();
                ptr = 0;
            }

            if (ptr == qu.size()) {
                ptr = 0;
                reachEnd = true;
            }
        }
        return result;
    }
}
