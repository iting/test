import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;
import com.company.PyramidTransitionMatrix;



public class TestPyramidTransitionMatrix {

    @Test
    public void test1() {
        String[] lines = {
                "A,A,AC", "A,B,CD", "A,C,D", "A,D,B",
                "B,A,B", "B,B,C", "B,C,A", "B,D,CD",
                "C,A,A", "C,B,C", "C,C,D", "C,D,B",
                "D,A,BC", "D,B,D", "D,C,A", "D,D,C"
        };
        PyramidTransitionMatrix sol = new PyramidTransitionMatrix(lines);
        // sol.check("ABCD");
        assertTrue(sol.check("ABCD"));
        assertTrue(sol.check("AACC"));
        assertTrue(sol.check("AAAA"));
        assertFalse(sol.check("CCCC"));
        assertFalse(sol.check("DDDD"));
    }
}
