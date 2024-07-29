public interface ParkingLot {
    Status addTwoWheeler(String _namePlate);
    Status addFourWheeler(String _namePlate);

    Status removeTwoWheeler(String _id);
    Status removeFourWheeler(String _id);

    int calculateTwoWheelerTicket(String _id);
    int calculateFourWheelerTicket(String _id);

    TwoWheeler twoWheelerDetails(String _id);
    FourWheeler fourWheelerDetails(String _id);

}
