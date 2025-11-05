/**
 * @author Trevor Huddleston
 *
 * Stores low and high temperature data for a city/state 
 */
public class Temperature {
    private String city;
    private String state;
    private int low;
    private int high;

    // Empty constructor 
    public Temperature() {
    }

    // Constructor with parameters
    public Temperature(String city, String state, int low, int high) {
        this.city = city;
        this.state = state;
        this.low = low;
        this.high = high;
    }

    // Returns the positive difference between high and low
    public int differential() {
        return Math.abs(high - low);
    }

    // Getters (will be used for sorting later)
    public String getCity() { return city; }
    public String getState() { return state; }
    public int getLow() { return low; }
    public int getHigh() { return high; }

	@Override
	public String toString() {
    	return city + ", " + state + " | High: " + high + " Low: " + low;
	}
	
	/* Add appropriate instance attributes, constructors, and accessor/mutator methods */
}
