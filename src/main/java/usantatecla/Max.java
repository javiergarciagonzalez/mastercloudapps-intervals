package usantatecla;

public class Max extends Limit {

    private LimitService limitService;

    public Max(double value) {
        super(value);
        this.limitService = new LimitService();
    }

    @Override
    public boolean isWithin(Limit limit) {
        return this.limitService.isWithin(this, limit);
    }

    @Override
    public String toString() {
        return this.value + ")";
    }
}
