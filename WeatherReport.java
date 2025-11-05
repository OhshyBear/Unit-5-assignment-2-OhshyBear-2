import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Trevor Huddleston
 * Put your name and date and description here.
 */


public class WeatherReport {
    public LinkedList<Temperature> temps;

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
}