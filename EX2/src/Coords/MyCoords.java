package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter {
	
	final int earth_radius = 6371000;
	
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		gps.add(local_vector_in_meter);
		return gps;
	}

	public double distance3d(Point3D gps0, Point3D gps1) {
		double dist = 0;
		double dif_lat_rad = Math.toRadians(gps0.x()-gps1.x());
		double dif_lon_rad = Math.toRadians(gps0.y()-gps1.y());
		double dif_alt = gps0.z()-gps1.z();
		double lon_norm = Math.cos(Math.toRadians(gps0.x()));
		double dif_lat_meter = Math.sin(dif_lat_rad)*earth_radius;
		double dif_lon_meter = Math.sin(dif_lon_rad)*earth_radius*lon_norm;
		dist = Math.sqrt(dif_lat_meter*dif_lat_meter+dif_lon_meter*dif_lon_meter);
		return dist;
	}

	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isValid_GPS_Point(Point3D p) {
		// TODO Auto-generated method stub
		return false;
	}

}
