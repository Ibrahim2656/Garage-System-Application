package ParkingSystem;

import java.util.*;

public class Vehicle {
    private double depth;
    private double width;
    private int ID;
    public int slotNumV;

    public void setVehicleDim(double a, double b) {
        depth = a;
        width = b;
    }

    public void setVehicleID(int i) {
        ID = i;
    }

    public double getDepth() {
        return depth;
    }

    public double getWidth() {
        return width;
    }

    public void setSlotNumV(int i) {
        slotNumV = i;
    }

    public int getID() {
        return ID;
    }
}