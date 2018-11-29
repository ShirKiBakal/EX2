package File_format;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import GIS.GISElement;
import GIS.MetaData;
import Geom.Point3D;

public class CSVReader {
	private BufferedWriter writer=null;
	private BufferedReader reader=null;
	private String headers[]=null;

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

	public String[] getHeaders(){
		if(headers==null)
		{
			throw new RuntimeException("must excute \"run\" first!!");
		}
		return headers;
	}

	public void writeStringToKML(MetaData md,Point3D p)
	{


		try
		{
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			writer.write("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\n");
					writer.write("<Placemark>\n");
					writer.write("<name>"+"<![CDATA["+md.getSSID()+"]]>"  +"</name>\n");
					writer.write("<description>"+"<![CDATA[BSSID: <b>"+md.getMAC()+"</b><br/>Capabilities: <b>"+md.getAuthMode()+"</b><br/>Channel: <b>"+md.getChannel()+"</b><br/>RSSI: <b>"+md.getRSSI()+"</b><br/>AltitudeMeters: <b>"+p.z()+"</b><br/>AccuracyMeters: <b>"+md.getAccuracyMeters()+"</b><br/>Type: <b>"+md.getType()+"</b><br/>Date: <b>"+md.getFirstSeen()+"</b>]]>"+"</description><styleUrl>#red</styleUrl>\n");
					writer.write("<Point>\n");
					writer.write("<coordinates>"+p.y()+","+p.x()+"</coordinates></Point>\n");
					writer.write("</Placemark>\n");

			writer.write("</Folder>\n");
			writer.write("</Document></kml>");
			writer.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
