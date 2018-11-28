package Coords;

import static org.junit.Assert.*;

import org.junit.Test;

import Geom.Point3D;

public class MyCoordsTest {

	@Test
	public void test1()
	{
		MyCoords m = new MyCoords();
		Point3D p1 = new Point3D(32.103315,35.209039,670);
		Point3D p2 = new Point3D(337.6989921,-359.2492069,-20);

		Point3D p3 = m.add(p1, p2);
		System.out.println(p3);
	}
	

}
