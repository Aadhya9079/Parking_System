/**
 * This is a subclass extends Vehicle abstract class.
 */
class Cycle extends Vehicle {
    @Override
    public void inputVehicleId() {
        System.out.println("Cycle does not require a vehicle id.");
    }
}