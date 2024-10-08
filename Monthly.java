public class Monthly extends Pass {
    private int price;
	private String expiry;

    public Monthly(Vehicle vehicle){
        super(vehicle);
        this.price = price(vehicle.type);
		this.expiry = expiry();
    }

    public int price(String type){
        switch(type){
            case "cycle":
                return 500;
            case "bike":
                return 2000;
            case "car":
                return 5000;
            default:
                return 0;
        }
    }

    public String expiry(){
        LocalDateTime instance = LocalDateTime.now();

        LocalDateTime expiryDate = instance.plusMonths(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");

        String formattedString = formatter.format(expiryDate);
        return formattedString;
    }
       
    public int getPrice() {
        return price; 
    }

    public String getExpiry(){
        return expiry;
    }
}
