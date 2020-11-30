package usantatecla;

public class IntervalBuilder {

    private Limit min;
    private Limit max;
    private boolean minConfigured;
    private boolean maxConfigured;

    IntervalBuilder() {
        this.minConfigured = false;
        this.maxConfigured = false;
    }

    public IntervalBuilder open(double value) {
        assert !this.minConfigured || !this.maxConfigured;
        configureLimits(value, new Min(value), new Max(value));
        return this;
    }

    public IntervalBuilder closed(double value) {
        assert !this.minConfigured || !this.maxConfigured;
        configureLimits(value, new ClosedMin(value), new ClosedMax(value));
        return this;
    }

    private void configureLimits(double value, Limit min, Limit max) {
        if (!this.minConfigured) {
            this.configureMin(value, min);
        } else if (!this.maxConfigured) {
            this.configureMax(value, max);
        }
    }

    private void configureMin(double value, Limit min) {
        this.min = min;
        this.minConfigured = true;
    }

    private void configureMax(double value, Limit max) {
        this.max = max;
        this.maxConfigured = true;
    }

    public Interval build() {
        assert this.minConfigured && this.maxConfigured;
        return new Interval(this.min, this.max);
    }
}