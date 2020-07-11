package models;

import utility.SubscriptionType;

public class Ride {
    public double distance;
    public double time;
    public SubscriptionType type;


    public Ride(double distance, double time, SubscriptionType type) {
        this.distance = distance;
        this.time = time;
        this.type = type;
    }

}
