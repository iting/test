import com.company.DisplayPage;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class TestDisplayPage {
    @Test
    public void testCase1() throws IOException {
        // This test case is passing
        DisplayPage sol = new DisplayPage();
        List<String> input = Arrays.asList(
                "1,28,300.1,SanFrancisco",
                "4,5,209.1,SanFrancisco",
                "20,7,208.1,SanFrancisco",
                "23,8,207.1,SanFrancisco",
                "16,10,206.1,Oakland",
                "1,16,205.1,SanFrancisco",
                "6,29,204.1,SanFrancisco",
                "7,20,203.1,SanFrancisco",
                "8,21,202.1,SanFrancisco",
                "2,18,201.1,SanFrancisco",
                "2,30,200.1,SanFrancisco",
                "15,27,109.1,Oakland",
                "10,13,108.1,Oakland",
                "11,26,107.1,Oakland",
                "12,9,106.1,Oakland",
                "13,1,105.1,Oakland",
                "22,17,104.1,Oakland",
                "1,2,103.1,Oakland",
                "28,24,102.1,Oakland",
                "18,14,11.1,SanJose",
                "6,25,10.1,Oakland",
                "19,15,9.1,SanJose",
                "3,19,8.1,SanJose",
                "3,11,7.1,Oakland",
                "27,12,6.1,Oakland",
                "1,3,5.1,Oakland",
                "25,4,4.1,SanJose",
                "5,6,3.1,SanJose",
                "29,22,2.1,SanJose",
                "30,23,1.1,SanJose");
        List<String> res = sol.displayPages(input, 12);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        assertEquals("1,28,300.1,SanFrancisco", res.get(0));
        assertEquals("11,26,107.1,Oakland", res.get(11));

        assertEquals(" ", res.get(12));
        assertEquals("1,16,205.1,SanFrancisco", res.get(13));
        assertEquals("2,30,200.1,SanFrancisco", res.get(14));
        assertEquals("25,4,4.1,SanJose", res.get(24));
        assertEquals(" ", res.get(25));

        assertEquals("1,2,103.1,Oakland", res.get(26));
        assertEquals("3,11,7.1,Oakland", res.get(27));
        assertEquals("30,23,1.1,SanJose", res.get(30));
        assertEquals("1,3,5.1,Oakland", res.get(31));
    }

    @Test
    public void test2() {
        DisplayPage sol = new DisplayPage();
        String[] strs = new String[]{
                "1,28,310.6,SF",
                "4,5,204.1,SF",
                "20,7,203.2,Oakland",
                "6,8,202.2,SF",
                "6,10,199.1,SF",
                "1,16,190.4,SF",
                "6,29,185.2,SF",
                "7,20,180.1,SF",
                "6,21,162.1,SF",
                "2,18,161.2,SF",
                "2,30,149.1,SF",
                "3,76,146.2,SF",
                "2,14,141.1,San Jose"

        };
        List<String> input = new ArrayList<>(Arrays.asList(strs));
        List<String> result = sol.displayPages(input, 5);
        assertEquals(15, result.size());
        assertEquals("1,28,310.6,SF", result.get(0));
        assertEquals("7,20,180.1,SF", result.get(4));
        assertEquals(" ", result.get(5));
        assertEquals("6,10,199.1,SF", result.get(6));
        assertEquals("6,29,185.2,SF", result.get(10));
        assertEquals(" ", result.get(11));
        assertEquals("6,21,162.1,SF", result.get(12));
        assertEquals("2,14,141.1,San Jose", result.get(14));
    }
}

