/**
 * The Monthly class represents a monthly parking pass for a vehicle, expiring after 30 days.
 * It calculates the price based on the type of vehicle (cycle, bike, or car).
 * Owner : Arjun Gautam.
 */

class Monthly extends Pass {

    Monthly(Vehicle vehicle) {
        super(vehicle, 30); // Monthly pass expires after 30 days
    }

    @Override
    public int price() {
        switch (vehicle.type) {
            case "cycle":
                return 200;
            case "bike":
                return 500;
            case "car":
                return 1000;
            default:
                return 0;
        }
    }
}