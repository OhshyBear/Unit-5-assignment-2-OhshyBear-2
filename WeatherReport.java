import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Comparator;
import java.util.LinkedList;
import java.io.FileNotFoundException;

/**
 * @author Trevor Huddleston
 * Put your name and date and description here.
 */


public class WeatherReport {
    private LinkedList<Temperature> temps;

    // No-parameter constructor for test data
    public WeatherReport() {
        temps = new LinkedList<>();

        temps.add(new Temperature("Kansas City", "Missouri", 32, 48));
        temps.add(new Temperature("Phoenix", "AZ", 55, 83));
        temps.add(new Temperature("Chicago", "IL", 27, 42));
        temps.add(new Temperature("Miami", "FL", 60, 88));
        temps.add(new Temperature("Denver", "CO", 28, 45));
        temps.add(new Temperature("Dallas", "TX", 50, 75));
        temps.add(new Temperature("Seattle", "WA", 40, 55));
        temps.add(new Temperature("Boston", "MA", 35, 52));
        temps.add(new Temperature("San Diego", "CA", 58, 76));
        temps.add(new Temperature("Las Vegas", "NV", 47, 81));
    }

    public WeatherReport(String fileName) throws FileNotFoundException{
        temps = new LinkedList<>();

        File file = new File(fileName);
        Scanner input = new Scanner(file);
        //skip the header line.
        if (input.hasNextLine()){
            input.nextLine();
        }
        //read data lines
        while(input.hasNextLine()){
            String line = input.nextLine();
            String[] part = line.split(",");

            String city = part[1];
            String state = part[10];
            int low = Integer.parseInt(part[6]);
            int high = Integer.parseInt(part[5]);

            temps.add(new Temperature(city, state, low, high));
        }
        input.close();
    }

    public LinkedList<Temperature> getTemps(){
        return temps;
    }

    public boolean isSortedByCity(){
        for (int i = 0; i < temps.size() - 1; i++){
            if(temps.get(i).getCity().compareTo(temps.get(i + 1).getCity()) > 0)
                return false;
        }
        return true;
    }

  
}