package GIS;

import Geom.Geom_element;
import Geom.Point3D;

/**
 * this class represent Gis Element, each element is a 3dPoint and her Metadata.
 * @author Shiran.b
 *
 */
public class GISElement implements GIS_element{

	private MetaData md; 
	private Point3D p; 
	private String arr[];
	
	public MetaData getMd() {
		return md;
	}

	public void setMd(MetaData md) {
		this.md = md;
	}

	public Point3D getP() {
		return p;
	}

	public void setP(Point3D p) {
		this.p = p;
	}

	public String[] getArr() {
		return arr;
	}

	public void setArr(String[] arr) {
		this.arr = arr;
	}
	
	/**
	 * the constractor, get a row from the CSV and split it to the right places
	 * @param str
	 */
	public GISElement(String str)
	{
		arr=str.split(",");
		p = new Point3D(Double.parseDouble(arr[6]),Double.parseDouble(arr[7]),Double.parseDouble(arr[8]));
		md = new MetaData(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[9],arr[10]);
	}
	
	@Override
	public Geom_element getGeom() {
		return (Geom_element)this;
	}


	public Meta_data getData() {
		return md;
		
	}

	public void translate(Point3D vec) {
		
	}

}
