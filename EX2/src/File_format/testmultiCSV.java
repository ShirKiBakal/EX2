package File_format;

import java.io.IOException;

import GIS.GISProject;

public class testmultiCSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiCSV multi = new MultiCSV();
		multi.readfiles("C:\\Users\\shiran.b\\Downloads\\Ex2\\Ex2\\data");
		try {
			multi.buildProject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
