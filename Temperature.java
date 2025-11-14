/**
 * @author Trevor Huddleston
 *
 * My statistic is will count the number of days recorded below freezing as well as the lowest temperature recorded for that city 
 */
public class Temperature {
    private String city;
    private String state;
    private int low;

    // Empty constructor 
    public Temperature() {
    }

    // Constructor with parameters
    public Temperature(String city, String state, int low) {
        this.city = city;
        this.state = state;
        this.low = low;
    }

    // Returns the positive difference between high and low
    public int differential() {
        return Math.abs(high - low);
    }

    // Getters (will be used for sorting later)
    public String getCity() { return city; }
    public String getState() { return state; }
    public int getLow() { return low; }

	@Override
	public String toString() {
    	return city + ", " + state + " | Lowest temperature: " + low;
	}
	
	/* Add appropriate instance attributes, constructors, and accessor/mutator methods */
}
