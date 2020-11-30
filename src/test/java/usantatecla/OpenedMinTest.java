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
        this.openedMin = this.createMin();
    }

    protected OpenedMin createMin() {
        return new OpenedMin(this.point.getEquals());
    }

    @Test
    public void givenMinWhenIsWithinWithLessValueThenTrue() {
        assertFalse(this.openedMin.isWithin(this.createMin()));
    }

    @Test
    public void givenMinWhenIsWithinWithEqualsValue() {
        assertFalse(this.openedMin.isWithin(new OpenedMin(this.point.getEquals())));
    }

    @Test
    public void givenMinWhenIsWithinWithGreaterValueThenTrue() {
        assertTrue(this.openedMin.isWithin(new OpenedMin(this.point.getGreater())));
    }
}