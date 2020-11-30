package usantatecla;

public abstract class Limit {

    protected double value;
    protected LimitService limitService;

    public Limit(double value) {
        this.value = value;
        this.limitService = new LimitService();
    }

    public abstract boolean isWithin(Limit limit);

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = prime * result + (int)(temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Limit other = (Limit) obj;
        if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
            return false;
        return true;
    }

    public abstract String toString();
}
