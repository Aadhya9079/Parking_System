/***
 * Parking System: Manage parking slots and vehicle registrations. Authenticate guards, create users, select vehicle types, and generate parking receipts. Simple interface for efficient parking management.
 * owner: Mayank Aitan
 * Date: 10-10-2024
 */
import java.util.Scanner;

public class User {
    public static String name;
    public static String contact;
    public static String userType;
    public static String validity;
    public static int price;
    public static String expiry;
    public static boolean flag = true;
    Scanner scanner = new Scanner(System.in);
    public static Vehicle vehicle;
    // public static Slot slot;
    // public static Daily daily;
    // public static Monthly monthly ;
    // public static Weekly weekly;
    // public static Annually annually;
    public static Parking_System parking_system = new Parking_System();

    public static boolean guardLogin() {
        String[] guardNames = { "guard1", "guard2", "guard3" };
        String[] passwords = { "password1", "password2", "password3" };

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(Parking_Constant.GUARD_LOGIN_PROMPT);
            String inputName = scanner.nextLine();
            System.out.print(Parking_Constant.PASSWORD_PROMPT);
            String inputPassword = scanner.nextLine();

            for (int i = 0; i < guardNames.length; i++) {
                if (guardNames[i].equals(inputName) && passwords[i].equals(inputPassword)) {
                    System.out.println(Parking_Constant.LOGIN_SUCCESS + inputName + "!");
                    return true;
                }
            }
            System.out.println(Parking_Constant.LOGIN_FAILED);
        }
    }

    public User(String name, String contact, String userType) {
        this.name = name;
        this.contact = contact;
        this.userType = userType;
    }

    public static void main(String[] args) {
        Slot slot = new Slot();
        Scanner scanner = new Scanner(System.in);
        if (guardLogin()) {
            System.out.println(Parking_Constant.NEXT_TASK_PROMPT);
        } else {
            System.out.println(Parking_Constant.ACCESS_DENIED);
            return;
        }
        while (true) {
            System.out.println(Parking_Constant.CREATE_OR_VIEW_PROMPT);
            String input = scanner.nextLine();
            switch (input) {
                case "user":
                    if (slot.isAvailableSlots()) {
                        create_user();
                    }
                    break;
                case "slot":
                    slot.viewBookedSlots();
                    break;
                case "remove":
                    System.out.println(Parking_Constant.ENTER_SLOT_NUMBER_REMOVE);
                    int slotNumber = scanner.nextInt();
                    slot.removeVehicle(slotNumber);
                    break;
                default:
                    System.out.println(Parking_Constant.INVALID_OPTION);
                    break;
            }
        }
    }

    public static void create_user() {
        Slot slot = new Slot();
        Scanner scanner = new Scanner(System.in);
        System.out.println(Parking_Constant.ENTER_NAME);
        name = scanner.nextLine();
        System.out.println(Parking_Constant.ENTER_CONTACT);
        contact = scanner.nextLine();
        System.out.println(Parking_Constant.ENTER_POST);
        while (true) {
            userType = scanner.nextLine();
            if (userType.equalsIgnoreCase("student") || userType.equalsIgnoreCase("faculty")
                    || userType.equalsIgnoreCase("other")) {
                break;
            } else {
                System.out.println(Parking_Constant.INVALID_INPUT_POST);
            }
        }

        User user = new User(name, contact, userType);
        System.out.println(Parking_Constant.ENTER_VALIDITY);
        while (flag) {
            validity = scanner.nextLine();
            switch (validity) {
                case "daily":
                    Daily daily = new Daily(vehicle);
                    expiry = daily.getExpiry();
                    price = daily.getPrice();
                    flag = false;
                    break;
                case "monthly":
                    Monthly monthly = new Monthly(vehicle);
                    expiry = monthly.getExpiry();
                    price = monthly.getPrice();
                    flag = false;
                    break;
                case "Annually":
                    Annually annually = new Annually(vehicle);
                    expiry = annually.getExpiry();
                    price = annually.getPrice();
                    flag = false;
                    break;
                case "Weekly":
                    Weekly weekly = new Weekly(vehicle);
                    expiry = weekly.getExpiry();
                    price = weekly.getPrice();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        printReceipt(name, contact, userType, vehicle.id(name, contact), parking_system.getVehicleType(), expiry, price);
        String id = vehicle.id(name, contact);
        slot.bookSlot(id);
    }

    public static void printReceipt(String name, String contact, String userType, String id, String vehicleType,
            String expiry, int price) {
        Parking_Constant.receipt(name, contact, userType, id, vehicleType, expiry, price);
        ;
    }
}

