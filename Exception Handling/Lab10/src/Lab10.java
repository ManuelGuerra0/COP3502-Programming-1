import java.util.*;

public class Lab10 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		ArrayList <Shape> list = new ArrayList<>();
		
		System.out.println("How many shapes do you want to create?");
		int numberOfShapes = input.nextInt();
		
		int count = 0;
		
		while(count < numberOfShapes) {
			System.out.println("What shape do you want to make " + "(1=circle, 2=rectangle, 3=triangle)?");
			int shapeType = input.nextInt();
			
			switch(shapeType) {
			//Circle
			case 1	: System.out.println("What color is this circle?");
					String c = input.next();
					
					System.out.println("What's the radius?");
					Shape circle = new Circle(input.nextDouble(), c);
					
					list.add(circle);
					break;
			//Rectangle	
			case 2	: System.out.println("What color is this rectangle?");
					String c2 = input.next();
					
					System.out.println("What's the height?");
					double height = input.nextDouble();
					
					System.out.println("What's the width?");
					double width = input.nextDouble();
					
					Shape rectangle = new Rectangle(height, width, c2);
										
					list.add(rectangle);
					break;
			//Triangle		
			case 3	: System.out.println("What color is this triangle?");
					String c3 = input.next();
					
					System.out.println("What's the height?");
					double height1 = input.nextDouble();
					
					System.out.println("What's the base?");
					double base = input.nextDouble();
					
					Shape triangle = new Triangle(height1, base, c3);
										
					list.add(triangle);
					break;			
			}
			count++;
		}
		
		boolean check = true;
		
		while(check) {
			System.out.println("Select an option:\n"
					+ "1. Display info for circles\n"
					+ "2. Display info for rectangles\n"
					+ "3. Display info for triangles\n"
					+ "4. Add another shape\n"
					+ "5. Exit");
			int option = input.nextInt();
			
			switch(option) {
			//Circle
			case 1	:	int countCase = 1;
						for(int i = 0; i < list.size(); i++) {
							if(list.get(i) instanceof Circle) {
								System.out.println(list.get(i).toString(countCase));
								countCase++;
							}		
						}
						break;
			//Rectangle
			case 2	:	int countCase1 = 1;
						for(int i = 0; i < count; i++) {
							if(list.get(i) instanceof Rectangle) {
								System.out.println(list.get(i).toString(countCase1));
								countCase1++;
							}		
						}
						break;	
			//Triangle
			case 3	:	int countCase2 = 1;
						for(int i = 0; i < count; i++) {
							if(list.get(i) instanceof Triangle) {
								System.out.println(list.get(i).toString(countCase2));
								countCase2++;
							}		
						}
						break;	
						
			case 4	:	System.out.println("What shape do you want to make " + "(1=circle, 2=rectangle, 3=triangle)?");
			int whichTypeOfShape = input.nextInt();
			
			switch(whichTypeOfShape) {
			//Circle
			case 1	: System.out.println("What color is this circle?");
					String c = input.next();
					
					System.out.println("What's the radius?");
					
					Shape circle = new Circle(input.nextDouble(), c);
										
					list.add(circle);
					break;
			//Rectangle		
			case 2	: System.out.println("What color is this rectangle?");
					String c2 = input.next();
					
					System.out.println("What's the height?");
					double height = input.nextDouble();
					
					System.out.println("What's the width?");
					double width = input.nextDouble();
					
					Shape rectangle = new Rectangle(height, width, c2);
										
					list.add(rectangle);
					break;
			//Triangle		
			case 3	: System.out.println("What color is this triangle?");
					String c3 = input.next();
					
					System.out.println("What's the height?");
					double height1 = input.nextDouble();
					
					System.out.println("What's the base?");
					double base = input.nextDouble();
					
					Shape triangle = new Triangle(height1, base, c3);
										
					list.add(triangle);
					break;			
			}		
			break;
			//The end
			case 5	: check = false;
					System.out.println("Good bye");
					break;			
			}	
		}	
	}
}
