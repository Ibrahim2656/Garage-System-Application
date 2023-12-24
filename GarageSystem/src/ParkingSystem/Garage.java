package ParkingSystem;

import java.util.*;

public class Garage {
    Scanner in = new Scanner(System.in);
    private int NumberOfVehicles;
    private int numOfslots;
    public Vehicle[] arrOfVehicles;
    public Slot[] arrOfSlots;

    public void setNumOfSlots(int n) {
        numOfslots = n;
        arrOfSlots = new Slot[numOfslots];
        arrOfVehicles = new Vehicle[numOfslots];
    }

    public void setSlots(Slot slot, int index) {
        arrOfSlots[index] = slot;

    }

    public int getNumOfSlots() {
        return numOfslots;
    }

    public int getNumberofVehicles() {
        return NumberOfVehicles;
    }

    public void Addvehilce() {
        NumberOfVehicles++;
    }

    public void removevehicle() {
        NumberOfVehicles--;
    }

    public boolean Checkavailability() {
        for (int i = 0; i < numOfslots; i++) {
            if (!arrOfSlots[i].getStatu())
                return true;
        }
        return false;
    }

}