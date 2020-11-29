package usantatecla;

public class Min extends Limit {

    private LimitService limitService;

    public Min(double value) {
        super(value);
        this.limitService = new LimitService();
    }

    @Override
    public boolean isWithin(double value) {
        return this.limitService.minIsWithin(this.value, value);
    }

    @Override
    public String toString() {
        return "(" + this.value;
    }
}
