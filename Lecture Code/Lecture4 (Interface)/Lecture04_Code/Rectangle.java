
public class Rectangle implements Shapeable {

	private double width;
	private double height;

	public Rectangle(double w, double h) {
		this.width = w;
		this.height = h;
	}

	public void draw() {
		System.out.println("Drawing Rectangle");
	}

	public double getArea() {
		return this.height * this.width;
	}

}
