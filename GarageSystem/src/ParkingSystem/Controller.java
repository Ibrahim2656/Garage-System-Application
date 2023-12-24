package ParkingSystem;

import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    Scanner in = new Scanner(System.in);

    private String Name;
    private int OwnerID;
    public Garage MyGarage = new Garage();
    public ParkIn config;
    public ParkOut parkout = new ParkOut();

    public void SetId(int id) {
        OwnerID = id;
    }

    public void SetName(String name) {
        Name = name;
    }

    public String GetName() {
        return Name;
    }

    public int GetID() {
        return OwnerID;
    }
    public void setConfiguration(ParkIn ob) {
        config = ob;
    }


}
