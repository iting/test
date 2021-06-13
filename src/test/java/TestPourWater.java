import com.company.PourWater;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class TestPourWater {

    @Test
    public void testCase1() {
        // This test case is passing
        PourWater sol = new PourWater();
        int[] waterLand = new int[]{5, 4, 2, 1, 2, 3, 2, 1, 0, 1, 2, 4};
        int[] res = sol.pourWater(waterLand, 8, 5);

    }
}
