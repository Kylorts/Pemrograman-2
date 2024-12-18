package praktikum5.soal1;

public abstract class Shape {
	protected String shapeName;


	public Shape(String shapeName) {
		setShape(shapeName);
	}
	
	protected abstract double area();
	
	public String toString() {
		return shapeName;
	}
	
	public void setShape(String shapeName) {
		this.shapeName = shapeName;
	}	
}