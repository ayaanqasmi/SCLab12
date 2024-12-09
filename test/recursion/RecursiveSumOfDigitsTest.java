package recursion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for RecursiveSumOfDigits program.
 */
public class RecursiveSumOfDigitsTest {

    @Test
    public void testSingleDigit() {
        assertEquals(5, RecursiveSumOfDigits.sumOfDigits(5));
        assertEquals(9, RecursiveSumOfDigits.sumOfDigits(-9));
    }

    @Test
    public void testMultipleDigits() {
        assertEquals(6, RecursiveSumOfDigits.sumOfDigits(123));
        assertEquals(15, RecursiveSumOfDigits.sumOfDigits(-456));
    }

    @Test
    public void testZero() {
        assertEquals(0, RecursiveSumOfDigits.sumOfDigits(0));
    }

    @Test
    public void testLargeNumber() {
    
        assertEquals(36, RecursiveSumOfDigits.sumOfDigits(9999));
        assertEquals(28, RecursiveSumOfDigits.sumOfDigits(-1234567));
    }
}
