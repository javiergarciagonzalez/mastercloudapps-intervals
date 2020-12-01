package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {

    private Point left;
    private Point right;
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
        this.left = new Point(1);
        this.right = new Point(3);
        this.intervalBuilder = new IntervalBuilder();

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

    @Test
    public void givenIntervalOpenOpenWhenCheckingIntersectionThenAllAssertionsPass () {
        Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();

        Interval biggerInterval = new IntervalBuilder().open(left.getLess()).open(right.getGreater()).build();
        Interval onTheLeftOutterInterval = new IntervalBuilder().open(left.getLess() - 1).open(left.getLess()).build();
        Interval onTheRightOutterInterval = new IntervalBuilder().open(right.getGreater()).open(right.getGreater() + 1).build();
        Interval onTheLeftInnerInterval = new IntervalBuilder().open(left.getLess()).open(left.getGreater()).build();
        Interval onTheRightInnerInterval = new IntervalBuilder().open(right.getLess()).open(right.getGreater()).build();
        Interval onTheCenterInterval = new IntervalBuilder().open(left.getGreater()).open(right.getLess()).build();
        Interval onMinLimitInterval = new IntervalBuilder().open(left.getLess()).open(left.getEquals()).build();
        Interval onMaxLimitInterval = new IntervalBuilder().open(right.getEquals()).open(right.getGreater()).build();

        assertTrue(interval.isIntersect(biggerInterval));
        assertFalse(interval.isIntersect(onTheLeftOutterInterval));
        assertFalse(interval.isIntersect(onTheRightOutterInterval));
        assertTrue(interval.isIntersect(onTheLeftInnerInterval));
        assertTrue(interval.isIntersect(onTheRightInnerInterval));
        assertTrue(interval.isIntersect(onTheCenterInterval));
        assertFalse(interval.isIntersect(onMinLimitInterval));
        assertFalse(interval.isIntersect(onMaxLimitInterval));
        assertTrue(interval.isIntersect(interval));
    }

    @Test
    public void givenIntervalCloseOpenWhenCheckingIntersectionThenAllAssertionsPass () {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();

        Interval biggerInterval = new IntervalBuilder().closed(left.getLess()).open(right.getGreater()).build();
        Interval onTheLeftOutterInterval = new IntervalBuilder().closed(left.getLess() - 1).open(left.getLess()).build();
        Interval onTheRightOutterInterval = new IntervalBuilder().closed(right.getGreater()).open(right.getGreater() + 1).build();
        Interval onTheLeftInnerInterval = new IntervalBuilder().closed(left.getLess()).open(left.getGreater()).build();
        Interval onTheRightInnerInterval = new IntervalBuilder().closed(right.getLess()).open(right.getGreater()).build();
        Interval onTheCenterInterval = new IntervalBuilder().closed(left.getGreater()).open(right.getLess()).build();
        Interval onMinLimitInterval = new IntervalBuilder().closed(left.getLess()).open(left.getEquals()).build();
        Interval onMaxLimitInterval = new IntervalBuilder().closed(right.getEquals()).open(right.getGreater()).build();

        assertTrue(interval.isIntersect(biggerInterval));
        assertFalse(interval.isIntersect(onTheLeftOutterInterval));
        assertFalse(interval.isIntersect(onTheRightOutterInterval));
        assertTrue(interval.isIntersect(onTheLeftInnerInterval));
        assertTrue(interval.isIntersect(onTheRightInnerInterval));
        assertTrue(interval.isIntersect(onTheCenterInterval));
        assertFalse(interval.isIntersect(onMinLimitInterval));
        assertFalse(interval.isIntersect(onMaxLimitInterval));
        assertTrue(interval.isIntersect(interval));
    }

    @Test
    public void givenIntervalOpenCloseWhenCheckingIntersectionThenAllAssertionsPass () {
        Interval interval = this.intervalBuilder.open(left.getEquals()).closed(right.getEquals()).build();

        Interval biggerInterval = new IntervalBuilder().open(left.getLess()).closed(right.getGreater()).build();
        Interval onTheLeftOutterInterval = new IntervalBuilder().open(left.getLess() - 1).closed(left.getLess()).build();
        Interval onTheRightOutterInterval = new IntervalBuilder().open(right.getGreater()).closed(right.getGreater() + 1).build();
        Interval onTheLeftInnerInterval = new IntervalBuilder().open(left.getLess()).closed(left.getGreater()).build();
        Interval onTheRightInnerInterval = new IntervalBuilder().open(right.getLess()).closed(right.getGreater()).build();
        Interval onTheCenterInterval = new IntervalBuilder().open(left.getGreater()).closed(right.getLess()).build();
        Interval onMinLimitInterval = new IntervalBuilder().open(left.getLess()).closed(left.getEquals()).build();
        Interval onMaxLimitInterval = new IntervalBuilder().open(right.getEquals()).closed(right.getGreater()).build();

        assertTrue(interval.isIntersect(biggerInterval));
        assertFalse(interval.isIntersect(onTheLeftOutterInterval));
        assertFalse(interval.isIntersect(onTheRightOutterInterval));
        assertTrue(interval.isIntersect(onTheLeftInnerInterval));
        assertTrue(interval.isIntersect(onTheRightInnerInterval));
        assertTrue(interval.isIntersect(onTheCenterInterval));
        assertFalse(interval.isIntersect(onMinLimitInterval));
        assertFalse(interval.isIntersect(onMaxLimitInterval));
        assertTrue(interval.isIntersect(interval));
    }

    @Test
    public void givenIntervalCloseCloseWhenCheckingIntersectionThenAllAssertionsPass () {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();

        Interval biggerInterval = new IntervalBuilder().closed(left.getLess()).closed(right.getGreater()).build();
        Interval onTheLeftOutterInterval = new IntervalBuilder().closed(left.getLess() - 1).closed(left.getLess()).build();
        Interval onTheRightOutterInterval = new IntervalBuilder().closed(right.getGreater()).closed(right.getGreater() + 1).build();
        Interval onTheLeftInnerInterval = new IntervalBuilder().closed(left.getLess()).closed(left.getGreater()).build();
        Interval onTheRightInnerInterval = new IntervalBuilder().closed(right.getLess()).closed(right.getGreater()).build();
        Interval onTheCenterInterval = new IntervalBuilder().closed(left.getGreater()).closed(right.getLess()).build();
        Interval onMinLimitInterval = new IntervalBuilder().closed(left.getLess()).closed(left.getEquals()).build();
        Interval onMaxLimitInterval = new IntervalBuilder().closed(right.getEquals()).closed(right.getGreater()).build();

        assertTrue(interval.isIntersect(biggerInterval));
        assertFalse(interval.isIntersect(onTheLeftOutterInterval));
        assertFalse(interval.isIntersect(onTheRightOutterInterval));
        assertTrue(interval.isIntersect(onTheLeftInnerInterval));
        assertTrue(interval.isIntersect(onTheRightInnerInterval));
        assertTrue(interval.isIntersect(onTheCenterInterval));
        assertTrue(interval.isIntersect(onMinLimitInterval));
        assertTrue(interval.isIntersect(onMaxLimitInterval));
        assertTrue(interval.isIntersect(interval));
    }

    @Test
    public void GivenTwoIntervalsThatDontIntersectWhenCheckingTheirIntersectionThenIsFalse() {
        double left = new Point(1).getEquals();
        double center = new Point(2).getEquals();
        double right = new Point(3).getEquals();

        Interval openOpenInterval = new IntervalBuilder().open(left).open(center).build();
        Interval closeCloseInterval = new IntervalBuilder().closed(center).closed(right).build();

        assertFalse(openOpenInterval.isIntersect(closeCloseInterval));
        assertFalse(closeCloseInterval.isIntersect(openOpenInterval));
    }
}