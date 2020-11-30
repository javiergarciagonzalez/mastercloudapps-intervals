package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OpenedMinTest {

    protected OpenedMin openedMin;
    protected Point point;

    @BeforeEach
    public void before() {
        this.point = new Point(4.4);
        this.openedMin = this.createMax();
    }

    protected Max createMax() {
        return new OpenedMin(this.point.getEquals());
    }

    @Test
    public void givenMaxWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.openedMin.isWithin(new Max(this.point.getLess())));
    }

    @Test
    public void givenMaxWhenIsWithinWithEqualsValue() {
        assertFalse(this.openedMin.isWithin(new Max(this.point.getEquals())));
    }

    @Test
    public void givenMaxWhenIsWithinWithGreaterValue() {
        assertFalse(this.openedMin.isWithin(this.createMax()));
    }

}