package za.co.rssa.lambdas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlyWithWingsTest {

    private FlyBehaviour flyBehaviour;

    @Before
    public void setUp() {
        flyBehaviour = new FlyWithWings();
    }

    @Test
    public void shouldFlyWithWings() {
        flyBehaviour.fly();
        flyBehaviour.glide();
        assertTrue(true);
    }

}