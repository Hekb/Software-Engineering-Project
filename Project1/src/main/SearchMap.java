package main;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SearchMap {
	
	FlightMap obj;
	
	/**
	   * This is the main method which will invoke the methods to read the data
	   * and parse to generate the graph and then call the method to output the results
	   * @param args[] the filename which containts the data and the output file name
	   */
	public static void main(String args[]) {
		SearchMap s = new SearchMap();
		s.readFile("../" + args[0]);
		s.computeRoutes();
		s.writeToFile("../" + args[1]);
	}
	/**
	   * This is the constructor which creates a FlightMap object.
	   */
	public SearchMap() {
		obj = new FlightMap();
	}
	
	/**
	   * This method reads file content and sends it over to
	   * the FlightMap object to create the graph
	   * @param filename This is the data filename
	   */
	public void readFile(String filename) {
		String fileName = filename;
		try {
			FileReader fr = new FileReader(fileName);
			Scanner s = new Scanner(fr);
			while(s.hasNextLine()) {
				obj.readCities(s.nextLine());			
			}
			obj.placeEdges();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	   * This method calls the FlightMap object to
	   * compute the routes reachable.
	   */
	public void computeRoutes() {
		obj.computeRoutes();
		obj.computeCosts();	
	}
	
	/**
	   * This method writes the final data which is all the routes
	   * reachable with the cost
	   * @param outputfile is the file the user wants to output the data to
	   */
	public void writeToFile(String outputfile) {
		
		//Write to a file
		try {
			String[] routesComputed = obj.getRoutes();
		    BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile));
		    writer.write("Destination       Flight Route from P       Total Cost");
		    for(int i = 0; i < routesComputed.length; i++) {
				if(routesComputed[i] != null) {
					writer.newLine();
					String des = obj.getCity(i);
					String route = routesComputed[i];
					int routeCost = obj.getRouteCosts(i);
					writer.write(des + "       " + route + "       " + routeCost);
				}
			}
		     
		    writer.close();
		}catch(IOException o) {
			System.out.println(o.getMessage());
		}
	
	}
}
