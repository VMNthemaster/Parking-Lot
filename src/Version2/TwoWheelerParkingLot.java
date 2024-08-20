package Version2;

public class TwoWheelerParkingLot extends ParkingLotImpl {

    private static int currentTotalNumOfTwoWheelers = 0;

    @Override
    public int calculateTicket(VehicleInfo vehicleInfo) {
        vehicleInfo.setOutTime(System.currentTimeMillis());
        return (int) (vehicleInfo.getOutTime() - vehicleInfo.getInTime())/100;
    }

    @Override
    public boolean isParkingSpotAvailable(){
        return TwoWheelerParkingLot.currentTotalNumOfTwoWheelers < Parking.TWO_WHEELER_PARKING.getValue();
    }

    public static int getCurrentTotalNumOfTwoWheelers() {
        return TwoWheelerParkingLot.currentTotalNumOfTwoWheelers;
    }

    @Override
    public void updateCurrentValue(int value){
        TwoWheelerParkingLot.currentTotalNumOfTwoWheelers += value;
    }
}
