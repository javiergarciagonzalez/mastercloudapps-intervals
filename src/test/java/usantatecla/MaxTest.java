package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaxTest {

    protected Max max;
    protected Point point;

    @BeforeEach
    public void before() {
        this.point = new Point(4.4);
        this.max = this.createMax();
    }

    protected Max createMax() {
        return new Max(this.point.getEquals());
    }

    @Test
    public void givenMaxWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.max.isWithin(new Max(this.point.getLess())));
    }

    @Test
    public void givenMaxWhenIsWithinWithEqualsValue() {
        assertFalse(this.max.isWithin(new Max(this.point.getEquals())));
    }

    @Test
    public void givenMaxWhenIsWithinWithGreaterValue() {
        assertFalse(this.max.isWithin(this.createMax()));
    }

}