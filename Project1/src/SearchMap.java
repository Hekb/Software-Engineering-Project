import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SearchMap {
	
	FlightMap obj;
	public static void main(String args[]) {
		SearchMap s = new SearchMap();
		s.readFile();
		s.computeRoutes();
		s.writeToFile();

	}
	
	public SearchMap() {
		obj = new FlightMap();
	}
	public void readFile() {
		String fileName = "file.txt";
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
	public void writeToFile() {
		
		//Write to a file
		try {
			String[] routesComputed = obj.getRoutes();
		    BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
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
