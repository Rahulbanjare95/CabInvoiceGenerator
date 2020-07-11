package services;

import models.InvoiceSummary;
import models.Ride;
import models.RideRepository;
import utility.SubscriptionType;

import java.util.ArrayList;
import java.util.Arrays;

public class InvoiceGenerator {

    private static double COST_PER_MINUTE = 1.0;
    private static double MINIMUM_FARE = 5.0;
    public double COST_PER_KM = 10.0;
    RideRepository rideRepository = null;
    public InvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }

    public double calculateFare(double distance, double time, SubscriptionType type) {
        setValue(type);
        double totalFare = (distance * COST_PER_KM) + (time * COST_PER_MINUTE);
        if (totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }

    private void setValue(SubscriptionType type) {
        this.COST_PER_KM = COST_PER_KM;
        COST_PER_MINUTE = COST_PER_MINUTE;
        MINIMUM_FARE = MINIMUM_FARE;

    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        double totalFare;
        ArrayList userRides = rideRepository.getRideDetails(userId);
        Ride[] rides = new Ride[userRides.size()];
        userRides.toArray(rides);
        totalFare = Arrays.stream(rides).mapToDouble(ride -> this.calculateFare(ride.distance, ride.time, ride.type)).sum();
        return new InvoiceSummary(rides.length, totalFare);
    }
    public void addRide(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }
}
