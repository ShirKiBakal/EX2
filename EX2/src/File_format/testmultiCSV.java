package File_format;

import java.io.IOException;

import GIS.GISProject;

public class testmultiCSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiCSV multi = new MultiCSV();
		GISProject project = new GISProject();
		multi.readfiles("C:\\Users\\shiran.b\\Downloads\\Ex2\\Ex2\\data");
		try {
		project = multi.buildProject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			KmlWriter kmlwriter = new KmlWriter("C:\\Users\\shiran.b\\Downloads\\Ex2\\Ex2\\data\\123.kml");
			kmlwriter.writeStringToKML(project);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
