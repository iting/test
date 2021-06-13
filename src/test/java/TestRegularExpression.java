import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.company.RegularExpression;

public class TestRegularExpression {

    @Test
    public void testCase() {
        RegularExpression sol = new RegularExpression();
        assertEquals(sol.isMatch("saaaa", "s+a*"), true);
        assertEquals(sol.isMatch("saaaa", "s+b*"), false);
        assertEquals(sol.isMatch("saaaab", "s+a*"), false);
        assertEquals(sol.isMatch("saaaab", "s+b*"), false);
    }

    @Test
    public void test2() {
        RegularExpression sol = new RegularExpression();
        assertEquals(sol.isMatch("saaaa", "s+a*"), true);
        assertEquals(sol.isMatch("saaaa", "s+b*"), false);
        assertEquals(sol.isMatch("saaaab", "s+a*"), false);
        assertEquals(sol.isMatch("saaaab", "s+b*"), false);
    }
}
