/**
 * The Weekly class calculates the price and expiry of a weekly parking pass for a vehicle. 
 * It extends the Daily class to use similar methods and functionality. 
 * Owner: Arjun Gautam
 */
class Weekly extends Daily {
    Weekly(Vehicle vehicle) {
        super(vehicle);
        // Sets the expiry date for a weekly pass.
        this.expiry = calculateExpiry(7);
    }
}
