package usantatecla;

public class ClosedMin extends Min {

    public ClosedMin(double value) {
        super(value);
    }

    @Override
    public boolean isWithin(Limit limit) {
        return super.isWithin(limit) || this.value == limit.value;
    }

    @Override
    public String toString() {
        return "[" + this.value;
    }

}