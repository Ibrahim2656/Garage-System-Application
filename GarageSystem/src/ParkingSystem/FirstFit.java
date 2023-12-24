package ParkingSystem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstFit implements ParkIn {
    public boolean Park(Garage g1, Vehicle v1) {

        if (!g1.Checkavailability()) return false;

        for (int i = 0; i < g1.getNumOfSlots(); i++) {

            if (g1.arrOfSlots[i].getStatu()) continue;

            if (g1.arrOfSlots[i].getDepth() >= v1.getDepth() && g1.arrOfSlots[i].getWidth() >= v1.getWidth()) {
                g1.arrOfSlots[i].BookSlot();
                v1.setSlotNumV(i);
                g1.arrOfVehicles[i] = v1;
                g1.Addvehilce();
                Date CurrentTime = new Date();
                SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                g1.arrOfSlots[i].setArivalTime(timeformat.format(CurrentTime));
                return true;
            }
        }
        return false;
    }
}
