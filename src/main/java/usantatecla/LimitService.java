package usantatecla;

public class LimitService {

    public boolean isWithin(OpenedMin limitOrigin, Limit newLimit) {
        return limitOrigin.getValue() < newLimit.getValue();
    }

    public boolean isWithin(OpenedMax limitOrigin, Limit newLimit) {
        return limitOrigin.getValue() > newLimit.getValue();
    }
    
    public boolean isWithin(ClosedMin limitOrigin, Limit newLimit) {
        return limitOrigin.getValue() <= newLimit.getValue();
    }

    public boolean isWithin(ClosedMax limitOrigin, Limit newLimit) {
        return limitOrigin.getValue() >= newLimit.getValue();
    }
}