/**
 * The Daily class calculates the price and expiry of a daily parking pass for a vehicle.
 * It extends the Pass class and includes methods for calculating these attributes.
 * Owner: Arjun Gautam
 */

class Daily extends Pass {
    public int price;

    Daily(Vehicle vehicle) {
        super(vehicle);
        this.price = price(vehicle.type);
        this.expiry = calculateExpiry(1);
    }

    public int price(String type) {
        // Returns the price based on the type of vehicle.
        switch (type) {
            case "cycle":
                return 10;
            case "bike":
                return 20;
            case "car":
                return 50;
            default:
                return 0;
        }
    }

    public String calculateExpiry(int daysToAdd) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter current day: ");
        int day = scanner.nextInt();

        System.out.println("Enter current month: ");
        int month = scanner.nextInt();

        System.out.println("Enter current year: ");
        int year = scanner.nextInt();

        System.out.println("Enter current hour: ");
        int hour = scanner.nextInt();

        System.out.println("Enter current minute: ");
        int minute = scanner.nextInt();

        // Add days manually
        day += daysToAdd;

        // Adjust for month-end and year-end
        while (true) {
            if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31) {
                day -= 31;
                month += 1;
            } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
                day -= 30;
                month += 1;
            } else if (month == 2 && day > 28) { // Simplified leap year check
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

        // Manually create the formatted string
        String formattedExpiry = (day < 10 ? "0" : "") + day + "-" + (month < 10 ? "0" : "") + month + "-" + year + " " + (hour < 10 ? "0" : "") + hour + ":" + (minute < 10 ? "0" : "") + minute;

        return formattedExpiry;
    }

    public int getPrice() {
        // Returns the price of the daily pass.
        return price;
    }
}
