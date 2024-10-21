import java.util.Scanner;
public class Parking_System {

    public static String type;
    public static Scanner scanner = new Scanner(System.in);

    // Method to get the vehicle type
    public static String selectVehicleType() {
        System.out.println("Enter the vehicle type (Car/Bike/Cycle): ");
        type = scanner.nextLine().toLowerCase();  // Convert to lowercase for consistency

        switch (type) {
            case "car":
            case "bike":
            case "cycle":
                return type; 
            default:
                System.out.println("Invalid vehicle type selected. Please try again.");
                return null; 
        }
    }

    // Getter for the vehicle type
    public static String getVehicleType() {
        selectVehicleType();
        return type;
    }
}
