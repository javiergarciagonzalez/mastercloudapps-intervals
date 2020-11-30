package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OpenedMaxTest {

    protected OpenedMax openedMax;
    protected Point point;

    @BeforeEach
    public void before() {
        this.point = new Point(4.4);
        this.openedMax = this.createMax();
    }

    protected Max createMax() {
        return new OpenedMax(this.point.getEquals());
    }

    @Test
    public void givenMaxWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.openedMax.isWithin(new Max(this.point.getLess())));
    }

    @Test
    public void givenMaxWhenIsWithinWithEqualsValue() {
        assertFalse(this.openedMax.isWithin(new Max(this.point.getEquals())));
    }

    @Test
    public void givenMaxWhenIsWithinWithGreaterValue() {
        assertFalse(this.openedMax.isWithin(this.createMax()));
    }

}