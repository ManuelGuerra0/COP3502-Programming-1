import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Math;
import java.util.Scanner;

public class ShapeMachine {
	public static void main(String[] args) {
		
		//Prompts user they are logging on into Shape Machine
		System.out.println("Shape Machine login");
		System.out.println();
						
		Scanner input = new Scanner(System.in);
						
		//Asks user to enter today's day
		System.out.print("What is today's day? ");
		String todaysDay = input.nextLine();
						
		//Asks user to enter today's month
		System.out.print("What is today's month? ");
		String todaysMonth = input.nextLine();
						
		//Asks user to enter today's year
		System.out.print("What is today's year? ");
		String todaysYear = input.nextLine();
						
		//Concatenates user's inputs in dd-mm-yyyy format
		String todaysDate = todaysDay + "-" + todaysMonth + "-" + todaysYear;
						
		//Creates a new object with today's day in dd-mm-yyyy format
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
				
		//Determines if the user's date matches the real password date
		boolean machineAccess = todaysDate.equals(date);
				
		//Directs user to the Shape Machine
		if(machineAccess == true) {
			System.out.println("Correct date. Welcome!");
			System.out.println();
		}
				
		//The procedure that happens if the user puts in the wrong password once
		for(int tries = 1; machineAccess == false && tries <= 3; tries++) {
					
			//Tells the user it is terminating the program after 3 failed attempts
			if(tries == 3) {
				System.out.print("#ERROR 3rd invalid login attempt. Terminating program.");
				break;
			}
					
			//The entire Shape Machine login procedure repeated
			System.out.println("#ERROR Login attempt #" + tries + " Invalid input. Please try again.");
			System.out.println();
			System.out.print("What is today's day? ");
			String todaysDayAgain = input.nextLine();
			System.out.print("What is today's month? ");
			String todaysMonthAgain = input.nextLine();
			System.out.print("What is today's year? ");
			String todaysYearAgain = input.nextLine();
			String todaysDateAgain = todaysDayAgain + "-" + todaysMonthAgain + "-" + todaysYearAgain;
			String dateAgain = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			boolean machineAccessAgain = todaysDateAgain.equals(dateAgain);
					
			//Directs user to the Shape Machine
			if(machineAccessAgain == true) {
				machineAccess = true;
				System.out.println("Correct date. Welcome!");
				System.out.println();
			}			
		}
				 
	    while(machineAccess == true) {
				     
		    //Shape Machine welcome screen and menu
		    System.out.println("---Welcome to the Shape Machine---");
		    System.out.println("Available Options:");
		    System.out.println("Circles");
		    System.out.println("Rectangles");
		    System.out.println("Triangles");
		    System.out.println("Exit");
		    System.out.println();
		    String shape = input.next();
		        	 
		    //Makes sure that the user puts in the acceptable string options
		    boolean circles = shape.equals("Circles");
		    boolean rectangles = shape.equals("Rectangles");
		    boolean triangles = shape.equals("Triangles");
		    boolean exit = shape.equals("Exit");
		    
		//Terminates the program if the user enters "Exit"
		if(exit == true) {
		    System.out.print("Terminating the program. Have a nice day!");
		    break;
		}
		    
		//User selected "Circles"
       	else if(circles == true) {
       		 
       		//Asks user to enter the radius of a circle
       		System.out.print("Circles selected. Please enter the radius: ");
       		double radius = input.nextDouble();
       		 
       		//Loop used if the user inputs a negative number
       		while(radius <= 0) {
       		    System.out.print("#ERROR Negative input. Please input the radius again: ");
       			double radiusAgain = input.nextDouble();
       			radius = radiusAgain;
       		}
       		 
       		//Calculates the circumference and the area of a circle, respectively
       		double circumference = 2 * Math.PI * radius;
       		double circleArea = Math.PI * radius * radius;
       		 
       		//Shows the user the circumference and the area of a circle, respectively
       		System.out.println("The circumference is: " + circumference);
       		System.out.println("The area is: " + circleArea);
       		 
       		//Converts the total number of digits into a string
       		String circumferenceDigits = Double.toString(circumference);
       		String circleAreaDigits = Double.toString(circleArea);
       		 
       		//Shows the user the total number of digits in each string
       		System.out.println("Total number of digits in the circumference is: " + (circumferenceDigits.length() - 1));
       	    System.out.println("Total number of digits in the area is: " + (circleAreaDigits.length() - 1));
       		System.out.println(); 
       	}
		    
		//User selected "Rectangles"
       	else if(rectangles == true) {
       		 
       		//Asks user to enter two sides of a rectangle
       		System.out.print("Rectangles selected. Please enter the 2 sides: ");
       		double rectSide1 = input.nextDouble();
       		double rectSide2 = input.nextDouble();
       		 
       		//Loop used if the user inputs a negative number
       	    while(rectSide1 <= 0 || rectSide2 <= 0) {
       			System.out.print("#ERROR Negative input. Please input the 2 sides again: ");
       			double rectSide1Again = input.nextDouble();
       			double rectSide2Again = input.nextDouble();
       			rectSide1 = rectSide1Again;
       			rectSide2 = rectSide2Again;
       		}
       		 
       		//Calculates the area and the perimeter of a rectangle, respectively
       		double rectArea = rectSide1 * rectSide2;
       		double rectPerimeter = (2 * rectSide1) + (2 * rectSide2);
       		 
       		//Shows the user the area and the perimeter of a rectangle, respectively
       		System.out.println("The area is: " + rectArea);
       		System.out.println("The perimeter is: " + rectPerimeter);
       		 
       		//Converts the total number of digits into a string
       		String rectAreaDigits = Double.toString(rectArea);
       		String rectPerimeterDigits = Double.toString(rectPerimeter);
       		 
       		//Shows the user the total number of digits in each string
       		System.out.println("Total number of digits in the area is: " + (rectAreaDigits.length() - 1));
       		System.out.println("Total number of digits in the perimeter is: " + (rectPerimeterDigits.length() - 1));
       		System.out.println();
       	}
		    
		//User selected "Triangles"
        else if(triangles == true) {
            	
            //Asks user to enter three sides of a triangle
            System.out.print("Triangles selected. Please enter the 3 sides: ");
            double triSideA = input.nextDouble();
            double triSideB = input.nextDouble();
            double triSideC = input.nextDouble();
            	
            //Loop used if the user inputs a negative number
            while(triSideA <= 0 || triSideB <= 0 || triSideC <= 0) {
       			System.out.print("#ERROR Negative input. Please input the 3 sides again: ");
       			double triSideAAgain = input.nextDouble();
       		    double triSideBAgain = input.nextDouble();
       			double triSideCAgain = input.nextDouble();
       			triSideA = triSideAAgain;
       			triSideB = triSideBAgain;
       			triSideC = triSideCAgain;  
       		}
            	
            //Redirects user to the Shape Machine if they input an impossible triangle
            if(triSideA + triSideB <= triSideC || triSideB + triSideC <= triSideA || triSideA + triSideC <= triSideB) {
            	System.out.println("#ERROR Triangle is not valid. Returning to menu.");
            	System.out.println();
            	continue;
            }
            	
            //Shows the user if the triangle is equilateral, isosceles, or scalene, respectively
            if(triSideA == triSideB && triSideB == triSideC && triSideA == triSideC) {
            	System.out.println("The triangle is: Equilateral");
            }
            else if(triSideA == triSideB || triSideB == triSideC || triSideA == triSideC) {
            	System.out.println("The triangle is: Isosceles");
            }
            else {
            	System.out.println("The triangle is: Scalene");
            }
            	
            //Calculates the perimeter and the area of the triangle, respectively
            double triPerimeter = triSideA + triSideB + triSideC;
            double halfTriPerimeter = triPerimeter / 2;
       		double triArea = java.lang.Math.sqrt(halfTriPerimeter * (halfTriPerimeter - triSideA) * (halfTriPerimeter - triSideB) * (halfTriPerimeter - triSideC));
       		    
       		//Shows the user the perimeter and the area of the triangle, respectively
       		System.out.println("The perimeter is: " + triPerimeter);
    		System.out.println("The area is: " + triArea);
    		    
    		//Converts the total number of digits into a string
    		String triPerimeterDigits = Double.toString(triPerimeter);
       		String triAreaDigits = Double.toString(triArea);
       		    
       		//Shows the user the total number of digits in each string
       		System.out.println("Total number of digits in the perimeter is: " + (triPerimeterDigits.length() - 1));
    		System.out.println("Total number of digits in the area is: " + (triAreaDigits.length() - 1));
    		System.out.println();	
        }
		    
		//Redirects user to the Shape Machine after inputting the wrong option
		else if(circles == false && rectangles == false && triangles == false && exit == false) {
		        System.out.println("#ERROR Invalid option. Please try again.");
		    }
		}		        
			input.close();
	}
}