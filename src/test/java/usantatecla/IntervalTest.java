package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {

    private Point left = new Point(-2.2);
    private Point right = new Point(4.4);
    private OpenedMin minOpened;
    private ClosedMin minClosed;
    private OpenedMax maxOpened;
    private ClosedMax maxClosed;
    private IntervalBuilder intervalBuilder;

    @BeforeEach
    public void before() {
        this.left = new Point(-2.2);
        this.minOpened = new OpenedMin(left.getLess());
        this.minClosed = new ClosedMin(left.getLess());
        this.right = new Point(4.4);
        this.maxOpened = new OpenedMax(this.right.getGreater());
        this.maxClosed = new ClosedMax(this.right.getGreater());
        this.intervalBuilder = new IntervalBuilder();
    }

    @Test
    public void givenIntervalOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(this.minOpened));
        assertFalse(interval.include(new OpenedMin(left.getEquals())));
        assertTrue(interval.include(new OpenedMin(left.getGreater())));
        assertTrue(interval.include(new OpenedMax(right.getLess())));
        assertFalse(interval.include(new OpenedMax(right.getEquals())));
        assertFalse(interval.include(this.maxOpened));
    }

    @Test
    public void givenIntervalOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(this.minClosed));
        assertTrue(interval.include(new OpenedMin(left.getEquals())));
        assertTrue(interval.include(new OpenedMin(left.getGreater())));

        assertTrue(interval.include(new OpenedMax(right.getLess())));
        assertFalse(interval.include(new OpenedMax(right.getEquals())));
        assertFalse(interval.include(this.maxOpened));
    }

    @Test
    public void givenIntervalOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.open(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(this.minOpened));
        assertFalse(interval.include(new OpenedMin(left.getEquals())));
        assertTrue(interval.include(new OpenedMin(left.getGreater())));

        assertTrue(interval.include(new OpenedMax(right.getLess())));
        assertTrue(interval.include(new OpenedMax(right.getEquals())));
        assertFalse(interval.include(this.maxClosed));
    }

    @Test
    public void givenIntervalOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(this.minClosed));
        assertTrue(interval.include(new OpenedMin(left.getEquals())));
        assertTrue(interval.include(new OpenedMin(left.getGreater())));

        assertTrue(interval.include(new OpenedMax(right.getLess())));
        assertTrue(interval.include(new OpenedMax(right.getEquals())));
        assertFalse(interval.include(this.maxClosed));
    }

}