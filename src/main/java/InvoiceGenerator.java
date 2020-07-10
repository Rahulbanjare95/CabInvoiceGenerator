public class InvoiceGenerator {


    public final double COST_PER_KM =10.0;

    public double calculateFare(double distance, int time) {
        double totalFare = distance*COST_PER_KM+time;
    return totalFare;

    }
}
