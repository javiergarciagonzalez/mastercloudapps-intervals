package usantatecla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinTest {

    protected Limit min;
    protected Point point;

    @BeforeEach
    public void before() {
        this.point = new Point(4.4);
        this.min = this.createMin();
    }

    protected Limit createMin() {
        return new Min(this.point.getEquals());
    }

    @Test
    public void givenMinWhenIsWithinWithLessValueThenTrue() {
        assertFalse(this.min.isWithin(this.createMin()));
    }

    @Test
    public void givenMinWhenIsWithinWithEqualsValue() {
        assertFalse(this.min.isWithin(new Min(this.point.getEquals())));
    }

    @Test
    public void givenMinWhenIsWithinWithGreaterValueThenTrue() {
        assertTrue(this.min.isWithin(new Min(this.point.getGreater())));
    }

}