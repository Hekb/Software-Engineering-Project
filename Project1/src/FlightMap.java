import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FlightMap {
	public LinkedList<String> cities;
	public int[][] adj_matrix;
	public int[][] cost;
	public boolean[] visited;

	String temp2 = new String();
	//Constructor
	public FlightMap() {
		cities = new LinkedList<String>();

	}
	
	public static void main(String args[]) {
		
	}
	
	
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
			cost[index1][index2] = 1;
		}
		/*
		for(int i = 0; i < cities.size(); i++)
			System.out.print(cities.get(i) + " ");
		System.out.println();
		for(int i = 0; i < adj_matrix.length; i++) {
			for(int j = 0; j < adj_matrix.length; j++) {
				System.out.print(adj_matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
		*/
		
	}
	public void computeRoutes() {
		for(int i = 0; i < adj_matrix.length; i++) {
			for(int j = 0; j < adj_matrix.length; j++) {
				if(adj_matrix[i][j] == 1) {
					//System.out.println(cities.get(i) + "->" + cities.get(j));
				}
			}
		}
		visited = new boolean[cities.size()];
	    int[] path = new int[cities.size()];
	    findPath(0, 5,path,0);
		//Queue<Integer> path = new ArrayDeque<>();
		//System.out.println(isConnected(0,2,path) + " " + path);
		
		



	}
	//Backtracking to find a path
	public void findPath(int src, int target, int path[], int ctr) {
		visited[src] = true;
		path[ctr] = src;
		ctr++;
		//Path found
		if(src == target) {
			for(int i = 0; i < ctr; i++) {
				System.out.println(cities.get(path[i]));
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
}
