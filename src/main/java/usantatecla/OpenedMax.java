package usantatecla;

public class OpenedMax extends Limit {
    public OpenedMax(double value) {
        super(value);
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