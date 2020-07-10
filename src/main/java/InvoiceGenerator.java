public class InvoiceGenerator {


    private static final double COST_PER_MINUTE = 1.0 ;
    private static final double MINIMUM_FARE = 5.0;
    public final double COST_PER_KM =10.0;

    public double calculateFare(double distance, double time) {
        double totalFare = (distance*COST_PER_KM)+(time*COST_PER_MINUTE);
        if (totalFare<MINIMUM_FARE)
            return MINIMUM_FARE;
    return totalFare;
    }

    public double calculateFare(Ride[] rides) {
        double totalFare=0.0;
        for (Ride ride:rides){
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
