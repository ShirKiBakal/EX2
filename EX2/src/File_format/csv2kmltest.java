package File_format;

import java.util.Arrays;

public class csv2kmltest {

	public static void main(String[] args) {
		String source_file ="C:\\Users\\shiran.b\\Downloads\\Ex2\\Ex2\\data\\123.csv";
		String ourput_file ="C:\\Users\\shiran.b\\Downloads\\Ex2\\Ex2\\data\\123.kml";
		try{
		Csv2Kml c2k = new Csv2Kml(source_file,ourput_file);
		c2k.run();
		String[] headres = c2k.getHeaders();
		System.out.println("headers are:"+Arrays.deepToString(headres));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
