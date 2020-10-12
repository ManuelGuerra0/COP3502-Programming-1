import java.util.Scanner;
public class Lab3 {
	public static void main(String[] args) {
		
		System.out.println("|DATE CALCULATOR|");
		System.out.println(" ");
		System.out.println("0: Sunday");
		System.out.println("1: Monday");
		System.out.println("2: Tuesday");
		System.out.println("3: Wednesday");
		System.out.println("4: Thursday");
		System.out.println("5: Friday");
		System.out.println("6: Saturday");
		
		Scanner input = new Scanner(System.in);
		System.out.println("What day of the week is it: ");
		int presentDay = input.nextInt();
		
		if(presentDay > 6) {
			System.out.println("Invalid input.");
		}
		else {
		System.out.println("Enter the number of days in the future: ");
		int numberDays = input.nextInt();
		
		
		int futureDay = (presentDay + numberDays) % 7;
		
		String today = "";
		
		switch (presentDay) {
		case 0: today = "Sunday";
		break;
		case 1: today = "Monday";
		break;
		case 2: today = "Tuesday";
		break;
		case 3: today = "Wednesday";
		break;
		case 4: today = "Thursday";
		break;
		case 5: today = "Friday";
		break;
		case 6: today = "Saturday";
		break;
		}
		
        String future = "";
		
		switch (futureDay) {
		case 0: future = "Sunday";
		break;
		case 1: future = "Monday";
		break;
		case 2: future = "Tuesday";
		break;
		case 3: future = "Wednesday";
		break;
		case 4: future = "Thursday";
		break;
		case 5: future = "Friday";
		break;
		case 6: future = "Saturday";
		break;
		}
		
		
		System.out.println("Today is " + today + " and in " + numberDays + " days it will be a " + future + "!");
		}
	}
}
