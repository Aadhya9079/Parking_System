/**
 * The Pass class represents a parking pass associated with a vehicle.
 * It provides methods to calculate expiry and print pass details.
 * Owner : Arjun Gautam.
 */
 
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Pass {
    public Vehicle vehicle;
	public Main user;
	public Parking_Constant constant = new Parking_Constant();
    public String expiry;
    protected int price;

    Pass(Vehicle vehicle, int daysToAdd) {
        this.vehicle = vehicle;
        this.price = price(); 
        this.expiry = calculateExpiry(daysToAdd); 
    }

    // Abstract method to be implemented by child classes for price calculation
    public abstract int price();

    // Method to calculate expiry by manually entering date and adding days
    public String calculateExpiry(int daysToAdd) {
        Scanner input = new Scanner(System.in);

        // Taking date and time input step by step
        System.out.print(constant.ENTER_DATE);
        int day = getInput(1, 31, input);

        System.out.print(constant.ENETR_MONTH);
        int month = getInput(1, 12, input);

        System.out.print(constant.ENTER_YEAR);
        int year = getInput(2024, 2024, input);

        System.out.print(constant.ENTER_HRS);
        int hour = getInput(0, 23, input);

        System.out.print(constant.ENTER_MIN);
        int minute = getInput(0, 59, input);

        day += daysToAdd;

        while (true) {
            if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31) {
                day -= 31;
                month += 1;
            } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
                day -= 30;
                month += 1;
            } else if (month == 2 && day > 28) { 
                day -= 28;
                month += 1;
            } else {
                break;
            }
            if (month > 12) {
                month = 1;
                year += 1;
            }
        }

        String formattedExpiry = String.format(constant.FORMAT, day, month, year, hour, minute);
        return formattedExpiry;
    }

    // Helper method to get validated input from the user
    private int getInput(int min, int max, Scanner input) {
        int enteredValue = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                enteredValue = input.nextInt();

                if (enteredValue >= min && enteredValue <= max) {
                    isValid = true;
                } else {
                    System.out.println(constant.INVALID_INPUT + min + constant.AND + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println(constant.INVALID_INTEGER);
                input.next(); 
            }
        }

        return enteredValue;
    }

    // Method to print pass details
    public void printPassDetails() {
		System.out.println(constant.NAME + user.name);
		System.out.println(constant.CONTACT + user.contact);
		System.out.println(constant.ROLE + user.Role);
        System.out.println(constant.VEHICLE_TYPE + vehicle.type);
        System.out.println(constant.PASS_TYPE + this.getClass().getSimpleName());
        System.out.println(constant.PRICE + price());
        System.out.println(constant.EXPIRY + expiry);
    }
}
