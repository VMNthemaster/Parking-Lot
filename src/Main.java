import java.util.Scanner;
// implement clear function
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("PARKING LOT IMPLEMENTATION....");

        ParkingLotImpl parkingLotObj = new ParkingLotImpl();

        int flag = 0;

        while (flag == 0){
            System.out.println("Enter type of vehicle: \n1. Two-wheeler. \n2. Four-wheeler. \n3. Print all vehicles. ");
            int typeOfVehicle = sc.nextInt();
            switch (typeOfVehicle) {
                case 1: {
                    twoWheelerSwitch(parkingLotObj);
                    break;
                }
                case 2: {
                    fourWheelerSwitch(parkingLotObj);
                    break;
                }
                case 3: {
                    parkingLotObj.printTwoWheelerKeys();
                    parkingLotObj.printFourWheelerKeys();
                    break;
                }
                default: {
                    System.out.println("Incorrect value chosen...");
                    break;
                }
            }
            System.out.println("Press 0 to continue: ");
            flag = sc.nextInt();
        }
    }

    private static void fourWheelerSwitch(ParkingLotImpl _parkingLotImplObj) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter action to be performed: \n1. Add vehicle. \n2. Remove vehicle");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: {
                boolean isParkingAvailable = _parkingLotImplObj.isFourWheelerParkingAvailable();
                if (isParkingAvailable) {
                    System.out.println("Enter name-plate: ");
                    String namePlate = sc.next();
                    Status status = _parkingLotImplObj.addFourWheeler(namePlate);
                    System.out.println(status.validationMessage);
                }
                else{
                    System.out.println("Parking full.");
                }
                break;
            }
            case 2: {
                System.out.println("Enter Id: ");
                String id = sc.next();
                boolean doesVehicleExists = _parkingLotImplObj.doesFourWheelerIdExists(id);
                if (doesVehicleExists) {
                    FourWheeler vehicleDetails = _parkingLotImplObj.fourWheelerDetails(id);
                    System.out.print(vehicleDetails.toString());
                    int ticket = _parkingLotImplObj.calculateFourWheelerTicket(id);
                    System.out.println("Ticket price: " + ticket);
                    Status status = _parkingLotImplObj.removeFourWheeler(id);
                    System.out.println(status.validationMessage);
                }
                else {
                    System.out.println("No vehicle found with id " + id);
                }
                break;
            }
        }
    }

    private static void twoWheelerSwitch(ParkingLotImpl _parkingLotImplObj) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter action to be performed: \n1. Add vehicle. \n2. Remove vehicle");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: {
                boolean isParkingAvailable = _parkingLotImplObj.isTwoWheelerParkingAvailable();
                if (isParkingAvailable) {
                    System.out.println("Enter name-plate: ");
                    String namePlate = sc.next();
                    Status status = _parkingLotImplObj.addTwoWheeler(namePlate);
                    System.out.println(status.validationMessage);
                }
                else{
                    System.out.println("Parking full.");
                }
                break;
            }
            case 2: {
                System.out.println("Enter Id: ");
                String id = sc.next();
                boolean doesVehicleExists = _parkingLotImplObj.doesTwoWheelerIdExists(id);
                if (doesVehicleExists) {
                    TwoWheeler vehicleDetails = _parkingLotImplObj.twoWheelerDetails(id);
                    System.out.println(vehicleDetails.toString());
                    int ticket = _parkingLotImplObj.calculateTwoWheelerTicket(id);
                    System.out.println("Ticket price: " + ticket);
                    Status status = _parkingLotImplObj.removeTwoWheeler(id);
                    System.out.println(status.validationMessage);
                }
                else {
                    System.out.println("No vehicle found with id " + id);
                }
                break;
            }
            default: {
                System.out.println("Incorrect value chosen....");
                break;
            }
        }
    }

}