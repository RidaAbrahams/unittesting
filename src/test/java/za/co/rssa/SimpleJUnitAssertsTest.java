package za.co.rssa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleJUnitAssertsTest {

    private SimpleJUnitAsserts simpleJUnitAsserts;

    @Before
    public void init() {
        simpleJUnitAsserts = new SimpleJUnitAsserts();
    }
    @Test
    public void add() {
        int result = simpleJUnitAsserts.add(2, 3);
        Assert.assertEquals(5, result);
    }

    @Test
    public void matches() {
        boolean result = simpleJUnitAsserts.matches("Rida", "RIDA");
        Assert.assertTrue(result);
    }

    @Test
    public void doesNotMatches() {
        boolean result = simpleJUnitAsserts.matches("Rida", "FRIDAY");
        Assert.assertFalse(result);
    }
}