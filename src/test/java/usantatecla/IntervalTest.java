package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {

    private Point left = new Point(-2.2);
    private Point right = new Point(4.4);
    private Min minOpened;
    private ClosedMin minClosed;
    private Max maxOpened;
    private ClosedMax maxClosed;
    private IntervalBuilder intervalBuilder;

    @BeforeEach
    public void before() {
        this.left = new Point(-2.2);
        this.minOpened = new Min(left.getLess());
        this.minClosed = new ClosedMin(left.getLess());
        this.right = new Point(4.4);
        this.maxOpened = new Max(this.right.getGreater());
        this.maxClosed = new ClosedMax(this.right.getGreater());
        this.intervalBuilder = new IntervalBuilder();
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(this.minOpened));
        assertFalse(interval.include(new Min(left.getEquals())));
        assertTrue(interval.include(new Min(left.getGreater())));
        assertTrue(interval.include(new Max(right.getLess())));
        assertFalse(interval.include(new Max(right.getEquals())));
        assertFalse(interval.include(this.maxOpened));
    }

    @Test
    public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(this.minClosed));
        assertTrue(interval.include(new Min(left.getEquals())));
        assertTrue(interval.include(new Min(left.getGreater())));

        assertTrue(interval.include(new Max(right.getLess())));
        assertFalse(interval.include(new Max(right.getEquals())));
        assertFalse(interval.include(this.maxOpened));
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.open(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(this.minOpened));
        assertFalse(interval.include(new Min(left.getEquals())));
        assertTrue(interval.include(new Min(left.getGreater())));

        assertTrue(interval.include(new Max(right.getLess())));
        assertTrue(interval.include(new Max(right.getEquals())));
        assertFalse(interval.include(this.maxClosed));
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(this.minClosed));
        assertTrue(interval.include(new Min(left.getEquals())));
        assertTrue(interval.include(new Min(left.getGreater())));

        assertTrue(interval.include(new Max(right.getLess())));
        assertTrue(interval.include(new Max(right.getEquals())));
        assertFalse(interval.include(this.maxClosed));
    }

}