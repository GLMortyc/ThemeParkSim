import java.util.ArrayList;

public class Tracker {

    private ArrayList<Ride> rides;

    public Tracker() {
        rides = new ArrayList<>();
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public Ride getRide(int index) {
        if (index > rides.size()) {
            return null;
        }

        return rides.get(index);
    }

    public void removeClosedRides() {
        ArrayList<Ride> temp = new ArrayList<>();

        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).getStatus().equals("open")) {
                temp.add(rides.get(i));
            }
        }
        rides = temp;
    }

    public void printRide(String name) {
        for (Ride ride : rides) {
            if (ride.getName().equals(name)) {
                System.out.println(ride);
            }
        }
    }

    public void removeRide(int index) {
        if (index >= 0 && index <= rides.size()) {
            rides.remove(index);
        }
    }

    public void printAllRides() {
        for (int i = 0; i < rides.size(); i++) {
            System.out.println(rides.get(i));
        }
    }

    public void sortByWaitTime() {
        for (int i = 0; i < rides.size()-1; i++) {
            for (int j = 0; j < rides.size()-i-1; j++) {
                if (rides.get(j).getWaitTime() > rides.get(j+1).getWaitTime()) {
                    Ride temp = rides.get(j);
                    rides.set(j,rides.get(j+1));
                    rides.set(j+1,temp);
                }
            }
        }
    }

    public String findRideStatus(String rideName) {

        for (int x = 0; x< rides.size(); x++) {
            if (rideName.equals(rides.get(x).getName()))
                return rides.get(x).getStatus();
        }

        return "No rides in tracker";
    }
}
