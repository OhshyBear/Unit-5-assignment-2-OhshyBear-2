import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.TreeMap;
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

		System.out.println();

		TreeMap<String, CityLowTempStats> treeLowsReport = wr.computeByTree();
		for (CityLowTempStats cl : treeLowsReport.values()){
			System.out.println(cl);
		}

         
		String fileName = "weather.txt";
		try { 
			// Step 7: Create 4 WeatherReport objects with identical data
            WeatherReport wrComputedByList = new WeatherReport(fileName);
            WeatherReport wrComputedByTreeMap = new WeatherReport(fileName);
		
			System.out.println();
			Long start = System.nanoTime();
			LinkedList<CityLowTempStats> lowsReportComputedByList = wrComputedByList.computeByList();
			Long end = System.nanoTime();
			for(CityLowTempStats cl : lowsReportComputedByList)
			{
				System.out.println(cl);
			}
			System.out.println("computeByList() run time: " + (end - start) + "ns");

			System.out.println();
			start = System.nanoTime();
			TreeMap<String, CityLowTempStats> lowsReportComputedByTree = wrComputedByTreeMap.computeByTree();
			end = System.nanoTime();
			for (CityLowTempStats cl : lowsReportComputedByTree.values())
			{
				System.out.println(cl);
			}
			System.out.println("computeByTree() run time: " + (end - start) + "ns");
		
		
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
