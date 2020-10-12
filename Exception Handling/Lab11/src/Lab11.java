/* Manuel Guerra
 * manuelaguerra
 * Section: 11H4
 * Lab 11
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Lab11 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		ArrayList <Shape> list = new ArrayList<>();

		boolean ifNameExists = false;
		while (ifNameExists == false){
			System.out.println("What is the name of the file containing the information for the shapes?");
			String fileName = input.nextLine();
			
			try{
				File shapeFile = new File(fileName);
				Scanner readFile = new Scanner(shapeFile);
				PrintWriter circleWriter = new PrintWriter("CircleInfo.txt");
				PrintWriter rectWriter = new PrintWriter("RectangleInfo.txt");
				PrintWriter triWriter = new PrintWriter("TriangleInfo.txt");
				System.out.println("File \"ShapeInfo\" opened successfully!");
				
				int numShapes = readFile.nextInt();
				int count = 0;
				
				while(count<numShapes){

					int whichShape = readFile.nextInt();
					switch(whichShape){
					case 1	:
							String c = readFile.next();
							double circleDouble = readFile.nextDouble();
							Shape circle = new Circle(circleDouble, c);
							
							list.add(circle);
							break;
							
					case 2	: 
							String c2 = readFile.next();
							double height = readFile.nextDouble();
							double width = readFile.nextDouble();
							Shape rectangle = new Rectangle(height, width, c2);
							list.add(rectangle);
							break;
					case 3	: 
							String c3 = readFile.next();
							double height1 = readFile.nextDouble();
							double base = readFile.nextDouble();
							Shape triangle = new Triangle(height1, base, c3);
							list.add(triangle);
							break;			
					}
					
					count++;
				}//ends while loop
				
				boolean check = true;
				
				while(check){
					System.out.println("Select an option:\n"
							+ "1. Display info for circles\n"
							+ "2. Display info for rectangles\n"
							+ "3. Display info for triangles\n"
							+ "4. Add another shape\n"
							+ "5. Exit");
					int option = input.nextInt();
					
					switch(option){
					case 1	:	int countCase = 1;//Circle 1, Circle 2, etc
								circleWriter = new PrintWriter("CircleInfo.txt");
								for(int i = 0; i < list.size();i++){
									if(list.get(i) instanceof Circle){
										circleWriter.println(list.get(i).toString(countCase));
										countCase++;
									}
								}
								System.out.println("The information for the Circles have been printed to CircleInfo.txt");
								circleWriter.close();
								break;
					case 2	:	int countCase1 = 1;//Circle 1, Circle 2, etc
								rectWriter = new PrintWriter("RectangleInfo.txt");
								for(int i = 0; i < list.size();i++){
									if(list.get(i) instanceof Rectangle){
										rectWriter.println(list.get(i).toString(countCase1));
										countCase1++;
									}	
								}
								System.out.println("The information for the Rectangle have been printed to RectangleInfo.txt");
								rectWriter.close();
								break;			
					case 3	:	int countCase2 = 1;//Circle 1, Circle 2, etc
								triWriter = new PrintWriter("TriangleInfo.txt");
								for(int i = 0; i < list.size();i++){
									if(list.get(i) instanceof Triangle){
										triWriter.println(list.get(i).toString(countCase2));
										countCase2++;
									}		
								}
								System.out.println("The information for the Triangle have been printed to TriangleInfo.txt");
								triWriter.close();
								break;	
								
					case 4	:	System.out.println("What shape do you want to make "
							+ "(1=circle, 2=rectangle, 3=triangle)?");
					int whichShape = input.nextInt();
					
					
					switch(whichShape){
					case 1	: System.out.println("What color is this circle?");
							String c = input.next();
							System.out.println("What's the radius?");
							Shape circle = new Circle(input.nextDouble(), c);
							list.add(circle);
							break;
							
					case 2	: System.out.println("What color is this rectangle?");
							String c2 = input.next();
							System.out.println("What's the height?");
							double height = input.nextDouble();
							System.out.println("What's the width?");
							double width = input.nextDouble();
							Shape rectangle = new Rectangle(height, width, c2);
							list.add(rectangle);
							break;
					case 3	: System.out.println("What color is this triangle?");
							String c3 = input.next();
							System.out.println("What's the height?");
							double height1 = input.nextDouble();
							System.out.println("What's the base?");
							double base = input.nextDouble();
							Shape triangle = new Triangle(height1, base, c3);
							list.add(triangle);
							break;			
					} break;

					case 5	: check = false;
							System.out.println("Good bye");
							System.exit(0);
								
					}
					
				}
				
				
			}
			catch(FileNotFoundException fileNotFound) {
				System.out.println("FileNotFoundException: The file " + fileName + " could not be found.");
			}
			catch(InputMismatchException inputMismatch) {
				System.out.println("InputMismatchException: The input given does not match what is expected, please try again.");
			}

		}

				
			}
		}
		

		
		