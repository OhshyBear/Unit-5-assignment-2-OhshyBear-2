import java.io.FileNotFoundException;
import java.util.LinkedList;
/**
 * @author Trevor Huddleston
 * Put your name and date and description here.
 */
public class WeatherDriver {

	public static void main(String[] args) {
		System.out.println("Starting simulation");
		WeatherReport wr = new WeatherReport();
		LinkedList<CityLowTempStats> lowsReport = wr.computeByList();
		for(CityLowTempStats cl : lowsReport)
		{
			System.out.println(cl);
		}

        /* 
		String fileName = "weather.txt";
		try { 
			// Step 7: Create 4 WeatherReport objects with identical data
            WeatherReport wr1 = new WeatherReport(fileName);
            WeatherReport wr2 = new WeatherReport(fileName);
            WeatherReport wr3 = new WeatherReport(fileName);
            WeatherReport wr4 = new WeatherReport(fileName);
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
