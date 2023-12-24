package ParkingSystem;

import java.text.ParseException;
import java.util.*;

public class Screen {
    Scanner in = new Scanner(System.in);

    public void displayMenu() throws ParseException {
        System.out.println("Set UP Your Garage: ");
        System.out.println("Enter Your Name: ");
        Controller owner = new Controller();
        owner.SetName(in.next());
        System.out.println("Enter Your ID: ");
        owner.SetId(in.nextInt());
        System.out.println("Choose your garage Configuration: ");
        System.out.println("1-First Fit: ");
        System.out.println("2-Best Fit: ");
        int con = in.nextInt();
        if (con == 1) {
            ParkIn ob = new FirstFit();
            owner.setConfiguration(ob);
        } else if (con == 2) {
            ParkIn ob = new BestFit();
            owner.setConfiguration(ob);
        }
        System.out.println("Enter Your Garage Capacity: ");
        int numberofslots = in.nextInt();
        owner.MyGarage.setNumOfSlots(numberofslots);
        for (int i = 0; i < numberofslots; i++) {
            Slot slot = new Slot();
            System.out.println("Enter Depth and Width: ");
            slot.setDim(in.nextDouble(), in.nextDouble());
            owner.MyGarage.setSlots(slot, i);

        }
        while (true) {
            System.out.println("1.Park in");
            System.out.println("2.Park out");
            System.out.println("3.show available slots");
            System.out.println("4.display number of vehicles");
            System.out.println("5.display income");
            System.out.println("6.Exit");
            int choice = in.nextInt();
            if (choice == 1) {
                Vehicle vehicle = new Vehicle();
                System.out.println("Enter Depth and Width of the Vehicle: ");
                vehicle.setVehicleDim(in.nextDouble(), in.nextDouble());
                System.out.println("Enter Car ID: ");
                vehicle.setVehicleID(in.nextInt());
                if (owner.config.Park(owner.MyGarage, vehicle))
                    System.out.println("Car Can Park");
                else
                    System.out.println("No Available Slots For this car");
            } else if (choice == 2) {
                System.out.println("Enter ID of the Vehicle: ");
                double fees = owner.parkout.Parkingout(owner.MyGarage, in.nextInt());
                if (fees == 0)
                    System.out.println("No Car with this ID found");
                else
                    System.out.println("Parking Fees For This Car is : " + fees + " Pounds");
            } else if (choice == 3) {
                if (!owner.MyGarage.Checkavailability())
                    System.out.println("NO Available Slots");
                for (int i = 0; i < owner.MyGarage.getNumOfSlots(); i++) {
                    if (owner.MyGarage.arrOfSlots[i].getStatu())
                        continue;
                    System.out.println("Slot Number " + (i + 1));
                    System.out.println("Dimensions Of Slot (" + owner.MyGarage.arrOfSlots[i].getDepth() + " , " + owner.MyGarage.arrOfSlots[i].getWidth() + ")");
                }

            } else if (choice == 4) {
                System.out.println("Number of Vehicles: " + owner.MyGarage.getNumberofVehicles());
            } else if (choice == 5) {
                System.out.println("Total Income: " + owner.parkout.MyCalc.GetIncome() + " Pounds");
            } else {
                break;
            }
        }
    }

}
