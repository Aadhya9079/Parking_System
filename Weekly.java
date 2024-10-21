/**
 * The Weekly class represents a weekly parking pass for a vehicle, expiring after 7 days.
 * It calculates the price based on the type of vehicle (cycle, bike, or car).
 * Owner : Arjun Gautam.
 */

class Weekly extends Pass {

    Weekly(Vehicle vehicle) {
        super(vehicle, 7); // Weekly pass expires after 7 days
    }

    @Override
    public int price() {
        switch (vehicle.type) {
            case "cycle":
                return 50;
            case "bike":
                return 100;
            case "car":
                return 300;
            default:
                return 0;
        }
    }
}

