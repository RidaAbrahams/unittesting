package za.co.rssa;

import org.junit.Before;
import org.junit.Test;

public class ExceptionAssertsTest {

    private ExceptionAsserts exceptionAsserts;

    @Before
    public void setUp() {
        exceptionAsserts = new ExceptionAsserts();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowException() {
        exceptionAsserts.performSuspiciousOperation();
    }

}