import com.company.TravelBuddy;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class TestTravelBuddy {


    @Test
    public void TestCase1() {

        Set<String> myWishList = new HashSet<>(Arrays.asList(new String[]{"a", "b", "c", "d"}));

        Set<String> wishList1 = new HashSet<>(Arrays.asList(new String[]{"a", "b", "e", "f"}));
        Set<String> wishList2 = new HashSet<>(Arrays.asList(new String[]{"a", "c", "d", "g"}));
        Set<String> wishList3 = new HashSet<>(Arrays.asList(new String[]{"c", "f", "e", "g"}));

        Map<String, Set<String>> friendWishLists = new HashMap<>();

        friendWishLists.put("Buddy1", wishList1);
        friendWishLists.put("Buddy2", wishList2);
        friendWishLists.put("Buddy3", wishList3);

        TravelBuddy sol = new TravelBuddy(myWishList, friendWishLists );
        List<String> res = sol.getRecommendedCities(10);
        assertEquals(3, res.size());
        System.out.println(res);
        assertEquals("g", res.get(0));
        assertEquals("e", res.get(1));
        assertEquals("f", res.get(2));
    }

}
