package usantatecla;

public class LimitService {

    public boolean minIsWithin(double limitOrigin, double newLimit) {
        return limitOrigin < newLimit;
    }

    public boolean maxIsWithin(double limitOrigin, double newLimit) {
        return limitOrigin > newLimit;
    }
}