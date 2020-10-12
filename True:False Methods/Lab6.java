import java.util.*;

public class Lab6 {
	public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);

	//Asks the user to enter an operator
	System.out.println("Operand 1: please enter either 0 or 1:");
	int operand1 = input.nextInt();
	System.out.println("Operand 2: please enter either 0 or 1:");
	int operand2 = input.nextInt();

	//Creates string and converts it to true or false
	String operator1;
	if(operand1 == 1)
		operator1 = "true";
	else
		operator1 = "false";

	//Creates string and converts it to true or false
	String operator2;
	if(operand2 == 1)
		operator2 = "true";
	else
		operator2 = "false";

	//Displays the AND, OR, NOR, and XOR results
	System.out.println(operator1 + " AND " + operator2 + " : "+ and(operand1,operand2));
	System.out.println(operator1 + " OR " + operator2 + " : "+ or(operand1,operand2)); 
	System.out.println(operator1 + " NOR " + operator2 + " : "+ nor(operand1,operand2));
	System.out.println(operator1 + " XOR " + operator2 + " : "+ xor(operand1,operand2));

	input.close();
	}

	public static boolean and(int a, int b) {
		//true and true
		if(a == 1 && b == 1)
			return true;
		else
			return false;
	}

	public static boolean or(int a, int b) {
		//false and false=false
		if(a == 0 && b == 0)
			return false;
		else
			return true;
	}

	public static boolean nor(int a, int b) {
		//false and false=true
		if(a == 0 && b == 0)
			return true;
		else
			return false;
	}

	public static boolean xor(int a, int b) {
		//if they are different
		if(a != b)
			return true;
		else
			return false;
	}
}