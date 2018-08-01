package za.co.rssa;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class SimpleHamcrestAssertsTest {

    // Check out this link for all the Hamcrest matchers: http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/CoreMatchers.html

    private SimpleHamcrestAsserts simpleHamcrestAsserts;

    @Before
    public void setUp() {
        simpleHamcrestAsserts = new SimpleHamcrestAsserts();
        simpleHamcrestAsserts.setName("Rida Abrahams");
    }

    @Test
    public void valueIsOneHundred() {
        assertThat(simpleHamcrestAsserts.getValue(), is(equalTo(100)));
    }

    @Test
    public void nameStartsWithRida() {
        assertThat(simpleHamcrestAsserts.getName(), startsWith("Rida"));
    }

    @Test
    public void nameDoesNotStartWithSam() {
        assertThat(simpleHamcrestAsserts.getName(), not(startsWith("Sam")));
    }

    @Test
    public void nameIsNotNull() {
        assertThat(simpleHamcrestAsserts.getName(), not(nullValue()));
    }
}