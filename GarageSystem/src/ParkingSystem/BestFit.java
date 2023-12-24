package ParkingSystem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BestFit implements ParkIn {
    public boolean Park(Garage g1, Vehicle v1) {
        if (!g1.Checkavailability())
            return false;
        Slot temp = new Slot();
        temp.setDim(1000, 1000);
        int index = -1;
        boolean found = false;
        for (int i = 0; i < g1.getNumOfSlots(); i++) {
            if (g1.arrOfSlots[i].getStatu())
                continue;
            if (g1.arrOfSlots[i].getDepth() >= v1.getDepth() && g1.arrOfSlots[i].getWidth() >= v1.getWidth()) {
                if (g1.arrOfSlots[i].getDepth() * g1.arrOfSlots[i].getWidth() < temp.getDepth() * temp.getWidth()) {
                    found = true;
                    temp = g1.arrOfSlots[i];
                    index = i;
                }
            }
        }
        if (found) {
            g1.arrOfSlots[index].BookSlot();
            v1.setSlotNumV(index);
            g1.arrOfVehicles[index] = v1;
            Date CurrentTime = new Date();
            SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            g1.arrOfSlots[index].setArivalTime(timeformat.format(CurrentTime));
            g1.Addvehilce();
            return true;
        }
        return false;
    }
}
