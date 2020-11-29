package usantatecla;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LimitServiceTest {
    protected LimitService limitService;
    protected Point point;


    @BeforeEach
    public void before() {
        this.point = new Point(4.4);
        this.limitService = new LimitService();
    }

    protected Max createMax() {
        return new Max(this.point.getGreater());
    }

    protected Min createMin() {
        return new Min(this.point.getLess());
    }

    @Test
    public void givenMaxWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.limitService.maxIsWithin(this.point.getGreater(), this.point.getEquals()));
    }

    @Test
    public void givenMaxWhenIsWithinWithEqualsValue() {
        assertFalse(this.limitService.maxIsWithin(this.point.getEquals(), this.point.getEquals()));
    }

    @Test
    public void givenMaxWhenIsWithinWithGreaterValueThenTrue() {
        assertFalse(this.limitService.maxIsWithin(this.point.getLess(), this.point.getEquals()));
    }

    @Test
    public void givenMinWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.limitService.minIsWithin(this.point.getLess(), this.point.getEquals()));
    }

    @Test
    public void givenMinWhenIsWithinWithEqualsValue() {
        assertFalse(this.limitService.minIsWithin(this.point.getEquals(), this.point.getEquals()));
    }

    @Test
    public void givenMinWhenIsWithinWithGreaterValueThenTrue() {
        assertFalse(this.limitService.minIsWithin(this.point.getGreater(), this.point.getEquals()));
    }
}
