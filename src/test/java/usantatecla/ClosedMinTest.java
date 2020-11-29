package usantatecla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClosedMinTest extends MinTest {

    @Override
    protected Min createMin() {
        return new ClosedMin(this.point.getEquals());
    }


    @Test
    @Override
    public void givenMinWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.min.isWithin(this.createMin()));
    }

    @Test
    @Override
    public void givenMinWhenIsWithinWithEqualsValue() {
        assertTrue(this.min.isWithin(new ClosedMin(this.point.getEquals())));
    }

    @Test
    @Override
    public void givenMinWhenIsWithinWithGreaterValueThenTrue() {
        assertTrue(this.min.isWithin(new ClosedMin(this.point.getGreater())));
    }

}