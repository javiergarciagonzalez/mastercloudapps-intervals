package usantatecla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

public class ClosedMinTest {

    protected ClosedMin min;
    protected Point point;

    @BeforeEach
    public void before() {
        this.point = new Point(4.4);
        this.min = this.createMin();
    }

    protected ClosedMin createMin() {
        return new ClosedMin(this.point.getEquals());
    }


    @Test
    public void givenMinWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.min.isWithin(this.createMin()));
    }

    @Test
    public void givenMinWhenIsWithinWithEqualsValue() {
        assertTrue(this.min.isWithin(new ClosedMin(this.point.getEquals())));
    }

    @Test
    public void givenMinWhenIsWithinWithGreaterValueThenTrue() {
        assertTrue(this.min.isWithin(new ClosedMin(this.point.getGreater())));
    }

}