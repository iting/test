
import com.company.MinimizeError;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMinimizeError {

    @Test
    public void testCase() {

        String[] arr = new String[]{"0.700", "2.800", "4.900"};
        String res = MinimizeError.minimizeError(arr, 8);
        System.out.println(res);
        assertEquals(res, "1.000");
    }
}
