/**
 * @author Trevor Huddleston
 * 11/14/2025
 * Temperature.Java takes raw data from weather.txt and returns the city state and low for each input.  
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

    // Getters 
    public String getCity() { return city; }
    public String getState() { return state; }
    public int getLow() { return low; }

	@Override
	public String toString() {
    	return city + ", " + state + " | Lowest temperature: " + low;
	}
}
