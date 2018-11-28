package File_format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Csv2kml {

	String name;

	public Csv2kml(String name) {

		this.name= name;
	}

	@SuppressWarnings("unchecked")
	public void readCsv()
	{
	
		String strArr[] = new String[11];
		ArrayList<String> MAC = new ArrayList<String>();
		ArrayList<String> SSID = new ArrayList<>();
		ArrayList<String> AuthMode = new ArrayList<>();
		ArrayList<String> FirstSeen = new ArrayList<>();
		ArrayList<String> Channel = new ArrayList<>();
		ArrayList<String> RSSI = new ArrayList<>();
		ArrayList<String> CurrentLatitude = new ArrayList<>();
		ArrayList<String> CurrentLongitude= new ArrayList<>();
		ArrayList<String> AltitudeMeters = new ArrayList<>();
		ArrayList<String> AccuracyMeters= new ArrayList<>();
		ArrayList<String> Type = new ArrayList<>();
		
		Object obj[] = new Object[11];
		obj[0]=MAC;
		obj[1]=SSID;
		obj[2]=AuthMode;
		obj[3]=FirstSeen;
		obj[4]=Channel;
		obj[5]=RSSI;
		obj[6]=CurrentLatitude;
		obj[7]=CurrentLongitude;
		obj[8]=AltitudeMeters;
		obj[9]=AccuracyMeters;
		obj[10]=Type;
		
		String str;
		try 
		{
			BufferedReader br = new BufferedReader (new FileReader(name));
			br.readLine();
			br.readLine();
			while ((str = br.readLine())!=null)
			{
//				System.out.println(str);
				strArr=str.split(",");
				for (int i = 0; i < obj.length; i++) {
					((ArrayList<String>) obj[i]).add(strArr[i]);
				}
//				MAC.add(strArr[0]);
//				SSID.add(strArr[1]);
				
				
			}







		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean isFind(){		

		String str= name.substring(0, 9);
		if(!str.equals("WigleWifi")) return false;
		String str1=name.substring(name.length()-3, name.length());
		if(!str1.equals("csv"))return false;
		return true;
	}
}

