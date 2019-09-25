
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import main.SearchMap;

public class TestSearchMap {
	//Junit to test the writeToFile
	@Test
	public void writeToFileTest() {
		SearchMap map = new SearchMap();
		try {
			String[] args = {"Project1/inputTest.txt", "Project1/outputTest.txt"};
			map.main(args);
			File file1 = new File("outputTest.txt");
	        File file2 = new File("outputTestChecker.txt");
	        //File readers to read the file
	        FileReader fileReader1 = new FileReader(file1);
	        FileReader fileReader2 = new FileReader(file2);
	        BufferedReader bufferReader1 = new BufferedReader(fileReader1);
	        BufferedReader bufferReader2 = new BufferedReader(fileReader2);

	        boolean same = true;
	        String temp1 = null;
	        String temp2 = null;
	       
	        while(     ((temp1 = bufferReader1.readLine()) != null)
	                && ((temp2 = bufferReader2.readLine()) != null) ) {
	        	if(!temp1.contentEquals(temp2)) {
	        		same = false;
	        		break;
	        	}
	        }
	        assertEquals(true,same);
		}catch(IOException io) {
			System.out.println(io.getMessage());
		}
	}
	//End of writeToFile Test
}
