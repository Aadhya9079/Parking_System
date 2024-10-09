/**
 * This is a subclass extends Vehicle abstract class.
 */
class Bike extends Vehicle {
    @Override
    public void inputVehicleId() {
        System.out.print("Enter your vehicle id for Bike: ");
        vehicleId = scanner.nextLine().toUpperCase();

        if (isAlreadyRegistered(vehicleId)) {
            System.out.println("This vehicle id is already registered.");
        }
        else {
            while (!isValid(vehicleId)) {
                System.out.println("Invalid vehicle id.");
                System.out.print("Enter your vehicle id for Bike: ");
                vehicleId = scanner.nextLine().toUpperCase();
            }
            registerVehicleId(vehicleId);
            System.out.println("Your vehicle id for Bike is: " + vehicleId);
        }
    }
}