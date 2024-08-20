package Version2;

import java.util.HashMap;

public abstract class GLOBAL_CONSTANTS {
    final static float LOAD_FACTOR = 1.0f;
    final static String SUCCESS = "SUCCESS";
    final static String ERROR = "ERROR";

    public static HashMap<String, VehicleInfo> vehicleInfoHashMapObj = new HashMap<>(Parking.TWO_WHEELER_PARKING.getValue() + Parking.FOUR_WHEELER_PARKING.getValue(), LOAD_FACTOR);
    public static HashMap<String, VehicleInfo> records = new HashMap<>();
}

// created enums for parking and parking types
