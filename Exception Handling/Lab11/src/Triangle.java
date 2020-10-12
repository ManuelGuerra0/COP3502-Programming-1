/* Manuel Guerra
 * manuelaguerra
 * Section: 11H4
 * Lab 10
 */
public class Triangle extends Shape
{
	double base, height;
	
	Triangle(double b, double h, String color)
	{
		base = b;
		height = h;
		this.color = color;
	}
	
	public double calculateArea(double base, double height)
	{
		return 0.5*base*height;
	}
	
	public String toString(int triCount)
	{
		return ("----------------------\n"
				+ "Triangle" + triCount + "'s Info:\n"
				+ "Color: " + color +"\n"
				+ "Height: " + height +"\n"
				+ "Base: " + base +"\n"
				+ "Area: " + calculateArea(height, base) +"\n"
				+ "----------------------");
	}
}
