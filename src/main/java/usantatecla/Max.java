package usantatecla;

public class Max extends Limit {

    private LimitService limitService;

    public Max(double value) {
        super(value);
        this.limitService = new LimitService();
    }

    @Override
    public boolean isWithin(double value) {
        return this.limitService.maxIsWithin(this.value, value);
    }

    @Override
    public String toString() {
        return this.value + ")";
    }
}
