
import org.junit.Test;
import com.company.ListOfIterator;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import java.util.*;

public class TestListOfIterator {

    @Test
    public void test1() {
        List<List<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<Integer>() {{
            add(1);
            add(2);
        }});
        test.add(new ArrayList<Integer>() {{
            add(3);
        }});
        test.add(new ArrayList<Integer>() {{
            add(4);
            add(5);
            add(6);
        }});
        ListOfIterator sol = new ListOfIterator(test);
        assertTrue(sol.hasNext());
        assertEquals(1, (int) sol.next());
        sol.remove();
        List<Integer> res = new ArrayList<>();
        while (sol.hasNext()) {
            res.add(sol.next());
        }
        assertEquals(5, res.size());
        assertEquals(2, (int) res.get(0));
        assertEquals(4, (int) res.get(2));
        assertEquals(6, (int) res.get(4));

        test = new ArrayList<>();
        test.add(new ArrayList<Integer>() {{
            add(1);
            add(2);
        }});
        test.add(new ArrayList<Integer>() {{
            add(3);
        }});
        sol = new ListOfIterator(test);
        assertTrue(sol.hasNext());
        assertEquals(1, (int) sol.next());
        assertTrue(sol.hasNext());
        assertEquals(2, (int) sol.next());
        sol.remove();
        assertTrue(sol.hasNext());
        assertEquals(3, (int) sol.next());
    }

    @Test
    public void test2() {
        List<List<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<Integer>() {{
            add(1);
            add(2);
        }});
        test.add(new ArrayList<Integer>() {{
            add(3);
        }});
        test.add(new ArrayList<Integer>() {{
            add(4);
            add(5);
            add(6);
        }});
        ListOfIterator sol = new ListOfIterator(test);
        assertTrue(sol.hasNext());
        assertEquals(1, (int) sol.next());
        sol.remove();
        List<Integer> res = new ArrayList<>();
        while (sol.hasNext()) {
            res.add(sol.next());
        }
        assertEquals(5, res.size());
        assertEquals(2, (int) res.get(0));
        assertEquals(4, (int) res.get(2));
        assertEquals(6, (int) res.get(4));

        test = new ArrayList<>();
        test.add(new ArrayList<Integer>() {{
            add(1);
            add(2);
        }});
        test.add(new ArrayList<Integer>() {{
            add(3);
        }});


        sol = new ListOfIterator(test);
        assertTrue(sol.hasNext());
        assertEquals(1, (int) sol.next());
        assertTrue(sol.hasNext());
        assertEquals(2, (int) sol.next());
        sol.remove();
        assertTrue(sol.hasNext());
        assertEquals(3, (int) sol.next());
    }
}
