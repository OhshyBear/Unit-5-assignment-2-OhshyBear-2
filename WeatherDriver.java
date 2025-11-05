import java.io.FileNotFoundException;
/**
 * @author Trevor Huddleston
 * Put your name and date and description here.
 */
public class WeatherDriver {

	public static void main(String[] args) {
		System.out.println("Starting simulation");
		
		String fileName = "weather.txt";
		try { 
			WeatherReport wr = new WeatherReport(fileName);
			System.out.println(wr.isSortedByCity());
			System.out.println(wr.isSortedByHigh());	
			
			long startTime = System.nanoTime();
            wr.sortWithCollections("City");
            long endTime = System.nanoTime();
            System.out.println("\nCollections.sort() by City time: " + (endTime - startTime) + " ns");
            System.out.println("wr sorted by city? " + wr.isSortedByCity());

			long highStartTime = System.nanoTime();
			wr.sortWithCollections("High");
			long highEndTime = System.nanoTime();
			System.out.println("\nCollections.sort() by High time: " + (endTime - startTime) + " ns");
			System.out.println("wr sorted by High? " + wr.isSortedByHigh());
			
		} 
		catch (FileNotFoundException e ) {
			System.out.println("Can't find file " + fileName); 
		}
		catch (Exception e) {
			System.out.println("Other error: " + e.getMessage());
		}
		
		System.out.println("Finished simulation");
	}

}
