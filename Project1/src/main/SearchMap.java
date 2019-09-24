package main;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SearchMap {
	
	FlightMap obj;
	public static void main(String args[]) {
		SearchMap s = new SearchMap();
		s.readFile("../" + args[0]);
		s.computeRoutes();
		s.writeToFile("../" + args[1]);

	}
	
	public SearchMap() {
		obj = new FlightMap();
	}
	
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
	
	public void computeRoutes() {
		obj.computeRoutes();
	}
	
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
