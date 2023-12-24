package ParkingSystem;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Slot {
    private double depth;
    private double width;
    public int SlotNumS;
    public String ArivalTime;
    public String LeaveTime;
    private boolean status;

    public void setDim(double d, double w) {
        status = false;
        depth = d;
        width = w;
    }

    public void BookSlot() {
        status = true;
    }

    public void FreeSlot() {
        status = false;
    }

    public void setArivalTime(String st) {
        ArivalTime = st;
    }

    public String getArivalTime() {
        return ArivalTime;
    }

    public void setLeaveTime(String st) {
        LeaveTime = st;
    }

    public String getLeaveTime() {
        return LeaveTime;
    }

    public boolean getStatu() {
        return status;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

}
