package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ClosedMaxTest extends MaxTest {

    @Override
    protected ClosedMax createMax() {
        return new ClosedMax(this.point.getEquals());
    }

    @Test
    @Override
    public void givenMaxWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.max.isWithin(new ClosedMax(this.point.getLess())));
    }

    @Test
    @Override
    public void givenMaxWhenIsWithinWithGreaterValue() {
        assertTrue(this.max.isWithin(this.createMax()));
    }

    @Test
    @Override
    public void givenMaxWhenIsWithinWithEqualsValue() {
        assertTrue(this.max.isWithin(new ClosedMax(this.point.getEquals())));
    }

}