package Version2;

public class FourWheelerParkingLot extends ParkingLotImpl {

    private static int currentTotalNumOfFourWheelers = 0;

    @Override
    public int calculateTicket(VehicleInfo vehicleInfo) {
        vehicleInfo.setOutTime(System.currentTimeMillis());
        return (int) (vehicleInfo.getOutTime() - vehicleInfo.getInTime())/50;
    }

    public static int getCurrentTotalNumOfFourWheelers() {
        return FourWheelerParkingLot.currentTotalNumOfFourWheelers;
    }

    @Override
    public boolean isParkingSpotAvailable(){
        return FourWheelerParkingLot.currentTotalNumOfFourWheelers < Parking.FOUR_WHEELER_PARKING.getValue();
    }

    @Override
    public void updateCurrentValue(int value){
        FourWheelerParkingLot.currentTotalNumOfFourWheelers += value;
    }


}
