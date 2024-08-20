package Version2;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ParkingLotImpl parkingLot;
        TwoWheelerParkingLot twoWheelerParkingLot = new TwoWheelerParkingLot();
        ParkingLotImpl fourWheelerParkingLot = new FourWheelerParkingLot();

        int flag = 0;
        int type;

        while(flag == 0) {
            System.out.println("Enter type of vehicle: \n1. Two Wheeler \n2. Four Wheeler \n3. Print all vehicles \n4. Get Record");
            type = sc.nextInt();

            switch (type) {
                case 1: {
                    parkingLot = twoWheelerParkingLot;
                    performAction(parkingLot, GLOBAL_CONSTANTS.TWO_WHEELER);
                    break;
                }
                case 2: {
                    parkingLot = fourWheelerParkingLot;
                    performAction(parkingLot, GLOBAL_CONSTANTS.FOUR_WHEELER);
                    break;
                }
                case 3: {
                    printAllVehicles();
                    break;
                }
                case 4: {
                    System.out.println("Enter id: ");
                    String id = sc.next();
                    VehicleInfo vehicleInfo = getRecord(id);

                    if (vehicleInfo != null) {
                        System.out.println(vehicleInfo);
                    }
                    else {
                        System.out.println("Vehicle info does not exist....");
                    }
                    break;
                }
                default: {
                    System.out.println("Incorrect input");
                    break;
                }
            }
            System.out.println("Press 0 to continue: ");
            flag = sc.nextInt();
        }

        System.out.println("Total amount for today is: Rs " + PaymentImpl.getTotalAmount());
    }

    private static VehicleInfo getRecord(String id) {
        return GLOBAL_CONSTANTS.records.get(id);
    }

    private static void printAllVehicles() {
        for (String id: GLOBAL_CONSTANTS.vehicleInfoHashMapObj.keySet()){
            System.out.println(id + "\t");
        }
            System.out.println("\n");
    }

    private static void performAction(ParkingLotImpl parkingLot, String typeOfVehicle) {
        Scanner sc = new Scanner(System.in);
        int action;

        System.out.println("Perform action: \n1. Add vehicle \n2. Remove vehicle");
        action = sc.nextInt();

        switch (action) {
            case 1: {
                boolean isParkingSpotAvailable = parkingLot.isParkingSpotAvailable();
                if (isParkingSpotAvailable) {
                    System.out.println("Enter namePlate");
                    String namePlate = sc.next();

                    parkingLot.updateCurrentValue(1);

                    VehicleInfo vehicleInfo = new VehicleInfo(namePlate, typeOfVehicle);
                    Status status = parkingLot.addVehicle(vehicleInfo);

                    if (Objects.equals(status.validationMessage, GLOBAL_CONSTANTS.SUCCESS)){
                        System.out.println(GLOBAL_CONSTANTS.SUCCESS);
                    }
                    else {
                        parkingLot.updateCurrentValue(-1);
                        System.out.println(GLOBAL_CONSTANTS.ERROR);
                    }
                }
                else {
                    System.out.println("Parking full.");
                }
                break;
            }
            case 2: {
                System.out.println("Enter id of vehicle: ");
                String id = sc.next();

                VehicleInfo vehicleInfo = parkingLot.getVehicleDetails(id);

                if (vehicleInfo != null) {
                    int ticket = parkingLot.calculateTicket(vehicleInfo);
                    vehicleInfo.setTicket(ticket);
                    parkingLot.updateCurrentValue(-1);

                    PaymentImpl payment = new PaymentImpl();
                    int paidTicket = 0;

                    while (paidTicket != ticket){
                        System.out.println("Your ticket amount is: Rs " + ticket);
                        System.out.println("Please enter your ticket amount to pay: ");
                        paidTicket = sc.nextInt();
                    }
                    payment.payTicket(ticket);

                    Status status = parkingLot.removeVehicle(id);

                    if (Objects.equals(status.validationMessage, GLOBAL_CONSTANTS.SUCCESS)) {
                        System.out.println(GLOBAL_CONSTANTS.SUCCESS);
                        System.out.println("Vehicle details: \n" + vehicleInfo);

                        GLOBAL_CONSTANTS.records.put(id, vehicleInfo);
                    }
                    else {
                        parkingLot.updateCurrentValue(1);
                        System.out.println(GLOBAL_CONSTANTS.ERROR);
                    }
                }
                else {
                    System.out.println("Vehicle info does not exist");
                }
                break;

            }
            default: {
                System.out.println("Incorrect option chosen....");
                break;
            }
        }
    }
}
