package main;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SearchMap {

	static FlightMap obj;

	/**
	 * This is the main method which will will read the data and parse to generate
	 * the graph and then call the method to output the results
	 * 
	 * @param args[] the filename which containts the data and the output file name
	 */
	public static void main(String args[]) {
		SearchMap s = new SearchMap();
		obj = new FlightMap();

		// The input file and output file
		String fileName = "../" + args[0];
		String outputfile = "../" + args[1];

		// Reads the file and sends the data
		// line by line to the FlightMap
		try {
			FileReader fr = new FileReader(fileName);
			Scanner sc = new Scanner(fr);
			while (sc.hasNextLine()) {
				obj.readCities(sc.nextLine());
			}
			obj.placeEdges();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Computes the routes and the costs
		obj.computeRoutes();
		obj.computeCosts();
		writeToFile(outputfile);
	}

	/**
	 * This method writes the final data which is all the routes reachable with the
	 * cost
	 * 
	 * @param outputfile is the file the user wants to output the data to
	 */
	public static void writeToFile(String outputfile) {
		// Write to a file
		try {
			String[] routesComputed = obj.getRoutes();
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile));
			String m = String.format("%-20s %-20s %-20s", "Destination", "Flight Route from P", "Total Cost");
			writer.write(m);
			for (int i = 0; i < routesComputed.length; i++) {
				if (routesComputed[i] != null) {
					writer.newLine();
					String des = obj.getCity(i);
					String route = routesComputed[i];
					int routeCost = obj.getRouteCosts(i);
					String st = String.format("%-20s %-20s %-20s", des, route, routeCost);
					writer.write(st);
				}
			}
			writer.close();
		} catch (IOException o) {
			System.out.println(o.getMessage());
		}
	}
}
