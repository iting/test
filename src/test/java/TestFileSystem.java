import com.company.FileSystem;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TestFileSystem {

    @Test
    public void testCase1() throws IOException {
        // This test case is passing
        FileSystem sol = new FileSystem();
        String[] words = new String[] {"abcd","dcba","lls","s", "sssll"};
        sol.mkdir("/a/b/c");
        List<String> res = sol.ls("/a");

    }

}
