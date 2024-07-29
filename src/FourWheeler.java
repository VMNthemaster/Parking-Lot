public class FourWheeler extends Vehicle {

    public static int currentTotalNumberOfFourWheelers = 0;

    public FourWheeler(String _namePlate, int _idValue){
        this.namePlate = _namePlate;
        this.id = generateFourWheelerId(_idValue);
        this.inTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "FourWheeler{" +
                "id='" + id + '\'' +
                ", namePlate='" + namePlate + '\'' +
                ", inTime=" + inTime +
                '}';
    }

    String generateFourWheelerId(int _idValue){
        return GLOBAL_CONSTANTS.FOUR_WHEELER + _idValue;
    }

}
