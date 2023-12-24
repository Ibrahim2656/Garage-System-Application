package ParkingSystem;
//import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParkOut {
    public Calculator MyCalc = new Calculator();

    public double Parkingout(Garage MyGarage, int carid) throws ParseException {
        for (int i = 0; i < MyGarage.getNumOfSlots(); i++) {

            if (MyGarage.arrOfVehicles[i] == null) continue;

            if (MyGarage.arrOfVehicles[i].getID() == carid) {
                MyGarage.removevehicle();
                MyGarage.arrOfSlots[i].FreeSlot();
                MyGarage.arrOfVehicles[i] = null;
                Date CurrentTime = new Date();
                SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                MyGarage.arrOfSlots[i].setLeaveTime(timeformat.format(CurrentTime));
                return MyCalc.CalculateFees(MyGarage.arrOfSlots[i].getArivalTime(), MyGarage.arrOfSlots[i].getLeaveTime());
            }
        }
        return 0;
    }
}