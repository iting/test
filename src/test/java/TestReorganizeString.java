import com.company.ReorganizeString;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestReorganizeString {


    @Test
    public void TestCase1() {
        ReorganizeString sol = new ReorganizeString();
        assertEquals(sol.reOrg("aaab"), "");
    }

    @Test
    public void TestCase2() {
        ReorganizeString sol = new ReorganizeString();
        assertEquals(sol.reOrg("aab"), "aba");
    }

}
