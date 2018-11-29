package File_format;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;


import GIS.GISElement;
import GIS.GISLayer;
import GIS.GISProject;
import GIS.GIS_element;
import GIS.GIS_layer;

public class KmlWriter {

	private final BufferedWriter writer;

	public KmlWriter(String output)throws IOException
	{
		writer = new BufferedWriter(new FileWriter(output));
	}

	public void writeStringToKML(GISProject project)
	{
		
		Iterator<GIS_layer> iter_layer = project.iterator();
	
		try
		{
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			writer.write("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\n");
			while(iter_layer.hasNext()){
				GISLayer layer_temp = (GISLayer)iter_layer.next();
				Iterator<GIS_element> iter_element = layer_temp.iterator();
				while(iter_element.hasNext())
				{
					GISElement elm = (GISElement)iter_element.next();
					writer.write("<Placemark>\n");
					writer.write("<TimeStamp>\n");
					writer.write("<when>"+elm.getMd().getUTC()+"</when>\n");
					writer.write("</TimeStamp>\n");
					writer.write("<name>"+"<![CDATA["+elm.getMd().getSSID()+"]]>"  +"</name>\n");
					writer.write("<description>"+"<![CDATA[BSSID: <b>"+elm.getMd().getMAC()+"</b><br/>Capabilities: <b>"+elm.getMd().getAuthMode()+"</b><br/>Channel: <b>"+elm.getMd().getChannel()+"</b><br/>RSSI: <b>"+elm.getMd().getRSSI()+"</b><br/>AltitudeMeters: <b>"+elm.getP().z()+"</b><br/>AccuracyMeters: <b>"+elm.getMd().getAccuracyMeters()+"</b><br/>Type: <b>"+elm.getMd().getType()+"</b><br/>Date: <b>"+elm.getMd().getFirstSeen()+"</b>]]>"+"</description><styleUrl>#red</styleUrl>\n");
					writer.write("<Point>\n");
					writer.write("<coordinates>"+elm.getP().y()+","+elm.getP().x()+"</coordinates></Point>\n");
					writer.write("</Placemark>\n");

				}
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
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
