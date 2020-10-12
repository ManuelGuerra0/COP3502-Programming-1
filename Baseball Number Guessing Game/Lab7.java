import java.util.*;

public class Lab7 {
	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);

	System.out.print("Let's play baseball game!");

	//Generates random number
	double toRound = Math.random()*(double)1000.0;
	toRound = Math.round(toRound);
	int randNum = (int)toRound;

	while(numberVerification(randNum) == false) {
		toRound = Math.random()*(double)1000.0;
		toRound = Math.round(toRound);
		randNum = (int)toRound;
	}
	
	String randString = Integer.toString(randNum);
	while(true) { 
		//Asks user to input number
		System.out.print("\nWhat is your guess? : ");
		String userInput = scan.nextLine();
		
		//Tells user that they have entered an invalid number
		if(numberVerification(Integer.parseInt(userInput)) == false) {
			System.out.println("You entered an incorrect number");
			continue;
		}
		
		//Tells the user the general results
		System.out.println("You entered " + userInput + " and the result is ");

		if(baseballGame(userInput, randString) == true) {
			break;
		}
	}

	//Tells the user that they won
	System.out.println("\nWell done!");
	System.out.println("The number was " + randNum );

	}

	public static boolean numberVerification(int candidate) { 
		
		boolean lengthTruth = false;
		boolean duplicateTruth = false;
		String candString = Integer.toString(candidate);
		
		if(candString.length()==3) {
			lengthTruth =true;
		}
		
		if(candString.charAt(0)!=candString.charAt(1) && candString.charAt(0)!=candString.charAt(2) && candString.charAt(1)!=candString.charAt(2)) {
			duplicateTruth = true;
		}

		if(lengthTruth == true && duplicateTruth == true)
			return true;
		else
			return false;
	}

	public static boolean baseballGame(String input, String secret) {
		
		int strike=0, ball=0;

		for(int i = 0; i<3;i++) {
			for(int j = 0; j<3;j++) {
				if(input.substring(i,i+1).equals(secret.substring(j,j+1))) {
					if(i==j) {
						strike++;
					}
					else {
						ball++;
					}
				}
			}
		}
		
		System.out.print("B ");
		
		for(int ballNum=0; ballNum < ball; ballNum++) {
			System.out.print("O");
		}

		System.out.print("\nS ");
		
		for(int strikeNum=0; strikeNum < strike; strikeNum++) {
			System.out.print("O");
		}
		
		//System.out.println("\n"+ball+"\n"+strike+ " "+secret);
		if(strike==3)
			return true;
		else
			return false;
	}
}