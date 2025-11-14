public class CityLowTempStats {
    private String city;
    private String state;
    private int low;
    private int daysBelowFreezing;

/**
 * @author Trevor Huddleston
 * 11/14/2025
 * Created a class for my results data to be stored into from the Temperature Class
 */

    //Constructors
    public CityLowTempStats(){}

    public CityLowTempStats(String city, String state, int low, int daysBelowFreezing)
    {
        this.city = city;
        this.state = state;
        this.low = low;
        this.daysBelowFreezing = daysBelowFreezing;
    } 

    //setters for new Lows and days below freezing
    public void setNewLow(int low) { this.low = low; }
    public void incrementDaysBelowFreezing() { this.daysBelowFreezing++;}

    // getters
    public String getCity() { return city; }
    public String getState() { return state; }
    public int getLow() { return low; }
    public int getDaysBelowFreezing() { return daysBelowFreezing; }
    
    //override string to include the days below freezing
    @Override
	public String toString() 
    {
    	return city + ", " + state + " | Lowest Temperature: " + low + " | Days Below Freezing: " + daysBelowFreezing;
	}
}
