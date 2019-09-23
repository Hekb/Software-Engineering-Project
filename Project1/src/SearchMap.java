import java.io.FileReader;
import java.util.Scanner;

public class SearchMap {

	public static void main(String args[]) {
		SearchMap s = new SearchMap();
		s.readFile();
		

	}
	public void readFile() {
		String fileName = "file.txt";
		try {

			FileReader fr = new FileReader(fileName);
			Scanner s = new Scanner(fr);
			FlightMap obj = new FlightMap();
			while(s.hasNextLine()) {
				obj.readCities(s.nextLine());			
			}
			obj.placeEdges();
			obj.computeRoutes();
		}catch(Exception e) {
			System.out.println("File Does not Exists");
		}
	}
}
