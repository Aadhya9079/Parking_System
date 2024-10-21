public class Parking_Constant {
    public static final String GUARD_LOGIN_PROMPT = "Enter Guard Name: ";
    public static final String PASSWORD_PROMPT = "Enter Password: ";
    public static final String LOGIN_SUCCESS = "Login successful. Welcome, ";
    public static final String LOGIN_FAILED = "Login failed. Incorrect guard name or password.";
    public static final String NEXT_TASK_PROMPT = "Proceeding to the next task...";
    public static final String ACCESS_DENIED = "Access Denied.";
    public static final String CREATE_OR_VIEW_PROMPT = "\nChoose option \n1. create user (user)\n2. slot checking(slot) \n3. Remove from a slot (remove) ";
    public static final String ENTER_SLOT_NUMBER_REMOVE = "Enter slot number to remove vehicle from: ";
    public static final String INVALID_OPTION = "Invalid option";
    public static final String ENTER_NAME = "Enter name: ";
    public static final String ENTER_CONTACT = "Enter contact number: ";
    public static final String ENTER_POST = "Enter post: e.g.(student, faculty, other)";
    public static final String INVALID_INPUT_POST = "Invalid input. Please enter student, faculty or other.";
    public static final String ENTER_VALIDITY = "Enter post: e.g.(Daily, Weekly, Monthly, Annually)";
	
	public static final String Slot = "Slot ";
    public static final String Now_Empty = " is now empty.";
    public static final String Invalid_Slot_Number = "Invalid slot number or the slot is already empty.";
    public static final String Slot_Occupied = "All slots are occupied.";
    public static final String Slot_Not_Booked = "No slots are booked.";
    public static final String Booked_Successfully = " successfully booked.";
    
    // Receipt-related constants
    public static final void receipt(String name, String contact, String userType, String id, String vehicleType, String expiry, int price){
        String border = "+-----------------------------------+";
        String spacing = "|                                   |";
        System.out.println(border);
        System.out.println("|              PASS                 |");
        System.out.println(border);
        System.out.println(spacing);
        System.out.printf("| Name        : %-19s |\n", name);
        System.out.printf("| Contact     : %-19s |\n", contact);
        System.out.printf("| User Type   : %-19s |\n", userType);
        System.out.printf("| ID          : %-19s |\n", id);
        System.out.printf("| Vehicle Type: %-19s |\n", vehicleType);
        System.out.printf("| Cost        : %-19s |\n", price);
        System.out.printf("| Expiry      : %-19s |\n", expiry);
        System.out.println(spacing);
        System.out.println(border);
    }
    public static final String RECEIPT_BORDER = "+-----------------------------------+";
    public static final String RECEIPT_SPACING = "|                                   |";
    public static final String RECEIPT_TITLE = "|              PASS                 |";
    public static final String RECEIPT_NAME = "| Name        : %-19s |";
    public static final String RECEIPT_CONTACT = "| Contact     : %-19s |";
    public static final String RECEIPT_USER_TYPE = "| User Type   : %-19s |";
    public static final String RECEIPT_ID = "| ID          : %-19s |";
    public static final String RECEIPT_VEHICLE_TYPE = "| Vehicle Type: %-19s |";
    public static final String RECEIPT_COST = "| Cost        : %-19s |";
    public static final String RECEIPT_EXPIRY = "| Expiry      : %-19s |";
    public static final String INVALID_NAME = "Invaild Name";
    public static final String INVALID_CONTACT = "Invaild Number";
	
	// Hard coded value of Pass and sub classes
	public static String ENTER_DATE = "Enter the date (1-31): ";
	public static String ENTER_MONTH = "Enter the month (1-12): ";
	public static String ENTER_YEAR = "Enter the year (2024): ";
	public static String ENTER_HRS = "Enter the hour (0-23): ";
	public static String ENTER_MIN = "Enter the minute (0-59): ";
	public static String INVALID_INPUT = "Invalid input Please enter a value between ";
	public static String AND = " and ";
	public static String INVALID_INTEGER = "Invalid input Please enter an integer value.";
	public static String NAME = "Name: ";
	public static String CONTACT = "Conatact: ";
	public static String ROLE = "Role: ";
	public static String VEHICLE_TYPE = "Vehicle type: ";
	public static String PASS_TYPE = "Pass type: ";
	public static String PRICE = "Price: ";
	public static String EXPIRY = "Expiry date: ";
	public static String FORMAT = "%02d-%02d-%d %02d:%02d";
    
	
}
