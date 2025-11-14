import java.io.File;
import java.util.Collections;
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

            temps.add(new Temperature(city, state, low));
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

    public boolean isSortedByHigh(){
        for (int i = 0; i< temps.size() - 1; i++){
            if(temps.get(i).getHigh() < temps.get(i + 1).getHigh())
                return false;
        }
        return true;
    }

    public void sortWithCollections(String by) {
        if (by.equalsIgnoreCase("City")) {
            Collections.sort(temps, Comparator.comparing(Temperature::getCity));
        } 
        else if (by.equalsIgnoreCase("High")) {
            Collections.sort(temps, Comparator.comparingInt(Temperature::getHigh).reversed());
        } 
        else {
            System.out.println("Unknown sort key: " + by);
        }
    }

    public void sortWithMerge(String by) {
    temps = mergeSort(temps, by);
}

private LinkedList<Temperature> mergeSort(LinkedList<Temperature> list, String by) {
    if (list.size() <= 1) return list;

    int mid = list.size() / 2;
    LinkedList<Temperature> left = new LinkedList<>(list.subList(0, mid));
    LinkedList<Temperature> right = new LinkedList<>(list.subList(mid, list.size()));

    left = mergeSort(left, by);
    right = mergeSort(right, by);

    return merge(left, right, by);
}

private LinkedList<Temperature> merge(LinkedList<Temperature> left, LinkedList<Temperature> right, String by) {
    LinkedList<Temperature> merged = new LinkedList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            Temperature l = left.peek();
            Temperature r = right.peek();
            boolean takeLeft = false;

            if (by.equalsIgnoreCase("City")) {
                // Ascending order for city
                takeLeft = l.getCity().compareTo(r.getCity()) <= 0;
            } 
            else if (by.equalsIgnoreCase("High")) {
                // Descending order for high temperature
                takeLeft = l.getHigh() >= r.getHigh();
            }

            if (takeLeft) {
                merged.add(left.poll());
            } else {
                merged.add(right.poll());
            }
        }

        // Add remaining elements
        merged.addAll(left);
        merged.addAll(right);

        return merged;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Temperature t : temps) {
            sb.append(t.getCity())
                .append(", ")
                .append(t.getState())
                .append(" | High: ")
                .append(t.getHigh())
                .append(" Low: ")
                .append(t.getLow())
                .append("\n");
        }
        return sb.toString();
    }

}