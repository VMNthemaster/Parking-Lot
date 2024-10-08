import java.util.HashMap;

public abstract class GLOBAL_CONSTANTS {
    final static int TWO_WHEELER_PARKING = 50;
    final static int FOUR_WHEELER_PARKING = 20;
    final static float LOAD_FACTOR = 1.0f;
    final static String TWO_WHEELER = "TW";
    final static String FOUR_WHEELER = "FW";
    final static String SUCCESS = "SUCCESS";
    final static String ERROR = "ERROR";

    public static HashMap<String, TwoWheeler> twoWheelerHashMapObj = new HashMap<>(TWO_WHEELER_PARKING, LOAD_FACTOR);
    public static HashMap<String, FourWheeler> fourWheelerHashMapObj = new HashMap<>(FOUR_WHEELER_PARKING, LOAD_FACTOR);
}
