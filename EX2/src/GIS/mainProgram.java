package GIS;

import java.io.IOException;

import File_format.CSVReader;

public class mainProgram {

	public static void main(String[] args) throws IOException {

		CSVReader csv = new CSVReader("C:\\Users\\Elyasaf\\Downloads\\‏‏תיקיה חדשה\\Ex2\\data\\WigleWifi_20171201110209.csv");
		System.out.println(csv.readFromCSV());
		
	}

}
