package simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class SkippedTests {
    @Test
    @Disabled
    void test1 () {
        assertTrue(true);
    }
    @Test
    @Disabled
    void test2 () {
        assertTrue(true);
    }
}
