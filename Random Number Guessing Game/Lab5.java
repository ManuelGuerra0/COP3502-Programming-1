import java.util.Scanner;

public class Lab5 {
        public static void main (String[] args) {
                
        //Prompts user about the probability guessing game
        System.out.println("The probability of guessing this number is 1/n.");
        	
        //Asks user to enter 'n'
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 'n':");
        int n = input.nextInt();
        
        //Generates the random number
        double toRound = Math.random() * (double)n;
        toRound = Math.round(toRound);
        int randomInt = (int)toRound + 1;
        
        //Asks user the number of tries
        System.out.println("How many tries are we limited to?:");
        int attemptsLimit = input.nextInt();
        
        //Initialize variables
        int i = 0;
        boolean rin = true;
        int userNumber;
        
        //Loop for attempts
        while (i < attemptsLimit && rin) {
         System.out.println("Try #"+ (i+1) + " Enter an integer:"); 
         userNumber = input.nextInt();
         
         if (userNumber == randomInt) {
                 rin = false;
                 System.out.println("CORRECT! The number was "+ randomInt);
         }
         else if (userNumber > randomInt) 
        	 System.out.println("INCORRECT! Your answer is too high!");
         else 
        	 System.out.println("INCORRECT! Your anwser is too low!");
         i++;
        }
        
        //Calculates c2 and c3
        int n1 = attemptsLimit - i;
        int c2 = 0, c3 = 0;
        
        for (int j = 1; j <= n1 + 1; j ++) {
         c2 += j;
        }
        for (int j = 0; j <= attemptsLimit; j++) {
         c3 += j;
        }
        
        //Calculates score
        double score = n * ((double)c2/(double)c3);
        double scoreFinal = Math.round(score*100)/100.0;
        
        //Prompts user about their score
        System.out.println ("You have scored " + scoreFinal + " points");
        input.close();
    }
}