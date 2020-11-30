package usantatecla;

public class OpenedMin extends Limit {
    public OpenedMin(double value) {
        super(value);
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