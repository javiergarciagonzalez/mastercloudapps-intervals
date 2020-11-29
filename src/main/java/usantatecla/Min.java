package usantatecla;

public class Min extends Limit {

    private LimitService limitService;

    public Min(double value) {
        super(value);
        this.limitService = new LimitService();
    }

    @Override
    public boolean isWithin(Limit limit) {
        return this.limitService.isWithin(this, limit);
    }

    @Override
    public String toString() {
        return "(" + this.value;
    }
}
