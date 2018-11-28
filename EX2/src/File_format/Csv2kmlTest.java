package File_format;

import static org.junit.Assert.*;

import org.junit.Test;

public class Csv2kmlTest {

	Csv2kml c2k=new Csv2kml("C:\\Users\\Elyasaf\\Downloads\\‏‏תיקיה חדשה\\Ex2\\data\\WigleWifi_20171203085618.csv");
	
	@Test
	public void testFoo() {
		c2k.isFind();
		assertTrue(true);
		c2k.readCsv();
	}

}
