/**
 * The Monthly class calculates the price and expiry of a monthly parking pass for a vehicle.
 * It extends the Daily class to use similar methods and functionality.
 * Owner: Arjun Gautam
 */
class Monthly extends Daily {
    Monthly(Vehicle vehicle) {
        super(vehicle);
        // Sets the expiry date for a monthly pass.
        this.expiry = calculateExpiry(30);
    }
}
