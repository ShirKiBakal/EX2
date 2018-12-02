package GIS;

import java.util.Date;

import Geom.Point3D;

/**
 * This implement the special characteristics of a 3dPoint
 * @author Shiran.b
 *
 */
public class MetaData implements Meta_data{

	private String MAC;
	private String SSID;
	private String AuthMode;
	private String FirstSeen;
	private String Channel;
	private String RSSI;
	private long time;
	private String AccuracyMeters;
	private String Type;
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	public String getMAC() {
		return MAC;
	}

	public void setMAC(String mAC) {
		MAC = mAC;
	}

	public String getSSID() {
		return SSID;
	}

	public void setSSID(String sSID) {
		SSID = sSID;
	}

	public String getAuthMode() {
		return AuthMode;
	}

	public void setAuthMode(String authMode) {
		AuthMode = authMode;
	}

	public String getFirstSeen() {
		return FirstSeen;
	}

	public void setFirstSeen(String firstSeen) {
		FirstSeen = firstSeen;
	}

	public String getChannel() {
		return Channel;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public String getRSSI() {
		return RSSI;
	}

	public void setRSSI(String rSSI) {
		RSSI = rSSI;
	}

	public String getAccuracyMeters() {
		return AccuracyMeters;
	}

	public void setAccuracyMeters(String accuracyMeters) {
		AccuracyMeters = accuracyMeters;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	
	/**
	 * Constracor, must get all data from CSV file row
	 * @param m
	 * @param s
	 * @param a2
	 * @param f
	 * @param c
	 * @param r
	 * @param a3
	 * @param t
	 */
	public MetaData(String m,String s,String a2,String f,String c,String r, String a3, String t)
	{
		MAC=m;
		SSID=s;
		AuthMode=a2;
		FirstSeen=f;
		Channel=c;
		RSSI=r;
		AccuracyMeters=a3;
		Type=t;
		time=this.getUTC();
		
	}


	/**
	 * get "long" format representation of the UTC time now.
	 */
	public long getUTC() {
		Long time = new Date().getTime();
		return time;
	}

	@Override
	public Point3D get_Orientation() {
		return null;
	}
}
