public class InvoiceSummary {
    public double avgCost;
    public int numOfRides;
    public double totalFare;

    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.avgCost = this.totalFare/this.numOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return Double.compare(that.avgCost, avgCost) == 0 &&
                numOfRides == that.numOfRides &&
                Double.compare(that.totalFare, totalFare) == 0;
    }
}
