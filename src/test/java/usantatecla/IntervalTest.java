package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {

    private Point left = new Point(-2.2);
    private Point right = new Point(4.4);
    private IntervalBuilder intervalBuilder;
    
    private OpenedMin minOpenedLeft;
    private OpenedMin minOpenedCenter;
    private OpenedMin minOpenedRight;

    private ClosedMin minClosedLeft;
    private ClosedMin minClosedCenter;
    private ClosedMin minClosedRight;

    private OpenedMax maxOpenedLeft;
    private OpenedMax maxOpenedCenter;
    private OpenedMax maxOpenedRight;

    private ClosedMax maxClosedLeft;
    private ClosedMax maxClosedCenter;
    private ClosedMax maxClosedRight;

    @BeforeEach
    public void before() {
        this.left = new Point(-2.2);
        this.right = new Point(4.4);

        this.minOpenedLeft = new OpenedMin(left.getLess());
        this.minOpenedCenter = new OpenedMin(left.getEquals());
        this.minOpenedRight = new OpenedMin(left.getGreater());

        this.minClosedLeft = new ClosedMin(left.getLess());
        this.minClosedCenter = new ClosedMin(left.getEquals());
        this.minClosedRight = new ClosedMin(left.getGreater());

        this.maxOpenedLeft = new OpenedMax(this.right.getLess());
        this.maxOpenedCenter = new OpenedMax(this.right.getEquals());
        this.maxOpenedRight = new OpenedMax(this.right.getGreater());
        
        this.maxClosedLeft = new ClosedMax(this.right.getLess());
        this.maxClosedCenter = new ClosedMax(this.right.getEquals());
        this.maxClosedRight = new ClosedMax(this.right.getGreater());

        this.intervalBuilder = new IntervalBuilder();
    }

    @Test
    public void givenIntervalOpenOpenlwhenCheckingPointsThenAllAssertionsPass () {
        Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();

        assertFalse(interval.include(this.minOpenedLeft));
        assertFalse(interval.include(this.minOpenedCenter));
        assertTrue(interval.include(this.minOpenedRight));
        assertTrue(interval.include(this.maxOpenedLeft));
        assertFalse(interval.include(this.maxOpenedCenter));
        assertFalse(interval.include(this.maxOpenedRight));
    }

    @Test
    public void givenIntervalCloseOpenlwhenCheckingPointsThenAllAssertionsPass () {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();

        assertFalse(interval.include(this.minClosedLeft));
        assertTrue(interval.include(this.minClosedCenter));
        assertTrue(interval.include(this.minClosedRight));
        assertTrue(interval.include(this.maxOpenedLeft));
        assertFalse(interval.include(this.maxOpenedCenter));
        assertFalse(interval.include(this.maxOpenedRight));
    }

    @Test
    public void givenIntervalOpenCloselwhenCheckingPointsThenAllAssertionsPass () {
        Interval interval = this.intervalBuilder.open(left.getEquals()).closed(right.getEquals()).build();

        assertFalse(interval.include(this.minOpenedLeft));
        assertFalse(interval.include(this.minOpenedCenter));
        assertTrue(interval.include(this.minOpenedRight));
        assertTrue(interval.include(this.maxClosedLeft));
        assertTrue(interval.include(this.maxClosedCenter));
        assertFalse(interval.include(this.maxClosedRight));
    }

    @Test
    public void givenIntervalCloseCloselwhenCheckingPointsThenAllAssertionsPass () {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();

        assertFalse(interval.include(this.minClosedLeft));
        assertTrue(interval.include(this.minClosedCenter));
        assertTrue(interval.include(this.minClosedRight));
        assertTrue(interval.include(this.maxClosedLeft));
        assertTrue(interval.include(this.maxClosedCenter));
        assertFalse(interval.include(this.maxClosedRight));
    }

}