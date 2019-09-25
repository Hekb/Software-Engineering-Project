
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import main.FlightMap;

public class TestFlightMap {
	
	//Junit to test the constructor
	@Test
	public void constructorTest() {
	    FlightMap map = new FlightMap();
	    boolean isIntialized = (map.cities.size() == 0);
	    assertEquals(true, isIntialized);
	}
	
	//Junit to test readCities
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
	
	//Junit to test placeEdges
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
	//End of PlaceEdge Tests
	
	//Junit to test ComputeRoutes 
	@Test
	public void computeRoutesTest1() {
	    FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P W 200");
	    map.readCities("W X 232");
	    map.placeEdges();
	    map.computeRoutes();
	    assertEquals(null,map.routes[0]);
	}
	@Test
	public void computeRoutesTest2() {
	    FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P W 200");
	    map.readCities("W X 232");
	    map.placeEdges();
	    map.computeRoutes();
	    assertEquals("P,W",map.routes[1]);
	}
	@Test
	public void computeRoutesTest3() {
	    FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P W 200");
	    map.readCities("W X 232");
	    map.placeEdges();
	    map.computeRoutes();
	    assertEquals("P,W,X",map.routes[2]);
	}
	@Test
	public void computeRoutesTest4() {
	    FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P W 200");
	    map.readCities("W X 232");
	    map.readCities("P Y 232");
	    map.placeEdges();
	    map.computeRoutes();
	    assertEquals("P,Y",map.routes[3]);
	}
	//End of computeroutes Tests
	
	//Junit for findAllRoutes
	@Test
	public void findAllRoutesTest1() {
	    FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P M 200");
	    map.readCities("M N 232");
	    map.readCities("N Y 232");
	    map.placeEdges();
	    int[] temp = new int[3];
	    map.visited = new boolean[3];
	    map.routes = new String[3];
	    map.findAllRoutes(0, 2, temp, 0);
	    assertEquals("P,M,N",map.routes[2]);
	}
	//End of findAllRoutes Tests
	
	//Junit for computeCost function
	@Test
	public void computeCostTest1() {
	    FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P W 2");
	    map.readCities("W X 232");
	    map.placeEdges();
	    map.computeRoutes();
	    map.computeCosts();
	    assertEquals(0,map.costs[0]);
	}
	@Test
	public void computeCostTest2() {
	    FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P W 150");
	    map.readCities("W X 302");
	    map.placeEdges();
	    map.computeRoutes();
	    map.computeCosts();
	    assertEquals(150,map.costs[1]);
	}
	@Test
	public void computeCostTest3() {
	    FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P W 3");
	    map.readCities("W X 9");
	    map.placeEdges();
	    map.computeRoutes();
	    map.computeCosts();
	    assertEquals(12,map.costs[2]);
	}
	//End of ComputeCostTest Tests
	
	
	//Junit the get methods
	@Test
	public void getCityTest1() {
		FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P M 200");
	    assertEquals("P", map.getCity(0));
	}
	@Test
	public void getCityTest2() {
		FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P R 100");
	    map.readCities("M N 632");
	    assertEquals("R", map.getCity(1));
	}
	//End of getCity Tests
	

	//Junit the howManycities get methods
	@Test
	public void howManyCitiesTest1() {
		FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P M 200");
	    map.readCities("N M 230");
	    map.readCities("X R 230");
	    map.readCities("U I 220");
	    map.readCities("P V 100");
	    map.readCities("P B 600");
	    map.readCities("S E 670");
	    assertEquals(12, map.howManycities() + 1);
	}
	@Test
	public void howManyCitiesTest2() {
		FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P R 100");
	    map.readCities("M N 632");
	    map.readCities("S E 670");
	    map.readCities("P V 100");
	    assertEquals(8, map.howManycities() + 1);
	}
	//End of howManyCities Tests
	
	//Junit getRouteCosts get method
	@Test
	public void getRouteCostsTest1() {
		FlightMap map = new FlightMap();
	    map.readCities("P");
	    map.readCities("P R 100");
	    map.readCities("R N 632");
	    map.readCities("S E 620");
	    map.readCities("P V 104");
	    map.placeEdges();
	    map.computeRoutes();
	    map.computeCosts();
	    assertEquals(100, map.getRouteCosts(1));
	}
	@Test
	public void getRouteCostsTest2() {
		FlightMap map = new FlightMap();
		map.readCities("P");
	    map.readCities("P R 100");
	    map.readCities("R N 343");
	    map.readCities("S E 222");
	    map.placeEdges();
	    map.computeRoutes();
	    map.computeCosts();
	    assertEquals(443, map.getRouteCosts(2));
	}
	//End of getRouteCosts Tests
	
	//Junit getRoutes method
	@Test
	public void getRoutesTest1() {
		FlightMap map = new FlightMap();
		map.readCities("P");
	    map.readCities("P R 100");
	    map.readCities("X Q 143");
	    map.readCities("M N 673");

	    map.placeEdges();
	    map.computeRoutes();
	    map.computeCosts();
	    String[] paths = {null, "P,R", null, null};
	    assertEquals(paths[3], map.getRoutes()[3]);
	}
	@Test
	public void getRoutesTest2() {
		FlightMap map = new FlightMap();
		map.readCities("P");
	    map.readCities("P R 100");
	    map.readCities("R X 743");
	    map.readCities("S E 1222");
	    map.readCities("M N 33");
	    map.readCities("C Q 22");
	    map.placeEdges();
	    map.computeRoutes();
	    map.computeCosts();
	    String[] paths = {null, "P,R", "P,X", null, null, null};
	    assertEquals(paths[1], map.getRoutes()[1]);
	}
	//End of getRoutesTest Tests
	
}
