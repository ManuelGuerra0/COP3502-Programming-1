import java.util.Scanner;
import java.lang.Math;

public class Lab4 {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the first parameter (TRUE or FALSE): ");
		String answer = input.nextLine();		
		
		int randomInteger = 0 + (int)(Math.random() * 2);
		
        String value = "";
		
		switch (randomInteger) {
		case 0: value = "FALSE";
		break;
		case 1: value = "TRUE";
		break;
		}
		
		System.out.println("The program generates the second parameter " + value);
		
		int anotherRandomInteger = 0 + (int)(Math.random() * 2);
		
        String anotherValue = "";
		
		switch (anotherRandomInteger) {
		case 0: anotherValue = "OR";
		break;
		case 1: anotherValue = "AND";
		break;
		}
		
		System.out.println("The program generates operator " + anotherValue);
		
		if(answer.equals ("TRUE") && randomInteger == 1 && anotherRandomInteger == 1) {
			System.out.println(answer + " " + anotherValue + " " + value + ", the result is TRUE");
		}
		else if (answer.equals ("TRUE") && randomInteger == 1 && anotherRandomInteger == 0) {
			System.out.println(answer + " " + anotherValue + " " + value + ", the result is FALSE");
		}
		else if (answer.equals ("FALSE") && randomInteger == 1 && anotherRandomInteger == 0) {
			System.out.println(answer + " " + anotherValue + " " + value + ", the result is TRUE");
		}
		else if (answer.equals ("TRUE") && randomInteger == 0 && anotherRandomInteger == 1) {
			System.out.println(answer + " " + anotherValue + " " + value + ", the result is FALSE");
		}
		else if (answer.equals ("TRUE") && randomInteger == 0 && anotherRandomInteger == 1) {
			System.out.println(answer + " " + anotherValue + " " + value + ", the result is FALSE");
		}
		else if (answer.equals ("FALSE") && randomInteger == 0 && anotherRandomInteger == 0) {
			System.out.println(answer + " " + anotherValue + " " + value + ", the result is FALSE");
		}
		else if (answer.equals ("FALSE") && randomInteger == 1 && anotherRandomInteger == 1) {
			System.out.println(answer + " " + anotherValue + " " + value + ", the result is FALSE");
		}
		else if (answer.equals ("FALSE") && randomInteger == 0 && anotherRandomInteger == 1) {
			System.out.println(answer + " " + anotherValue + " " + value + ", the result is FALSE");
		}
		
		System.out.println(" ");
		System.out.println("PartII");
		System.out.println("Please enter a word: ");
		String word = input.nextLine();
		
		int evenMiddle;
		int oddMiddle;
		int end;
		
		end = (word.length());
		evenMiddle = ((word.length()) / 2 - 1);
		oddMiddle = ((word.length()) / 2);
		
		if(word.length() % 2 == 0) {
			System.out.println(word.substring(0, evenMiddle) + word.substring(evenMiddle+1,end));
		}
		else {
			System.out.println(word.substring(0, oddMiddle) + word.substring(oddMiddle+1,end));
		}
		input.close();
	}
}
