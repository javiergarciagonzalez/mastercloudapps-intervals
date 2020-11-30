package usantatecla;

public class LimitService {

    public boolean isWithin(Min limitOrigin, Limit newLimit) {
        return limitOrigin.value < newLimit.value;
    }

    public boolean isWithin(Max limitOrigin, Limit newLimit) {
        return limitOrigin.value > newLimit.value;
    }
    
    public boolean isWithin(ClosedMin limitOrigin, Limit newLimit) {
        return limitOrigin.value < newLimit.value || limitOrigin.value == newLimit.value;
    }

    public boolean isWithin(ClosedMax limitOrigin, Limit newLimit) {
        return limitOrigin.value > newLimit.value || limitOrigin.value == newLimit.value;
    }
}