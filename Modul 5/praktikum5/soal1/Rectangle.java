package praktikum5.soal1;

public class Rectangle extends Shape {
	private double length;
	private double width;
	
	public Rectangle(double l, double w) {
		super("Rectangle");
		this.length = l;
		this.width = w;
	}

	@Override
	public double area() {
		return length * width;
	}
	
	public String toString() {
		return super.toString() + " of length " + length + " and width " + width; 
	}
	
	public void setLength(double l) {
		this.length = l;
	}
	
	public double getLength() {
		return length;
	}
	
	public void setWidth(double w) {
		this.width = w;
	}
	
	public double getWidth() {
		return width;
	}
}