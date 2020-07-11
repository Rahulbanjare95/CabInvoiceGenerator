import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<Ride>> rideMap = null;

    public RideRepository() {
        this.rideMap = new HashMap<>();
    }
    public void addRides(String userId ,  Ride[] rides){
        ArrayList<Ride> rideArrayList = this.rideMap.get(userId);
        if(rideArrayList == null){
            this.rideMap.put(userId, new ArrayList<Ride>(Arrays.asList(rides)));
        }
    }
    public ArrayList<Ride> getRideDetails(String userId){
        return rideMap.get(userId);
    }


}
