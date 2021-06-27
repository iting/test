import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.assertEquals;
import java.util.*;

import com.company.TenWizard;

public class TestTenWizard {

    @Test
    public void TestCase1() {
        TenWizard sol = new TenWizard();
        int[][] ids = {{1, 5, 9}, {2, 3, 9}, {4}, {}, {}, {9}, {}, {}, {}, {}};
        List<List<Integer>> wizards = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            List<Integer> wizard = new ArrayList<>();
            for (int j = 0; j < ids[i].length; j++) {
                wizard.add(ids[i][j]);
            }
            wizards.add(wizard);
        }
        List<Integer> res = sol.getShortestPath(wizards, 0, 9);
        System.out.println(res);

        assertEquals(3, res.size());
        assertEquals(0, (int) res.get(0));
        assertEquals(5, (int) res.get(1));
        assertEquals(9, (int) res.get(2));
    }

    @Test
    public void test2() {
        TenWizard sol = new TenWizard();
        int[][] ids = {{1, 5, 9}, {2, 3, 9}, {4}, {}, {}, {9}, {}, {}, {}, {}};
        List<List<Integer>> wizards = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            List<Integer> wizard = new ArrayList<>();
            for (int j = 0; j < ids[i].length; j++) {
                wizard.add(ids[i][j]);
            }
            wizards.add(wizard);
        }
        List<Integer> res = sol.getShortestPath(wizards, 0, 9);
        assertEquals(3, res.size());
        assertEquals(0, (int) res.get(0));
        assertEquals(5, (int) res.get(1));
        assertEquals(9, (int) res.get(2));
    }

}
