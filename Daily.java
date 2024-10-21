/**
 * The Daily class represents a daily parking pass for a vehicle, expiring after one day.
 * It calculates the price based on the type of vehicle (cycle, bike, or car).
 * Owner : Arjun Gautam.
 */

class Daily extends Pass {

    Daily(Vehicle vehicle) {
        super(vehicle, 1); // Daily pass expires after 1 day
    }

    @Override
    public int price() {
        switch (vehicle.type) {
            case "cycle":
                return 10;
            case "bike":
                return 20;
            case "car":
                return 50;
            default:
                return 0;
        }
    }
}