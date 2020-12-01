package usantatecla;

public class ClosedMin extends Limit {

    public ClosedMin(double value) {
        super(value);
    }

    @Override
    public boolean isWithin(Limit limit) {
        return this.limitService.isWithin(this, limit);
    }

    @Override
    public String toString() {
        return "[" + this.getValue();
    }

}