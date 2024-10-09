public class Slot {
    static int totalSlots = 100;
    static boolean[] isOccupied = new boolean[totalSlots];
    static BookingDetails[] slotDetails = new BookingDetails[totalSlots];
    static int counter = 0;

    // Class to hold booking details
    static class BookingDetails {
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
    public static int findFirstAvailableSlot() {
        for (int i = 0; i < totalSlots; i++) {
            if (!isOccupied[i]) {
                return i;
            }
        }
        return -1;
    }

    // Booking a slot
    public static void bookSlot(String id) {
        int availableSlot = findFirstAvailableSlot();
        if (availableSlot == -1) {
            return;
        }
        BookingDetails details = new BookingDetails(id);
        slotDetails[availableSlot] = details;
        isOccupied[availableSlot] = true;
        counter++;
        System.out.println("Slot " + (availableSlot + 1) + " successfully booked.");
    }

    // View all booked slots
    public static void viewBookedSlots() {
        if (counter == 0) {
            System.out.println("No slots are booked.");
        } else {
            for (int i = 0; i < totalSlots; i++) {
                if (isOccupied[i]) {
                    System.out.println("Slot " + (i + 1) + ": " + slotDetails[i].toString());
                }
            }
        }
    }

    // View available slots
    public static boolean isAvailableSlots() {
        if (counter == totalSlots) {
            System.out.println("All slots are occupied.");
            return false;
        }
        System.out.println("Slots availble");
        return true;
    }

    // Remove a vehicle from a slot
    public static void removeVehicle(int slotNumber) {
        if (slotNumber < 1 || slotNumber > totalSlots || !isOccupied[slotNumber - 1]) {
            System.out.println("Invalid slot number or the slot is already empty.");
        } else {
            isOccupied[slotNumber - 1] = false;
            slotDetails[slotNumber - 1] = null;
            counter--;
            System.out.println("Slot " + slotNumber + " is now empty.");
        }
    }

   
}
