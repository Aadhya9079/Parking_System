import java.util.Scanner;

class Vehicle {
  static Scanner scanner = new Scanner(System.in);

  public static void vehicleType() {
    System.out.println("Enter the vehicle type:\n1:Car\n2:Bike\n3:Cycle\n4:Other");
    int type = scanner.nextInt();
    scanner.nextLine();

    switch (type) {
      case 1 -> car();
      case 2 -> bike();
      case 3 -> {
      }
      case 4 -> other();
      default -> System.out.println("Invalid vehicle type selected.");
    }
  }

  private static boolean isValid(String input) {
    if (input.length() != 10) {
      return false;
    }
    for (int i = 0; i < input.length(); i++) {
      char character = input.charAt(i);
      if (!((character >= '0' && character <= '9') || (character >= 'a' && character <= 'z')
          || (character >= 'A' && character <= 'Z'))) {
        return false;
      }
    }
    return true;
  }

  public static void car() {
    System.out.print("Enter your vehicle id: ");
    String id = scanner.nextLine().toUpperCase();
    while (!isValid(id)) {
      System.out.println("Invalid vehicle id.");
      System.out.print("Enter your vehicle id: ");
      id = scanner.nextLine();
    }
    System.out.println("Your vehicle id is: " + id);
  }

  public static void bike() {
    System.out.print("Enter your vehicle id: ");
    String id = scanner.nextLine().toUpperCase();
    while (!isValid(id)) {
      System.out.println("Invalid vehicle id.");
      System.out.print("Enter your vehicle id: ");
      id = scanner.nextLine();
    }
    System.out.println("Your vehicle id is: " + id);
  }

  public static void other() {
    System.out.print("Enter your vehicle id: ");
    String id = scanner.nextLine().toUpperCase();
    while (!isValid(id)) {
      System.out.println("Invalid vehicle id.");
      System.out.print("Enter your vehicle id: ");
      id = scanner.nextLine();
    }
    System.out.println("Your vehicle id is: " + id);
  }
}