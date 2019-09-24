import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FlightMap {
	//Storing the cities
	public LinkedList<String> cities;
	//Adjacent matrix for placing edges
	public int[][] adj_matrix;
	//Matrix for cost
	public int[][] cost;
	//Array used to check if a citiy was visited
	//when finding the routes
	public boolean[] visited;
	
	
	String[] routes;
	int[] costs;
	

	String temp2 = new String();

	//Constructor
	public FlightMap() {
		cities = new LinkedList<String>();

	}
	
	public static void main(String args[]) {
		
	}
	
	
	
	//Function that stores the cities in LinkedList
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
	
	//Places the edges 
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
		/*
		for(int i = 0; i < cities.size(); i++)
			System.out.print(cities.get(i) + " ");
		System.out.println();
		for(int i = 0; i < cost.length; i++) {
			for(int j = 0; j < cost.length; j++) {
				System.out.print(cost[i][j] + " ");
			}
			System.out.print("\n");
		}
		*/
		
	}
	
	//Computes the routes
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
	    computeCosts();	
	    }
	
	
	//Backtracking to find a path
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
	
	public int getRouteCosts(int index) {
		return this.costs[index];
	}
	//Get method to get all the routes computed
	public String[] getRoutes() {
		return this.routes;
	}
	//Get method to get the city based on the index value in the LL
	public String getCity(int index) {
		return this.cities.get(index);
	}
	public int howManycities() {
		return this.cities.size();
	}
}
