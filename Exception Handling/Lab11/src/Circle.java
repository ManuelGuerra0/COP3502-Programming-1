/* Manuel Guerra
 * manuelaguerra
 * Section: 11H4
 * Lab 10
 */
public class Circle extends Shape{
	double radius;
	
	Circle(double r, String color)
	{
		this.radius = r;
		this.color = color;
	}
	
	public double calculateArea(double radius)
	{
		return Math.PI*radius*radius;
	}
	
	public String toString(int circleCount)
	{
		return ("----------------------\n"
				+ "Circle" + circleCount + "'s Info:\n"
				+ "Color: " + color +"\n"
				+ "Radius: " + radius +"\n"
				+ "Area: " + calculateArea(radius) +"\n"
				+ "----------------------");
	}
}
