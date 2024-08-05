package Version2;

public abstract class ParkingLotImpl implements ParkingLot {

    public static int idValue;

    static {
        idValue = 0;
    }

    @Override
    public Status addVehicle(VehicleInfo _vehicleInfo) {
        try {
            GLOBAL_CONSTANTS.vehicleInfoHashMapObj.put(_vehicleInfo.getId(), _vehicleInfo);
            return new Status(true, GLOBAL_CONSTANTS.SUCCESS);
        }
        catch (Exception e){
            System.out.println("Failed to add vehicle");
        }
        return new Status(false, GLOBAL_CONSTANTS.ERROR);
    }
    public Status removeVehicle(String _id) {
        try {
            GLOBAL_CONSTANTS.vehicleInfoHashMapObj.remove(_id);
            return new Status(true, GLOBAL_CONSTANTS.SUCCESS);
        }
        catch (Exception e){
            System.out.println("Failed to remove vehicle");
        }
        return new Status(false, GLOBAL_CONSTANTS.ERROR);
    }

    @Override
    public VehicleInfo getVehicleDetails(String _id) {
        return GLOBAL_CONSTANTS.vehicleInfoHashMapObj.get(_id);
    }

    @Override
    abstract public int calculateTicket(VehicleInfo vehicleInfo);
    abstract public void updateCurrentValue(int value);
    abstract public boolean isParkingSpotAvailable();

}
