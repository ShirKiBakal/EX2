package Game;


public class PackMan {

	private double velocity; 
	private double radius; 
	private double x;
	private double y;	
	
	public double getVelocity() {
		return velocity;
	}


	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}


	public double getRadius() {
		return radius;
	}


	@Override
	public String toString() {
		return "PackMan [velocity=" + velocity + ", radius=" + radius + ", x=" + x + ", y=" + y + "]";
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	
	
	public PackMan(double v,double r,double x,double y){
		this.velocity=v;
		this.radius=r;
		this.x=x;
		this.y=y;
	}
	
	
}
