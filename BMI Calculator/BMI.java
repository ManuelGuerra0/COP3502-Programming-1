import java.util.Scanner;
public class BMI {
	public static void main(String[] args) {
		
		System.out.println("* * * BMI Calculator * * *");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your weight in pounds: ");
		double answer1 = input.nextInt();
		
		System.out.println("Enter your height in inches: ");
		double answer2 = input.nextInt();
		
		System.out.println("Your BMI is: " + (answer1 * 703) / (answer2 * answer2));
		
		double answer3 = (answer1 * 703) / (answer2 * answer2);
		
		if(answer3 < 18.5){
			System.out.println("You are underweight!");
		}
		else{
			if(answer3 >= 18.5 && answer3 <= 24.9){
				System.out.println("Congratulations! You are at normal weight!");
			}
			else{
				if(answer3 >= 25.0 && answer3 <= 29.9){
					System.out.println("You are overweight!");
				}
				else{
					if(answer3 >= 30.0){
						System.out.println("You are obese!");
					}
				}
			}
		}
	}
}