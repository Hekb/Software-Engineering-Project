package main;




import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FlightMap {
	/**
	 * LinkedList to store the cities using their indicies in the LL
	 */
	public LinkedList<String> cities;
	/**
	 * Adjacent matrix to store the edges
	 */	
	public int[][] adj_matrix;
	/**
	 * Matrix to store the edge costs
	 */
	public int[][] cost;
	/**
	 * Array used to check if a node is visited during the traversal to find all routes
	 */
	public boolean[] visited;
	/**
	 * The final output which is all the routes reachable
	 */
	public String[] routes;
	/**
	 * The cost of x index in routes[] is stored here
	 */
	public int[] costs;
	/**
	 * Temp variable used to store the content
	 */
	String temp2 = new String();

	/**
	   * Constructor which intialize the city linked list
	   */
	public FlightMap() {
		cities = new LinkedList<String>();
	}
	
	
	/**
	   * This method parse line by line of the data
	   * which is called from the SearchMap.java
	   * @param content The data of the graph
	   */
	public void readCities(String content) {
		//Get Cities
		String[] temp = content.split(" ");
		if(temp.length == 1) {
			cities.add(temp[0]);
		}else {
			temp2 = temp2 + content + "\n";
			if(!cities.contains(temp[0])) {
				cities.add(temp[0]);
			}
			if(!cities.contains(temp[1])) {
				cities.add(temp[1]);
			}
		}			
	}
	
	/**
	   * After storing the destinations this methods places the edges
	   * on the adj_matrix[][]
	   */
	public void placeEdges() {
		adj_matrix = new int[cities.size()][cities.size()];
		cost = new int[cities.size()][cities.size()];

		for(int i = 0; i < adj_matrix.length; i++) {
			for(int j = 0; j < adj_matrix.length; j++) {
				adj_matrix[i][j] = 0;
			}
		}
		String[] content = temp2.split("\n");
		for(int i = 0; i < content.length; i++) {
			String[] c = content[i].split(" ");
			int index1 = cities.indexOf(c[0]);
			int index2 = cities.indexOf(c[1]);
			adj_matrix[index1][index2] = 1;
			cost[index1][index2] = Integer.parseInt(c[2]);
		}
	}
	
	/**
	   * After placing the edges this methods computes the routes reachable.
	   * It checks on all the nodes to see which are reachable using
	   * the backtracking method (findPath).
	   */
	public void computeRoutes() {
		//Path
	    int[] temp;
	    routes = new String[cities.size()];
	    
	    for(int i = 1; i < cities.size(); i++) {
	    	//Reset the temp path
	    	temp = new int[cities.size()];
	    	//Reset the visited nodes value
			visited = new boolean[cities.size()];	
	    	findPath(0, i, temp, 0);
	    }
	    
	 }
	
	
	/**
	   * Backtracking method to find all reachable destinations
	   * @param src the source node
	   * @param target the target node
	   * @param path[] temp array to store the path found
	   * @param ctr counter used for the algorithm
	   */
	public void findPath(int src, int target, int path[], int ctr) {
		visited[src] = true;
		path[ctr] = src;
		ctr++;
		//Path found
		if(src == target) {
			routes[target] = new String();
			for(int i = 0; i < ctr; i++) {
				if(i == 0) {
					routes[target] = cities.get(path[i]);
				}else {
					routes[target] = routes[target] + "," + cities.get(path[i]);
				}
			}
			return;
		}else {
			for(int i =0; i < cities.size(); i++) {
				if(adj_matrix[src][i] == 1) {
					if(!visited[i]) {
						findPath(i,target,path,ctr);
					}
				}
			}
		}
		ctr--;
		visited[src] = false;
	}
	/**
	   * After the routes are found this methods computers each route cost.
	   */
	public void computeCosts() {
		this.costs = new int[cities.size()];
		for(int i = 1; i < routes.length; i++) {
			if(routes[i] != null) {
				String[] cities = routes[i].split(",");
				int cost = 0;
				for(int j = 0; j < cities.length; j++) {
					if(j  == (cities.length - 1)) {
						continue;
					}else {
						int index1 = this.cities.indexOf(cities[j]);
						int index2 = this.cities.indexOf(cities[j + 1]);
						cost = cost + this.cost[index1][index2];
						this.costs[i] = cost;
					}
				}
			}
		}
	}
	
	/**
	   * Get method which returns the cost of a route index T
	   * @param index the route which we want to find out the cost of
	   */
	public int getRouteCosts(int index) {
		return this.costs[index];
	}
	/**
	   * Get method which returns all of the routes found
	   */
	public String[] getRoutes() {
		return this.routes;
	}
	/**
	   * Get method to get the city string based on the index value in the LL
	   * @param index the index of the city
	   */
	public String getCity(int index) {
		return this.cities.get(index);
	}
	/**
	   * Get method which returns how many cities the graph has
	   */
	public int howManycities() {
		return this.cities.size();
	}
}
