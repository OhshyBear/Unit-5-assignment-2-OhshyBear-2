import java.io.FileNotFoundException;
/**
 * @author Trevor Huddleston
 * Put your name and date and description here.
 */
public class WeatherDriver {

	public static void main(String[] args) {
		System.out.println("Starting simulation");

		WeatherReport report = new WeatherReport(); // runs your constructor

    // Print each Temperature object to confirm it loaded correctly
    for (Temperature t : report.temps) {
        System.out.println(t.getCity() + ", " + t.getState() +
                           " | Low: " + t.getLow() +
                           " | High: " + t.getHigh() +
                           " | Diff: " + t.differential());
    }
		/*
		String fileName = "weather.txt";
		try { 
			WeatherReport wr = new WeatherReport(fileName);
			System.out.println(wr.isSortedByCity());			
		} 
		catch (FileNotFoundException e ) {
			System.out.println("Can't find file " + fileName); 
		}
		catch (Exception e) {
			System.out.println("Other error: " + e.getMessage());
		}
		*/
		System.out.println("Finished simulation");
	}

}
