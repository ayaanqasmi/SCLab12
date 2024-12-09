package recursion;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Assert;
import org.junit.Test;


public class ParserTest {

    @Test
    public void testSimpleExpressions() {
    	
    	
        assertEquals(8.0, Parser.evaluateExpression("3 + 5"), 0.001);
        assertEquals(6.0, Parser.evaluateExpression("2 * 3"), 0.001);
        assertEquals(2.0, Parser.evaluateExpression("6 / 3"), 0.001);
    }

    @Test
    public void testOperatorPrecedence() {
        assertEquals(13.0, Parser.evaluateExpression("3 + 5 * 2"), 0.001);
        assertEquals(-1.0, Parser.evaluateExpression("3 - 5 + 1"), 0.001);
    }

    @Test
    public void testParentheses() {
    	System.out.println(Parser.evaluateExpression("(3 + 5) * 3.75"));
        assertEquals(-27.0, Parser.evaluateExpression("3 + 5 * (2 - 8)"), 0.001);
        assertEquals(30.0, Parser.evaluateExpression("(3 + 5) * 3.75"), 0.001);
    }

    @Test
    public void testFloatingPoint() {
        assertEquals(7.25, Parser.evaluateExpression("3.5 + 3.75"), 0.001);
        assertEquals(3.0, Parser.evaluateExpression("9 / 3.0"), 0.001);
    }

    @Test
    public void testInvalidExpressions() {
        assertThrows(IllegalArgumentException.class, () -> Parser.evaluateExpression("3 + + 5"));
        assertThrows(IllegalArgumentException.class, () -> Parser.evaluateExpression("3 + (5 * 2"));
        assertThrows(ArithmeticException.class, () -> Parser.evaluateExpression("3 / 0"));
    }
}

