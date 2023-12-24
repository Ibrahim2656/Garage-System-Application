package ParkingSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Math.*;

public class Calculator {

    public double Income;

    public double GetIncome() {
        return Income;
    }

    public double CalculateFees(String arival, String leave) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        double tot = 0;
        try {
            // parse method is used to parse
            // the text from a string to
            // produce the date
            Date d1 = sdf.parse(arival);
            Date d2 = sdf.parse(leave);

            // Calucalte time difference
            // in milliseconds
            long difference_In_Time = d2.getTime() - d1.getTime();
            double difference_In_Minutes = (difference_In_Time / (1000.0 * 60)) % 60;

            double difference_In_Hours = (difference_In_Time / (1000.0 * 60 * 60)) % 24;

            long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

            tot += (ceil(difference_In_Hours) * 5) + difference_In_Days * 24 * 5;

        }
        // Catch the Exception
        catch (ParseException e) {
            e.printStackTrace();
        }
        Income += tot;
        return tot;
    }
}
