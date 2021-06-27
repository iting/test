import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;
import com.company.ParseCSV;


public class TestParseCSV {

    @Test
    public void testCase() {
        ParseCSV sol = new ParseCSV();

        String test = "John,Smith,john.smith@gmail.com,Los Angeles,1";
        String expected = "John|Smith|john.smith@gmail.com|Los Angeles|1";
        assertEquals(expected, sol.parse(test));

        test = "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0";
        expected = "Jane|Roberts|janer@msn.com|San Francisco, CA|0";
        assertEquals(expected, sol.parse(test));

        test = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1";
        expected = "Alexandra \"Alex\"|Menendez|alex.menendez@gmail.com|Miami|1";
        assertEquals(expected, sol.parse(test));

        test = "\"\"\"Alexandra Alex\"\"\"";
        expected = "\"Alexandra Alex\"";
        assertEquals(expected, sol.parse(test));

        char cur = '\"';
        System.out.println(test);
        System.out.println(cur);
    }

}
