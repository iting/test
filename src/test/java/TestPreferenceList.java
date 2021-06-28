import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;
import com.company.PreferenceList;

public class TestPreferenceList {

    @Test
    public void TestCase1() {
        PreferenceList sol = new PreferenceList();
        List<List<Integer>> preferences = new ArrayList<>();
        List<Integer> p1 = new ArrayList<Integer>() {{
            add(2);
            add(3);
            add(5);
        }};
        List<Integer> p2 = new ArrayList<Integer>() {{
            add(4);
            add(2);
            add(1);
        }};
        List<Integer> p3 = new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(5);
            add(6);
        }};
        List<Integer> p4 = new ArrayList<Integer>() {{
            add(4);
            add(7);
        }};
        preferences.add(p1);
        preferences.add(p2);
        preferences.add(p3);
        preferences.add(p4);
        List<Integer> res = sol.getPreference(preferences);

        assertEquals(7, res.size());
        System.out.println(res);
        assertEquals(4, (int) res.get(0));
        assertEquals(2, (int) res.get(1));
        assertEquals(7, (int) res.get(2));
//        assertEquals(1, (int) res.get(3));
//        assertEquals(3, (int) res.get(4));
        assertEquals(5, (int) res.get(5));
        assertEquals(6, (int) res.get(6));

    }

}
