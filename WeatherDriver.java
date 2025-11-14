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
			// Step 7: Create 4 WeatherReport objects with identical data
            WeatherReport wr1 = new WeatherReport(fileName);
            WeatherReport wr2 = new WeatherReport(fileName);
            WeatherReport wr3 = new WeatherReport(fileName);
            WeatherReport wr4 = new WeatherReport(fileName);

            // Verify initial state (unsorted)
            System.out.println("Initial lists unsorted:");
            System.out.println("wr1 sorted by City? " + wr1.isSortedByCity());
            System.out.println("wr2 sorted by City? " + wr2.isSortedByCity());
            System.out.println("wr3 sorted by High? " + wr3.isSortedByHigh());
            System.out.println("wr4 sorted by High? " + wr4.isSortedByHigh());

            // Sort wr1 with Collections.sort() by City
            long startTime = System.nanoTime();
            wr1.sortWithCollections("City");
            long endTime = System.nanoTime();
            System.out.println("\nCollections.sort() by City time: " + (endTime - startTime) + " ns");
            System.out.println("wr1 sorted by City? " + wr1.isSortedByCity());

            // Sort wr2 with merge sort by City
            startTime = System.nanoTime();
            wr2.sortWithMerge("City");
            endTime = System.nanoTime();
            System.out.println("Merge sort by City time: " + (endTime - startTime) + " ns");
            System.out.println("wr2 sorted by City? " + wr2.isSortedByCity());

            // Sort wr3 with Collections.sort() by High
            startTime = System.nanoTime();
            wr3.sortWithCollections("High");
            endTime = System.nanoTime();
            System.out.println("\nCollections.sort() by High time: " + (endTime - startTime) + " ns");
            System.out.println("wr3 sorted by High? " + wr3.isSortedByHigh());

            // Sort wr4 with merge sort by High
            startTime = System.nanoTime();
            wr4.sortWithMerge("High");
            endTime = System.nanoTime();
            System.out.println("Merge sort by High time: " + (endTime - startTime) + " ns");
            System.out.println("wr4 sorted by High? " + wr4.isSortedByHigh());
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
