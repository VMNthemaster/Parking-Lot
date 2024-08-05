package Version2;

public interface ParkingLot {
    Status addVehicle(VehicleInfo _vehicleInfo);
    Status removeVehicle(String _id);
    int calculateTicket(VehicleInfo _vehicleInfo);
    VehicleInfo getVehicleDetails(String _id);
    void updateCurrentValue(int value);
    public boolean isParkingSpotAvailable();
}
