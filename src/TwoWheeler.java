public class TwoWheeler extends Vehicle {

    public static int currentTotalNumberOfTwoWheelers = 0;

    public TwoWheeler(String _namePlate, int _idValue){
        this.namePlate = _namePlate;
        this.id = generateTwoWheelerId(_idValue);
        this.inTime = System.currentTimeMillis();
    }

    String generateTwoWheelerId(int _idValue){
        return GLOBAL_CONSTANTS.TWO_WHEELER + _idValue;
    }

    @Override
    public String toString() {
        return "TwoWheeler{" +
                "id='" + id + '\'' +
                ", namePlate='" + namePlate + '\'' +
                ", inTime=" + inTime +
                '}';
    }
}
