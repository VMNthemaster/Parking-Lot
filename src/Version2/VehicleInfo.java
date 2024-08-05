package Version2;

public class VehicleInfo extends Vehicle {
    private long inTime;
    private long outTime;
    private int ticket;
    String id;

    public VehicleInfo(String namePlate, String typeOfVehicle) {
        super(namePlate, typeOfVehicle);
        this.id = generateId();
        this.inTime = System.currentTimeMillis();
    }

    private String generateId() {
        ParkingLotImpl.idValue++;
        return typeOfVehicle + ParkingLotImpl.idValue;
    }

    public String getNamePlate() {
        return namePlate;
    }

    public String getId() {
        return id;
    }

    public long getInTime() {
        return inTime;
    }

    public long getOutTime() {
        return outTime;
    }

    public void setOutTime(long outTime) {
        this.outTime = outTime;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "VehicleInfo{" +
                "inTime=" + inTime +
                ", outTime=" + outTime +
                ", ticket=" + ticket +
                ", id='" + id + '\'' +
                ", namePlate='" + namePlate + '\'' +
                ", typeOfVehicle='" + typeOfVehicle + '\'' +
                '}';
    }
}
