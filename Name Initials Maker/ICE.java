import java.util.Scanner; 
public class ICE {    
	public static void main(String[] args) { 
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your first name: ");
		String firstName = input.nextLine();
		
		char fi = firstName.charAt(0);
		
		System.out.println("Please enter your middle name: ");
		String middleName = input.nextLine();
		
		char mi = middleName.charAt(0);
		
		System.out.println("Please enter your last name: ");
		String lastName = input.nextLine();
		
		char la = lastName.charAt(0);
		
		System.out.println("Welcome " + firstName + ", your initials are " + fi + "." + mi + "." + la);		
	}
}