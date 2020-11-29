package usantatecla;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LimitServiceTest {

    protected LimitService limitService;
    protected Point point;
    protected Max max;
    protected Min min;


    @BeforeEach
    public void before() {
        this.point = new Point(4.4);
        this.limitService = new LimitService();
        this.max = this.createMax();
        this.min = this.createMin();
    }

    protected Max createMax() {
        return new Max(this.point.getGreater());
    }

    protected Min createMin() {
        return new Min(this.point.getLess());
    }

    @Test
    public void givenMaxWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.limitService.isWithin(this.max, new Max(this.point.getLess())));
    }

    @Test
    public void givenMaxWhenIsWithinWithEqualsValueThenTrue() {
        assertTrue(this.limitService.isWithin(this.max, new Max(this.point.getEquals())));
    }

    @Test
    public void givenMaxWhenIsWithinWithGreaterValueThenFalse() {
        assertFalse(this.limitService.isWithin(this.max, this.createMax()));
    }

    @Test
    public void givenMinWhenIsWithinWithLessValueThenFalse() {
        assertFalse(this.limitService.isWithin(this.min, this.createMin()));
    }
    
    @Test
    public void givenMinWhenIsWithinWithEqualsValueThenTrue() {
        assertTrue(this.limitService.isWithin(this.min, new Min(this.point.getEquals())));
    }
    
    @Test
    public void givenMinWhenIsWithinWithGreaterValueThenTrue() {
        assertTrue(this.limitService.isWithin(this.min, new Min(this.point.getGreater())));
    }
}
