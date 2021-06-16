import com.company.EnBoldText;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class TestEnBoldText {

    @Test
    public void testCase() {
        EnBoldText sol = new EnBoldText();

        String[] arr = new String[]{"abc", "bcx"};
        assertEquals("123<b>abcx</b>xyz", sol.enBold("123abcxyz", arr));
    }
}
