import org.junit.Test;
import com.company.QueueWithFixedSize;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TestQueueWithFixedSize {
    @Test
    public void testCase1() throws IOException {
        // This test case is passing
        QueueWithFixedSize queue = new QueueWithFixedSize(5);
        queue.offer(1);
        queue.offer(2);
        int res = queue.poll();
        assertEquals(1, res);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.offer(9);
        res = queue.poll();
        assertEquals(2, res);
        res = queue.poll();
        assertEquals(3, res);



    }
}
