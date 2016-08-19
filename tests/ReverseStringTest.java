import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by davidzhou on 8/18/16.
 */
public class ReverseStringTest {
    private ReverseString solution = new ReverseString();
    @Test
    public void reverseString() throws Exception {
        assertEquals(solution.reverseString("hello"), "olleh");
    }

}