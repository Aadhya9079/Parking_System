/***
 * The Slot class manages the booking, viewing, and removal of parking slots. It
 * maintains a total of 100 slots, allowing users to book available slots, check
 * for availability, view booked slots, and remove bookings. The class operates
 * using static data structures to track the status of each slot.
 * 
 * Author : Tanishq Dosaya
 * Date of creation : 09/10/2024
 */

 public class Slot{
    static int totalSlots = 100;
    static boolean[] isOccupied = new boolean[totalSlots];
    static BookingDetails[] slotDetails = new BookingDetails[totalSlots];
    static int counter = 0;

    // Class to hold booking details
    static class BookingDetails{
        String id;

        BookingDetails(String id2) {
            this.id = id2;
        }

        @Override
        public String toString() {
            return "ID: " + id;
        }
    }

    // Find the first available slot (starting from 0)
    public static int findFirstAvailableSlot(){
        for (int i = 0; i < totalSlots; i++) {
            if (!isOccupied[i]) {
                return i;
            }
        }
        return -1;
    }

    // Booking a slot
    public static void bookSlot(String id){
        Parking_Constant constant = new Parking_Constant();
        int availableSlot = findFirstAvailableSlot();
        if (availableSlot == -1) {
            return;
        }
        BookingDetails details = new BookingDetails(id);
        slotDetails[availableSlot] = details;
        isOccupied[availableSlot] = true;
        counter++;
        System.out.println(constant.Slot + (availableSlot + 1) + constant.Booked_Successfully);
    }

    // View all booked slots
    public static void viewBookedSlots(){
        Parking_Constant constant = new Parking_Constant();
        if (counter == 0) {
            System.out.println(constant.Slot_Not_Booked);
        } else {
            for (int i = 0; i < totalSlots; i++) {
                if (isOccupied[i]) {
                    System.out.println(constant.Slot + (i + 1) + ": " + slotDetails[i].toString());
                }
            }
        }
    }

    // View available slots
    public static boolean isAvailableSlots(){
        Parking_Constant constant = new Parking_Constant();
        if (counter == totalSlots) {
            System.out.println(constant.Slot_Occupied);
            return false;
        }
        return true;
    }

    // Remove a vehicle from a slot
    public static void removeVehicle(int slotNumber){
        Parking_Constant constant = new Parking_Constant();
        if (slotNumber < 1 || slotNumber > totalSlots || !isOccupied[slotNumber - 1]) {
            System.out.println(constant.Invalid_Slot_Number);
        } else {
            isOccupied[slotNumber - 1] = false;
            slotDetails[slotNumber - 1] = null;
            counter--;
            System.out.println(constant.Slot + slotNumber + constant.Now_Empty);
        }
    }
}
