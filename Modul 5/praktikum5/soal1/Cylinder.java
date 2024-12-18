package praktikum5.soal1;

public class Cylinder extends Shape{
	private double radius;
	private double height;
	
	public Cylinder(double r, double h) {
		super("Cylinder");
		this.radius = r;
		this.height = h;
	}

	@Override
	public double area() {
		return Math.PI * radius * radius * height;
	}
	
	public String toString() {
		return super.toString() + " of radius " + radius + " and height " + height;
	}
	
	public void setRadius(double r) {
		this.radius = r;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setHeight(double h) {
		this.height = h;
	}
	
	public double getHeight() {
		return height;
	}
}