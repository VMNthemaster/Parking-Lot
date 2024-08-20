package Version2;

public enum ParkingType {
    TWO_WHEELER("TW"),
    FOUR_WHEELER("FW");

    private final String parkingType;

    ParkingType(String parkingType){
        this.parkingType = parkingType;
    }

    public String getValue(){
        return parkingType;
    }
}
