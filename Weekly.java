public class Weekly extends Pass {
    private int price;

    public Weekly(Vehicle vehicle){
        super(vehicle);
        this.price = getPrice(vehicle.type);
    }

    public int getPrice(String type){
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
}

