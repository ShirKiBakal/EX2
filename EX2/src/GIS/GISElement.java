package GIS;

import Geom.Geom_element;
import Geom.Point3D;

public class GISElement implements GIS_element{

	MetaData md; 
	Point3D p; 
	String arr[];
	
	public GISElement(String str)
	{
		arr=str.split(",");
		p = new Point3D(Double.parseDouble(arr[6]),Double.parseDouble(arr[7]),Double.parseDouble(arr[8]));
		md = new MetaData(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[9],arr[10]);
	}
	
	@Override
	public Geom_element getGeom() {
	//TODO 	
		return null;
	}

	@Override
	public Meta_data getData() {
		return md;
		
	}

	@Override
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub
		
	}

}
