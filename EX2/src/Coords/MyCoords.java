package Coords;


import Geom.Point3D;

public class MyCoords implements coords_converter{

	private final int earth_radius = 6371000;

	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		double answerX=local_vector_in_meter.toDegrees(local_vector_in_meter.x());
		answerX+=local_vector_in_meter.fromRadian(answerX);
		answerX+=gps.disPoint(gps.x(), answerX);
		
		double answerY=local_vector_in_meter.toDegrees(local_vector_in_meter.y());
		answerY+=local_vector_in_meter.fromRadian(answerY);
		answerY+=gps.disPoint(gps.y(), answerY);
		
//		double answerZ=local_vector_in_meter.toDegrees(local_vector_in_meter.z());
//		answerZ+=local_vector_in_meter.fromRadian(local_vector_in_meter.z());
//		answerZ+=gps.disPoint(gps.z(), local_vector_in_meter.z());
		
		Point3D answer =new Point3D(answerX,answerY);
		return answer;
	
	}

	@Override
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

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		double x = Math.abs(gps0.x()-gps1.x());
		double y = Math.abs(gps0.y()-gps1.y());
		double z = Math.abs(gps0.z()-gps1.z());
		Point3D ans = new Point3D(x,y,z);
		return ans;
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		double[] arr = new double[3];
		arr[0] = gps0.north_angle(gps1);
		arr[1] = gps0.up_angle(gps1);
		arr[2]=this.distance3d(gps0, gps1);
		return arr;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		double x=p.x();
		double y=p.y();
		double z=p.z();
		
		if(x<-180||x>180)return false;
		if(y<-90||y>90)return false;
		if(z<-450)return false;
		
		return true;
	}

}


