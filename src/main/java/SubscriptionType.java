public enum SubscriptionType {
    NORMAL(1,10,5),
    PREMIUM(2,15,20);


    public  int COST_PER_KM ;
    public   int COST_PER_MINUTE;
    public   int MINIMUM_FARE;

    SubscriptionType(int COST_PER_MINUTE, int COST_PER_KM, int MINIMUM_FARE) {
        this.COST_PER_KM = COST_PER_KM;
        this.COST_PER_MINUTE = COST_PER_MINUTE;
        this.MINIMUM_FARE = MINIMUM_FARE;
    }
}
