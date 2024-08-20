package Version2;

public enum Parking {
    TWO_WHEELER_PARKING(2),
    FOUR_WHEELER_PARKING(20);

    private final int parking;

    Parking(int parking){
        this.parking = parking;
    }

    public int getValue(){
        return parking;
    }
}
