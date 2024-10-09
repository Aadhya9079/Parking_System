public class Weekly extends Pass {
    public int price;
	public String expiry;

    public Weekly(Vehicle vehicle){
        super(vehicle);
        this.price = price(vehicle.type);
		this.expiry = expiry();
    }

    public int price(String type){
        switch(type){
            case "cycle":
                return 50;
            case "bike":
                return 100;
            case "car":
                return 300;
            default:
                return 0;
        }
    }

    public int getPrice(){
        return price;
    }
	
	public String expiry(){
        LocalDateTime instance = LocalDateTime.now();

        LocalDateTime expiryDate = instance.plusWeeks(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");

        String formattedString = formatter.format(expiryDate);
        return formattedString;
    }
	
	public String getExpiry(){
        return expiry;
    }
}

