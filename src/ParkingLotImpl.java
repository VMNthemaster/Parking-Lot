public class ParkingLotImpl implements ParkingLot {

    public int idValue = 0;

    @Override
    public Status addTwoWheeler(String _namePlate) {
        idValue++;
        TwoWheeler.currentTotalNumberOfTwoWheelers++;
        TwoWheeler newTwoWheeler = new TwoWheeler(_namePlate, idValue);
        GLOBAL_CONSTANTS.twoWheelerHashMapObj.put(newTwoWheeler.id, newTwoWheeler);

        return new Status(true, GLOBAL_CONSTANTS.SUCCESS);
    }

    @Override
    public Status addFourWheeler(String _namePlate) {
        idValue++;
        FourWheeler.currentTotalNumberOfFourWheelers++;
        FourWheeler newFourWheeler = new FourWheeler(_namePlate, idValue);
        GLOBAL_CONSTANTS.fourWheelerHashMapObj.put(newFourWheeler.id, newFourWheeler);
        return new Status(true, GLOBAL_CONSTANTS.SUCCESS);
    }

    @Override
    public Status removeTwoWheeler(String _id) {
        TwoWheeler.currentTotalNumberOfTwoWheelers--;
        GLOBAL_CONSTANTS.twoWheelerHashMapObj.remove(_id);
        return new Status(true, GLOBAL_CONSTANTS.SUCCESS);
    }

    @Override
    public Status removeFourWheeler(String _id) {
        FourWheeler.currentTotalNumberOfFourWheelers--;
        GLOBAL_CONSTANTS.fourWheelerHashMapObj.remove(_id);
        return new Status(true, GLOBAL_CONSTANTS.SUCCESS);
    }

    public boolean isTwoWheelerParkingAvailable(){
        int currentTotalNumberOfTwoWheelers = TwoWheeler.currentTotalNumberOfTwoWheelers;
        return currentTotalNumberOfTwoWheelers < GLOBAL_CONSTANTS.TWO_WHEELER_PARKING;
    }

    public boolean isFourWheelerParkingAvailable(){
        int currentTotalNumberOfFourWheelers = FourWheeler.currentTotalNumberOfFourWheelers;
        return currentTotalNumberOfFourWheelers < GLOBAL_CONSTANTS.FOUR_WHEELER_PARKING;
    }

    public boolean doesTwoWheelerIdExists(String _id){
        return GLOBAL_CONSTANTS.twoWheelerHashMapObj.containsKey(_id);
    }

    public boolean doesFourWheelerIdExists(String _id){
        return GLOBAL_CONSTANTS.fourWheelerHashMapObj.containsKey(_id);
    }

    public int calculateTwoWheelerTicket(String _id){
        TwoWheeler twoWheeler = GLOBAL_CONSTANTS.twoWheelerHashMapObj.get(_id);
        return (int) (System.currentTimeMillis() - twoWheeler.inTime) / 100;
    }

    public int calculateFourWheelerTicket(String _id){
        FourWheeler fourWheeler = GLOBAL_CONSTANTS.fourWheelerHashMapObj.get(_id);
        return (int) (System.currentTimeMillis() - fourWheeler.inTime) / 100;
    }

    public void printTwoWheelerKeys(){
        System.out.println("Printing two wheelers....");
        for(String id: GLOBAL_CONSTANTS.twoWheelerHashMapObj.keySet()){
            System.out.print(id + "\t");
        }
        System.out.println("\n");
    }

    public void printFourWheelerKeys(){
        System.out.println("Printing four wheelers....");
        for(String id: GLOBAL_CONSTANTS.fourWheelerHashMapObj.keySet()){
            System.out.print(id + "\t");

        }
        System.out.println("\n");
    }

    @Override
    public TwoWheeler twoWheelerDetails(String _id){
        return GLOBAL_CONSTANTS.twoWheelerHashMapObj.get(_id);
    }

    @Override
    public FourWheeler fourWheelerDetails(String _id) {
        return GLOBAL_CONSTANTS.fourWheelerHashMapObj.get(_id);
    }


}
