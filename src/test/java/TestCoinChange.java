import com.company.CoinChange;
import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.assertEquals;


public class TestCoinChange {
    @Test
    public void testCase1() throws IOException {
        // This test case is passing
        CoinChange sol = new CoinChange();
        int[] coins = new int[]{1, 2, 5, 10};
        int res = sol.getMinCoins(coins, 3);
        assertEquals(res, 2);
        assertEquals(sol.getMinCoins(coins,100), 10);
        assertEquals(sol.getMinCoins(coins,11), 2);

    }

}
