
public class Rectangle extends Shape {
	double height;
	double width;
	
	Rectangle(double h, double w, String color) {
		height = h;
		width = w;
		this.color = color;
	}
	
	public double calculateArea(double height, double width) {
		return height*width;
	}
	
	public String toString(int rectCount) {
		return ("----------------------\n"
				+ "Rectangle" + rectCount + "'s Info:\n"
				+ "Color: " + color +"\n"
				+ "Height: " + height +"\n"
				+ "Width: " + width +"\n"
				+ "Area: " + calculateArea(height, width) +"\n"
				+ "----------------------");
	}
}
