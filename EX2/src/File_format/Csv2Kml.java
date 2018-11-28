package File_format;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Csv2Kml {
	private final BufferedWriter writer;
	private final BufferedReader reader;

	public Csv2Kml(String input, String output)throws IOException
	{
		reader = new BufferedReader(new FileReader(input));
		writer = new BufferedWriter(new FileWriter(output));
	}
	public void run() throws IOException {
		try {
			reader.readLine(); // skip 1st line
			String str = reader.readLine();
			String[] headers = str.split(",");
			//String[] parsedTime = headers[1].split(":");
			//int lastHour = Integer.parseInt(parsedTime[0].trim());
			//int lastMinute = Integer.parseInt(parsedTime[1].trim());

			//String hh = getHH(headers[1]);
			//writeIcon(hh, headers[3], headers[2]);
			//writePlacemarkStart(hh);
			//writer.write(headers[3] + "," + headers[2] + ", 0.0\n");
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			writer.write("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>");
			while ((str = reader.readLine()) != null)
			{
				String[] current_line = str.split(",");
				String MAC = current_line[0];
				String ssid = current_line[1];
				String AuthMode = current_line[2];
				String FirstSeen = current_line[3];
				String Channel = current_line[4];
				String RSSI = current_line[5];
				String CurrentLatitude = current_line[6];
				String CurrentLongitude = current_line[7];
				String AltitudeMeters = current_line[8];
				String AccuracyMeters = current_line[9];
				String Type = current_line[10];
				writer.write("<Placemark>\n");
				writer.write("<name>"+"<![CDATA["+ssid+"]]>"  +"</name>\n");
				writer.write("<description>"+"<![CDATA[BSSID: <b>"+MAC+"</b><br/>Capabilities: <b>"+AuthMode+"</b><br/>Date: <b>"+FirstSeen+"</b>]]>"+"</description><styleUrl>#red</styleUrl>\n");
				writer.write("<Point>\n");
				writer.write("<coordinates>"+CurrentLongitude+","+CurrentLatitude+"</coordinates></Point>\n");
				writer.write("</Placemark>");
			}
			writer.write("</Folder>\n");
			writer.write("</Document></kml>");
		} 
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			if (reader != null)
			{
				try
				{
					reader.close();
				} finally
				{
					if (writer != null)
					{
						writer.close();
					}
				}
			} else
			{
				if (writer != null)
				{
					writer.close();
				}
			}
		}
	}
}

