/**
 * This abstract class contains common vehicle methods such as id validation.
 * Owner-Name: Aadhya Goyal
 * Date-of-Creation: 09-10-24
 */

 import java.util.Scanner;
 abstract class Vehicle {
     protected static Scanner scanner = new Scanner(System.in);
     protected String vehicleId;
 
     protected static String[] vehicleIds = new String[100];
     protected static int vehicleCount = 0;
 
     public abstract void inputVehicleId();
 
     /**
      * Common validation method for vehicle id
       */
     protected boolean isValid(String input) {
         if (input.length() != 10) {
             return false;
         }
         for (int i = 0; i < input.length(); i++) {
             char character = input.charAt(i);
             if (!((character >= '0' && character <= '9') || (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z'))) {
                 return false;
             }
         }
         return true;
     }
 
     // Method to check if the vehicle ID is already in the system
     protected boolean isAlreadyRegistered(String id) {
         for (int i = 0; i < vehicleCount; i++) {
             if (vehicleIds[i] != null && vehicleIds[i].equals(id)) {
                 return true; // ID already registered
             }
         }
         return false; // ID not found
     }
 
     // Method to add the vehicle ID to the system
     protected void registerVehicleId(String id) {
         if (vehicleCount < vehicleIds.length) {
             vehicleIds[vehicleCount] = id; // Store ID in the array
             vehicleCount++; // Increment the count
         }
     }
 
     /**
      * Method to generate a unique ID from name and contact number
       */
     public static String id(String name, String number) {
         String input = name + number;
         return input;
     }

 }