/**
 * The Pass class represents a parking pass associated with a vehicle.
 * It provides a method to retrieve the expiry date of the pass.
 * Owner: Arjun Gautam
 */

abstract class Pass {
    public Vehicle vehicle;
    public String expiry;

    Pass(Vehicle vehicle) {
        // Initializes the pass with an associated vehicle.
        this.vehicle = vehicle;
    }

    public String getExpiry() {
        // Returns the expiry date of the pass.
        return expiry;
    }
}
