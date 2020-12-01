package usantatecla;

public class ClosedMax extends Limit {

    public ClosedMax(double value) {
        super(value);
    }

    @Override
    public boolean isWithin(Limit limit) {
        return this.limitService.isWithin(this, limit);
    }

    @Override
    public String toString() {
        return this.getValue() + "]";
    }

}