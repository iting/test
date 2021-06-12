import com.company.PalindromePairs;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestPalindromePairs {

    @Test
    public void testCase1() throws IOException {
        // This test case is passing
        PalindromePairs sol = new PalindromePairs();
        String[] words = new String[] {"abcd","dcba","lls","s", "sssll"};
        List<List<Integer>> res = sol.findPairs(words);
        for(int i=0; i<res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
