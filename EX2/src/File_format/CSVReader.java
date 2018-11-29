package File_format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import GIS.GISElement;

public class CSVReader {
	private BufferedReader reader=null;

	public CSVReader(String input)
	{
		try{
		reader = new BufferedReader(new FileReader(input));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public ArrayList<GISElement> readFromCSV() throws IOException {
		try {
			reader.readLine(); // skip 1st line
			reader.readLine(); // skip 2nd line
			String str1; 
			ArrayList<GISElement> arr = new ArrayList<>();
			GISElement gis;
			while ((str1 = reader.readLine()) != null)
			{
				gis = new GISElement(str1);
				arr.add(gis);
			}
			return arr;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
