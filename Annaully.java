public class Annually extends Pass {
    private int price;

    public Annually(Vehicle vehicle){
        super(vehicle);
        this.price = getPrice(vehicle.type);
    }

    public int getPrice(String type){
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

    public int getPrice(){
        return price;
    }
}
