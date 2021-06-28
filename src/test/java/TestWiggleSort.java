import com.company.MaxNumberOfEventsAttend;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.company.WiggleSort2;

public class TestWiggleSort {

    @Test
    public void testCase1() {
        WiggleSort2 sol = new WiggleSort2();
        int[] nums = new int[]{3,4,5,1,2,7};
        sol.sort(nums);

        for(int i=0; i<nums.length-1; i++) {
            if(i % 2 == 0) {
                assertTrue(nums[i] < nums[i+1]);
            } else {
                assertTrue(nums[i] > nums[i+1]);
            }
        }
    }

    @Test
    public void testCase2() {
        WiggleSort2 sol = new WiggleSort2();
        int[] nums = new int[]{5,6,7,8,9, 1};
        sol.sort(nums);

        for(int i=0; i<nums.length-1; i++) {
            if(i % 2 == 0) {
                assertTrue(nums[i] < nums[i+1]);
            } else {
                assertTrue(nums[i] > nums[i+1]);
            }
        }
    }

}
