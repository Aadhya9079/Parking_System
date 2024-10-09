 public class Daily extends Pass {
    public int price;
	public String expiry;

    public Daily(Vehicle vehicle) {
        super(vehicle); 
        this.price = price(vehicle.type); 
		this.expiry = expiry();
    }

    public int price(String type) {
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
	
	public String expiry(){
        LocalDateTime instance = LocalDateTime.now();

        LocalDateTime expiryDate = instance.plusDays(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");

        String formattedString = formatter.format(expiryDate);
        return formattedString;
    }
	
	public String getExpiry(){
        return expiry;
    }
	
	public int getPrice() {
        return price; 
    }
}
