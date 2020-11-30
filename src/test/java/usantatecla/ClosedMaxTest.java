package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClosedMaxTest {

    protected ClosedMax max;
    protected Point point;

    @BeforeEach
    public void before() {
        this.point = new Point(4.4);
        this.max = this.createMax();
    }


    protected ClosedMax createMax() {
        return new ClosedMax(this.point.getEquals());
    }

    @Test
    public void givenMaxWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.max.isWithin(new ClosedMax(this.point.getLess())));
    }

    @Test
    public void givenMaxWhenIsWithinWithGreaterValue() {
        assertTrue(this.max.isWithin(this.createMax()));
    }

    @Test
    public void givenMaxWhenIsWithinWithEqualsValue() {
        assertTrue(this.max.isWithin(new ClosedMax(this.point.getEquals())));
    }

}