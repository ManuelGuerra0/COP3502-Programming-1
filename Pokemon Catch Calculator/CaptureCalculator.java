import java.util.Scanner;
import java.lang.Math;

public class CaptureCalculator {
	public static void main(String[] arg) {
		
		//Prompts user about the Capture Calculator
		System.out.println("Hello and welcome to the Monster Capture Possibility Calculator.");
		
		//Asks user to enter latitude of the monster
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the latitude of the monster (1-10): ");
		double latitudeMonster = input.nextInt();
		
		//Asks user to enter longitude of the monster
		System.out.println("Please enter the longitude of the monster (1-10): ");
		double longitudeMonster = input.nextInt();
		
		//Asks user to enter the monster's appear time
		System.out.println("Please enter the time of the monster appear (1-1440): ");
		int appearTime = input.nextInt();
		
		//Asks user to enter the monster's exist time
		System.out.println("Please enter the possible time of the monster will exist (10-59): ");
		int existTime = input.nextInt();
		
		//Asks user to enter player ID
		System.out.println("Please enter the player’s ID (8 digits): ");
		int playerID = input.nextInt();
		
		//Calculation used to see the last two digits of the player's ID
		int listID = playerID % 100;
		
		//Asks user to enter the time noticing the monster
		System.out.println("Please enter the time of the player noticing monster (1-1440 and greater than the time the monster appears): ");
		int noticeTime = input.nextInt();
		
		//Asks user to enter their own latitude
		System.out.println("Please enter the latitude of the player (1-10): ");
		double latitudePlayer = input.nextInt();
		
		//Asks user to enter their own longitude
		System.out.println("Please enter the longitude of the player (1-10): ");
		double longitudePlayer = input.nextInt();
		
		//Asks user to enter their own walking speed
		System.out.println("Please enter the player's walking speed (10-200): ");
		double playerSpeed = input.nextInt();
				
		//Tells if the user is on the lucky list or normal list
		if(listID <= 49) {
			System.out.println("Player " + playerID + " who is on the lucky list,");
		}
		else {
			System.out.println("Player " + playerID + " who is on the normal list,");
		}
		
		//Displays the user's time noticing the monster
		System.out.println("noticed the monster at time " + noticeTime + ",");
		
		//Calculates the distance between the user and the monster in meters
		double monsterPlayerX = Math.pow(latitudeMonster - latitudePlayer,2);
		double monsterPlayerY = Math.pow(longitudeMonster - longitudePlayer,2);
		double rawDistance1 = java.lang.Math.sqrt(monsterPlayerX + monsterPlayerY);
		double rawDistance2 = Math.round(rawDistance1 * 10000);
		double monsterPlayerDistance = rawDistance2 / 10;
		
		//Displays the user's distance from the monster in meters
		System.out.println("is " + monsterPlayerDistance + " m away from the monster,");
		
		//Calculates the exact time the player will arrive
		double rawArrival = Math.round((monsterPlayerDistance / playerSpeed) * 10);
		double exactArrivalTime = (rawArrival / 10) + noticeTime;
		
		//Displays the player's arrival time
		System.out.println("and will arrive at time " + exactArrivalTime + ".");
		
		//Calculates the monster's disappear time
		int disappearTime = (appearTime + existTime);
		
		//Displays the monster's disappear time
		System.out.println("The monster's disappear time is about " + disappearTime + ".");
		
		//Calculates the proportion of the monster's disappear probability
		double likelihoodCapture = (((exactArrivalTime - (appearTime + existTime))/ existTime));
		
		//Tells the player their chances of capturing the monster
		//Definitely probability
		if(exactArrivalTime <= disappearTime) {
			System.out.println("So the player will capture this monster with definitely possibility.");
		}
		//Highly Likely probability
				else if(listID <= 49 && likelihoodCapture <= 0.10 && likelihoodCapture >= 0.0) {
					System.out.println("So the player will capture this monster with highly likely possibility.");
				}
				else if(likelihoodCapture <= 0.05 && likelihoodCapture >= 0.0) {
					System.out.println("So the player will capture this monster with highly likely possibility.");
				}
		//Likely probability
				else if(listID <= 49 && likelihoodCapture <= 0.30 && likelihoodCapture > 0.10) {
					System.out.println("So the player will capture this monster with likely possibility.");
				}
				else if(likelihoodCapture <= 0.20 && likelihoodCapture > 0.05) {
					System.out.println("So the player will capture this monster with likely possibility.");
				}
		//Unsure probability
				else if(listID <= 49 && likelihoodCapture <= 0.40 && likelihoodCapture > 0.30) {
					System.out.println("So the player will capture this monster with unsure possibility.");
				}
				else if(likelihoodCapture <= 0.35 && likelihoodCapture > 0.20) {
					System.out.println("So the player will capture this monster with unsure possibility.");
				}
		//Unlikely probability
				else if(listID <= 49 && likelihoodCapture <= 0.50 && likelihoodCapture > 0.40) {
					System.out.println("So the player will capture this monster with unlikely possibility.");
				}
				else if(likelihoodCapture <= 0.40 && likelihoodCapture > 0.35) {
					System.out.println("So the player will capture this monster with unlikely possibility.");
				}
		//Highly Unlikely probability
				else if(listID <= 49 && likelihoodCapture > 0.50) {
					System.out.println("So the player will capture this monster with highly unlikely possibility.");
				}
				else if(likelihoodCapture > 0.40) {
					System.out.println("So the player will capture this monster with highly unlikely possibility.");
				}
		//Closes scanner
		input.close();	
	}
}