 public class Daily extends Pass {
    private int price;

    public Daily(Vehicle vehicle) {
        super(vehicle); 
        this.price = getPrice(vehicle.type); 
    }

    public int getPrice(String type) {
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
       
    public int getPrice() {
        return price; 
    }
}
