import com.company.MaxNumberOfEventsAttend;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
public class TestMaxNumEventToAttend {

    @Test
    public void testCase1() throws IOException {
        // This test case is passing
        MaxNumberOfEventsAttend sol = new MaxNumberOfEventsAttend();
        int[][] events = new int[][] {{1,2},{2,3}, {1,2},{3,4}};

        int res = sol.getMaxNumberOfEventsToAttend(events);
        assertEquals(res, 4);
        // day1: attend {1,2}
        // day2: attend another {1,2}
        // day3: attend {2,3}
        // day4: attend {3,4}
        // see explanation here: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/discuss/523654/Why-12233412-gives-4
    }


    @Test
    public void testCase2() throws IOException {
        // This test case is passing
        MaxNumberOfEventsAttend sol = new MaxNumberOfEventsAttend();
        int[][] events = new int[][] {{1,2},{2,3}, {3,4}};

        int res = sol.getMaxNumberOfEventsToAttend(events);
        assertEquals(res, 3);
    }
}
