/***
 * Parking System: Manage parking slots and vehicle registrations. Authenticate guards, create users, select vehicle types, and generate parking receipts. Simple interface for efficient parking management.
 * owner: Mayank Aitan
 * Date: 21-10-2024
 */
import java.util.Scanner;

public class Main {
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

    @SuppressWarnings("resource")
    public static boolean guardLogin() {
        System.out.println("Default guard name : gaurd1, password : password1");
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

    @SuppressWarnings("static-access")
    public Main(String name, String contact, String userType) {
        this.name = name;
        this.contact = contact;
        this.userType = userType;
    }

    @SuppressWarnings("static-access")
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
                case "1":
                case "user":
                    if (slot.isAvailableSlots()) {
                        create_user();
                    }
                    break;
                case "2":
                case "slot":
                    slot.viewBookedSlots();
                    break;
                case "3":
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

    @SuppressWarnings({ "static-access", "unused" })
    public static void create_user() {
        Slot slot = new Slot();
        Scanner scanner = new Scanner(System.in);
        boolean isValidName = false;
    while (!isValidName) {
        System.out.println(Parking_Constant.ENTER_NAME);
        name = scanner.nextLine();
        if (isValidAlphabetic(name)) {
            isValidName = true;
        } else {
            System.out.println(Parking_Constant.INVALID_NAME); 
        }
    }

    boolean isValidContact = false;
    while (!isValidContact) {
        System.out.println(Parking_Constant.ENTER_CONTACT);
        contact = scanner.nextLine();
        if (isValidContactNumber(contact)) {
            isValidContact = true;
        } else {
            System.out.println(Parking_Constant.INVALID_CONTACT);
        }
    }

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

        Main user = new Main(name, contact, userType);
        vehicle.getVehicleType();
        Pass pass = null;
        System.out.println(Parking_Constant.ENTER_VALIDITY);
        while (flag) {
            validity = scanner.nextLine();
            switch (validity) {
                case "daily":
                    pass = new Daily(vehicle);
                    flag = false;
                    break;
                case "monthly":
                    pass = new Monthly(vehicle);
                    flag = false;
                    break;
                case "Yearly":
                    pass = new Yearly(vehicle);
                    flag = false;
                    break;
                case "Weekly":
                    pass = new Weekly(vehicle);
                    flag = false;
                    break;
                default:
                    System.out.println("Invaild Input");
                    break;
            }
        }

        if(pass != null){
            pass.printPassDetails();
        }
        // printReceipt(name, contact, userType, vehicle.id(name, contact), parking_system.getVehicleType(), expiry, price);
        String id = vehicle.id(name, contact);
        slot.bookSlot(id);
    }

public static boolean isValidAlphabetic(String input) {
    if (input == null || input.equals("")) {
        return false;
    }
    
    int i = 0;
    while (i < input.length()) {
        char ch = input.charAt(i);
        if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))) {
            return false;
        }
        i++;
    }
    return true;
}

public static boolean isValidContactNumber(String contact) {
    int i = 0;
    int digitCount = 0;
    
    while (i < contact.length()) {
        char ch = contact.charAt(i);
        if (ch >= '0' && ch <= '9') { 
            digitCount++;
        } else {
            return false; 
        }
        i++;
    }
    
    return digitCount == 10; 
}
}

