package usantatecla;

abstract public class Limit {

    abstract public boolean isWithin(double value);
    
    @Override
    public int hashCode() {
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
