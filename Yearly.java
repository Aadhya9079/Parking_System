/**
 * The Yearly class represents an annual parking pass for a vehicle, expiring after 365 days.
 * It calculates the price based on the type of vehicle (cycle, bike, or car).
 * Owner : Arjun Gautam.
 */

class Yearly extends Pass {

    Yearly(Vehicle vehicle) {
        super(vehicle, 365); // Annual pass expires after 365 days
    }

    @Override
    public int price() {
        switch (vehicle.type) {
            case "cycle":
                return 500;
            case "bike":
                return 2000;
            case "car":
                return 5000;
            default:
                return 0;
        }
    }
}