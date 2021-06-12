import com.company.IpRangeToCIDR;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestIPRangeToCIDR {
    @Test
    public void testCase1() throws IOException {
        // This test case is passing
        IpRangeToCIDR sol = new IpRangeToCIDR();
        List<String> res = sol.convert("255.0.0.7", 10);
        for(int i=0; i<res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

//    @Test
//    public void testCase2() throws IOException {
//        // This test case is failing
//        HelloWorld helloWorld = new HelloWorld("input/test_2.txt");
//        String actualOutput = helloWorld.run();
//        assertEquals("hello-world\n", actualOutput);
//    }
}
