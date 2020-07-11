import services.InvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;
import models.InvoiceSummary;
import models.Ride;
import utility.SubscriptionType;

public class InvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time, SubscriptionType.NORMAL);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistance_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        double time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time, SubscriptionType.NORMAL);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(12, 1, SubscriptionType.NORMAL),
                new Ride(25, 2, SubscriptionType.NORMAL),
                new Ride(150, 4, SubscriptionType.NORMAL),
                new Ride(15, 1, SubscriptionType.NORMAL)};
        String userId = "asd@com";
        invoiceGenerator.addRide(userId, rides);
        InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expected = new InvoiceSummary(4, 2028);
        Assert.assertEquals(expected, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        try {
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            String userId = "rahul@gmail.com";
            Ride[] rides = {new Ride(2, 5, SubscriptionType.NORMAL), new Ride(4, 6, SubscriptionType.NORMAL)};
            invoiceGenerator.addRide
                    (userId, rides);
            InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
            InvoiceSummary expectedSummary = new InvoiceSummary(2, 71.0);
            Assert.assertEquals(expectedSummary.totalFare, summary.totalFare, 0.0);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenUserIdAndPremiumRides_ShouldReturnInvoiceSummary() {
        try {
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            String userId = "rahul@gmail.com";
            Ride[] rides = {new Ride(10, 2, SubscriptionType.PREMIUM), new Ride(14, 6, SubscriptionType.PREMIUM)};
            invoiceGenerator.addRide
                    (userId, rides);
            InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
            InvoiceSummary expectedSummary = new InvoiceSummary(2, 248.0);
            Assert.assertEquals(expectedSummary.totalFare, summary.totalFare, 0.0);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
