package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.FlightMap;

public class TestFlightMap {
	
	//Methods to test readCities
	@Test
	public void readCitiesTest1() {
	    FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P W 200");
	    map.readCities("W X 232");
	    int cityNumbers = map.howManycities();
	    assertEquals(3, cityNumbers);
	}
	@Test
	public void readCitiesTest2() {
	    FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P W 200");
	    map.readCities("W X 232");
	    map.readCities("Y Z 232");
	    map.readCities("H J 232");
	    int cityNumbers = map.howManycities();
	    assertEquals(7, cityNumbers);
	}
	//End of readCities test
	
	//Methods to test placeEdges
	@Test
	public void placeEdgesTest1() {
	    FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P W 200");
	    map.readCities("W X 232");
	    map.placeEdges();
	    assertEquals(1,map.adj_matrix[0][1]);
	    assertEquals(0,map.adj_matrix[0][2]);
	}
	
	//Test the get methods
	@Test
	public void getCityCost1() {
		FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P W 200");
	    map.readCities("W X 232");
	    assertEquals("P", map.getCity(0));
	}
	@Test
	public void getCityCost2() {
		FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P W 200");
	    map.readCities("W X 232");
	    assertEquals("W", map.getCity(1));
	}
	
}
