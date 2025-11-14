import java.io.File;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.util.TreeMap;

/**
 * @author Trevor Huddleston
 * 11/14/2025
 * Weather Report Class that has a no parameter constructor of temps to simulate the temperature data from weather.txt
 * includes a computeByList method that compares the list of temperatures to a lowsList of the CityLowTempStats
 * if the city is not in the list it adds the city and determines the low and calucates the number of days below freezing.
 */


public class WeatherReport {
    private LinkedList<Temperature> temps;

    // No-parameter constructor for test data
    public WeatherReport() {
        temps = new LinkedList<>();

        temps.add(new Temperature("Kansas City", "Missouri", 32));
        temps.add(new Temperature("Phoenix", "AZ", 55));
        temps.add(new Temperature("Chicago", "IL", 27));
        temps.add(new Temperature("Miami", "FL", 60));
        temps.add(new Temperature("Denver", "CO", 28));
        temps.add(new Temperature("Dallas", "TX", 50));
        temps.add(new Temperature("Seattle", "WA", 40));
        temps.add(new Temperature("Boston", "MA", 35));
        temps.add(new Temperature("San Diego", "CA", 58));
        temps.add(new Temperature("Las Vegas", "NV", 47));
    }

    /* 
    public WeatherReport(String fileName) throws FileNotFoundException
    {
        temps = new LinkedList<>();

        File file = new File(fileName);
        Scanner input = new Scanner(file);
        //skip the header line.
        if (input.hasNextLine())
        {
            input.nextLine();
        }
        //read data lines
        while(input.hasNextLine())
        {
            String line = input.nextLine();
            String[] part = line.split(",");

            String city = part[1];
            String state = part[10];
            int low = Integer.parseInt(part[6]);

            temps.add(new Temperature(city, state, low));
        }
        input.close();
    }
        */

    public LinkedList<Temperature> getTemps()
    {
        return temps;
    }

    public LinkedList<CityLowTempStats> computeByList(){
        LinkedList<CityLowTempStats> lowsList= new LinkedList<>();
        for (Temperature t : temps)
        {
            boolean found = false;

            //add any new lows or increment the number of days freezing for existing cities in lowsList
            for (CityLowTempStats cl : lowsList)
            {
                if (cl.getCity().equals(t.getCity()))
                {
                    if (t.getLow() < cl.getLow())
                    {
                        cl.setNewLow(t.getLow());
                    }
                    if (t.getLow() < 33)
                    {
                        cl.incrementDaysBelowFreezing();
                    }
                    found = true;
                    break;
                }
            }

            //add cities not already in the list and calculate if the the entry was below freezing
            if (!found)
            {
                int daysBelowFreezing = (t.getLow() < 33) ? 1 : 0;
                CityLowTempStats newStat = new CityLowTempStats
                (
                    t.getCity(),
                    t.getState(),
                    t.getLow(),
                    daysBelowFreezing
                );
                lowsList.add(newStat);
            }
            
        }
        return lowsList;
    }

    //Tree Map Code
    public TreeMap<String, CityLowTempStats> computeByTree()
    {
        //create a new TreeMap of the CityLowTempStats
        TreeMap<String, CityLowTempStats> cityLowMap = new TreeMap<>();

        for(Temperature t : temps)
        {
            //update any new lows and add any days freezing
            if (cityLowMap.containsKey(t.getCity()))
            {
                CityLowTempStats cl = cityLowMap.get(t.getCity());
                if(t.getLow() < cl.getLow())
                {
                    cl.setNewLow(t.getLow());
                }
                if(t.getLow() < 33)
                {
                    cl.incrementDaysBelowFreezing();
                }
            }
            //add any new cities to the cityLowMap and determine the low and if it was freezing
            else
            {
                int daysBelowFreezing = (t.getLow() < 33) ? 1 : 0;
                CityLowTempStats newStats = new CityLowTempStats
                (
                    t.getCity(),
                    t.getState(),
                    t.getLow(),
                    daysBelowFreezing
                );

                cityLowMap.put(t.getCity(), newStats);
            }
        }
        return cityLowMap;
    }


}