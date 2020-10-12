/* Manuel Guerra
 * manuelaguerra
 * Section: 11H4
 * Project Number: 3
 * Program that allows you to convert currency and make deposits & withdrawals
 */
import java.util.Scanner;

public class CurrencyExchange {

    private static double balance = 0;

    /**
     * Get the current balance of the account
     */
    public static double getBalance() {
        return balance;
    }

     /**
     * Update the balance of current account, will do a roundup to 2 significant digits
     *
     * @return if update succeed, will return true. If failed, return false
     */
    private static boolean updateBalance(double newBalance) {

        balance = Math.round(newBalance * 100) / 100.0;
        if (balance >= 0) {
            return true;
        } else
            return false;
    }

/****************************************************************
*        Do not modify anything above this line                 *
*****************************************************************/

    /**
     * main method, put your business logic and console input here
     */
    
    public static void main(String[] args) {
    	//Creates Scanner
        Scanner input = new Scanner(System.in);
        
        //Calls method that prints out Conversion Table
        printConversionTable();
        
        //Asks for user to make to select 1 of the 4 options
        int menuSelection = mainMenuOptionSelector(input);
        
        //Initializing variables
        double amount = 0;
        double balance = 0;
        int currencyType = 0;
        
        //Declaring variable
        boolean isDeposit;
        
        //Loop that executes user selected options 1, 2, and 3
        while(menuSelection != 4) {
        	
        	//Prints out all the currencies in the menu
        	if(menuSelection == 2 || menuSelection == 3) {
        	currencyType = currencyMenuOptionSelector(input);
        	boolean isConvertToUSD = false;
        	
        	//Executes deposits (option 2)
        	if(menuSelection == 2) {
        		isConvertToUSD = true;
        		isDeposit = true;
        		System.out.println("Please enter the deposit amount:");
        		amount = input.nextDouble();
        		boolean check = deposit(amount, currencyType);
        		
        		if(!check) {
                	menuSelection = mainMenuOptionSelector(input);
        			continue;
        		}
        		System.out.println(logTransaction(amount, currencyType, isDeposit));
        	}

        	//Executes withdrawals (option 3)
        	if(menuSelection == 3) {
        		getBalance();
        		isConvertToUSD = true;
        		System.out.println("Please enter the withdrawal amount:");
        		amount = input.nextDouble();
        		isDeposit = false;
        		String withdrawMessage = logTransaction(amount, currencyType, isDeposit);
        		
        		if(withdraw(amount, currencyType) == false) {
        			System.out.println("Logging Error");
        			System.out.println();
                	menuSelection = mainMenuOptionSelector(input);
        			continue;
        		}
        		amount = convertCurrency(amount,currencyType, isConvertToUSD);
        		balance -= amount;
        		System.out.println(withdrawMessage);
        		System.out.println();
        	}
        }
        	
        //Allows user to see balance (option 1)
        if(menuSelection == 1) {
    		System.out.println("Your current balance is: " + getBalance());
    		System.out.println();
    	}
    	menuSelection = mainMenuOptionSelector(input);
        }
        
        //If statement for user selected option 4 (2 alternate exit messages)
        if(menuSelection == 4) {
        	isDeposit = false;
        	currencyType = 1;
        	amount = getBalance();
        	
        	//When the user's balance is exactly zero dollars
        	if(amount == 0) {
        		System.out.println("Your remaining balance is " + amount + " U.S. Dollars");
        		System.out.println("Goodbye");
        		System.exit(0);
        	}
        	//Regular goodbye message for anything over zero dollars
        	String balanceMessage = logTransaction(amount, currencyType, isDeposit);
        	System.out.println(balanceMessage);
        	System.out.println("Goodbye");
        	System.exit(0);
        }
    }


    /**
     * deposit the amount of a specific currency to the account
     *
     * @param amount       the amount to be deposited.
     * @param currencyType the currency type will be the same as the type number used
     *                     in the convertCurrency(double, int, boolean) method. An Invalid type will result in a
     *                     deposit failure.
     * @return if deposit succeed, will return true. If failed, return false
     */
    
    public static boolean deposit(double amount, int currencyType) {
    	boolean isConvertToUSD = false;
    	double newAmount;
    	if(currencyType == 1)
    		isConvertToUSD = false;
    	else
    		isConvertToUSD = true;
        if(amount <= 0) {
        	System.out.println("Logging Error");
        	System.out.println();
        	return false;
        }
        else {
        	newAmount = convertCurrency(amount, currencyType, isConvertToUSD);
        	updateBalance(balance + newAmount);
        	return true;
        } 	
    }

    /**
     * withdraw the value amount with a specific currency from the account. The withdraw amount should never exceed the current account balance, or the withdrawal will fail. If the currency is other than USD, a 0.5% convenience fee will be charged
     *
     * @param amount       the amount to be withdrawn.
     * @param currencyType the currency type will be the same as the type number used
     *                     in the convertCurrency(double, int, boolean) method. An invalid
     * 		         type will result a withdraw failure.
     * @return if withdraw succeed, will return true. If failed, return false
     */
    
    public static boolean withdraw(double amount, int currencyType) {
    	getBalance();
    	boolean isConvertToUSD;
    	double newAmount;
    	
    	if(currencyType == 1)
    		isConvertToUSD = false;
    	else
    		isConvertToUSD = true;
    	if(amount <= 0) {
        	return false;
    	}
    	if(amount > getBalance()) {
			System.out.println("Error: Insufficient funds.");
			return false;
		}
        if(isConvertToUSD == true) {
        	newAmount = convertCurrency(amount, currencyType, isConvertToUSD);
        	updateBalance(balance - (newAmount*1.005));
        	return true;
        }
        else {
        	newAmount = convertCurrency(amount, currencyType, isConvertToUSD);
        	updateBalance(balance - newAmount);
        	return true;
        }
    }

    /**
     * Convert the value amount between U.S. dollars and a specific currency.
     *
     * @param amount         The amount of the currency to be converted.
     * @param currencyType   The integer currencyType works as follows:
     *                       1 for usd (U.S. Dollars)
     *                       2 for eur (Euros)
     *                       3 for bri (British Pounds)
     *                       4 for inr (Indian Rupees)
     *                       5 for aus (Australian Dollars)
     *                       6 for cnd (Canadian Dollars)
     *                       7 for sid (Singapore Dollars)
     *                       8 for swf (Swiss Francs)
     *                       9 for mar (Malaysian Ringgits)
     *                       10 for jpy (Japanese Yen)
     *                       11 for cyr (Chinese Yuan Renminbi)
     * @param isConvertToUSD Tells the direction of the conversion. If the value is true, then the conversion is from a
     *                       foreign currency to USD. If the value is false, then the conversion is from USD to the
     *                       foreign currency
     * @return the converted amount
     */
    
    public static double convertCurrency(double amount, int currencyType, boolean isConvertToUSD) {
    	
    	if(isConvertToUSD == true) {
    		switch(currencyType) {
    		case 1: amount = amount; break;
    		case 2: amount /= 0.89; break;
    		case 3: amount /= 0.78; break;
    		case 4: amount /= 66.53; break;
    		case 5: amount /= 1.31; break;
    		case 6: amount /= 1.31; break;
    		case 7: amount /= 1.37; break;
    		case 8: amount /= 0.97; break;
    		case 9: amount /= 4.12; break;
    		case 10: amount /= 101.64; break;
    		case 11: amount /= 6.67; break;
    		}
    	}
    	return amount;
    }

    /**
     * Displays message at the end of the withdraw, deposit, and endTransaction stating
     * how much the user just withdrew/deposited and what type (this will be used in both features B, C and D of the
     * main menu).
     *
     * @param amount       the amount of currency withdrew/deposited
     * @param currencyType the currency type will be the same as the type number used
     *                     in {@link #convertCurrency(double, int, boolean)}
     * @param isDeposit    if true log the deposit transaction, false log the withdraw transaction
     * @return Return the formatted log message as following examples:
     * You successfully withdrew 10.0 U.S. Dollars
     * You successfully deposited 30.0 Japanese Yen
     * <p>
     * The invalid input like invalid currencyType or negative amount,
     * will return a “Logging Error”
     */
    
    private static String logTransaction(double amount, int currencyType, boolean isDeposit) {
    	
    	//Initializes Strings
    	String depositMessage = "";
    	String withdrawMessage = "";
    	String currencyName = "";
    	
    	//Converts the number choice to name of the currency
    	switch(currencyType) {
    		case 1: currencyName = "U.S. Dollars"; break;
    		case 2: currencyName = "Euros"; break;
    		case 3: currencyName = "British Pounds"; break;
    		case 4: currencyName = "Indian Rupees"; break;
    		case 5: currencyName = "Australian Dollars"; break;
    		case 6: currencyName = "Canadian Dollars"; break;
    		case 7: currencyName = "Singapore Dollars"; break;
    		case 8: currencyName = "Swiss Francs"; break;
    		case 9: currencyName = "Malaysian Ringgits"; break;
    		case 10: currencyName = "Japanese Yen"; break;
    		case 11: currencyName = "Chinese Yuan Renminbi"; break;
    	}
    	if(isDeposit == true) {
    		depositMessage = "You successfully deposited " + amount + " " + currencyName + "\n";
    		return depositMessage;
    	}
    	else {
    		withdrawMessage = "You successfully withdrew " + amount + " " + currencyName + "\n";
    		return withdrawMessage;
    	}
    }

    /**
     * Prints the currency menu (see output examples), allows the user to make a selection from available currencies
     *
     * @param input the Scanner object you created at the beginning of the main method. Any value other than the
     *              11 valid valid currency types should generate an invalid value prompt. Print the list again
     *              and prompt user to select a valid value from the list. the currency type will be the same as
     *              the type number used in {@link #convertCurrency(double, int, boolean)}
     * @return an integer from 1-11 inclusive representing the user’s selection.
     */
    
    private static int currencyMenuOptionSelector(Scanner currencyType) {
    	//Creates Scanner
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Please select the currency type:");
		System.out.println("1. U.S. Dollars");
		System.out.println("2. Euros");
		System.out.println("3. British Pounds");
		System.out.println("4. Indian Rupees");
		System.out.println("5. Australian Dollars");
		System.out.println("6. Canadian Dollars");
		System.out.println("7. Singapore Dollars");
		System.out.println("8. Swiss Francs");
		System.out.println("9. Malaysian Ringgits");
		System.out.println("10. Japanese Yen");
		System.out.println("11. Chinese Yuan Renminbi");
    	
    	int currencySelected = currencyType.nextInt();
    	
    	while(currencySelected < 1 || currencySelected > 11) {
    		System.out.println("Input failed validation. Please try again.");
    		System.out.println();
    		System.out.println("Please select the currency type:");
    		System.out.println("1. U.S. Dollars");
    		System.out.println("2. Euros");
    		System.out.println("3. British Pounds");
    		System.out.println("4. Indian Rupees");
    		System.out.println("5. Australian Dollars");
    		System.out.println("6. Canadian Dollars");
    		System.out.println("7. Singapore Dollars");
    		System.out.println("8. Swiss Francs");
    		System.out.println("9. Malaysian Ringgits");
    		System.out.println("10. Japanese Yen");
    		System.out.println("11. Chinese Yuan Renminbi");
    		currencySelected = currencyType.nextInt();
    	}
        return currencySelected;
    }

    /**
     * Prints the main menu (see output examples), allows the user to make a selection from available operations
     *
     * @param input the Scanner object you created at the beginning of the main method. Any value other than the 4
     *              valid selections should generate an invalid value prompt. Print the list again and prompt user to
     *              select a valid value from the list.
     * @return an integer from 1-4 inclusive representing the user’s selection.
     */
    
    private static int mainMenuOptionSelector(Scanner menuSelection) {
    	System.out.println("Please select an option from the list below:");
		System.out.println("1. Check the balance of your account");
		System.out.println("2. Make a deposit");
		System.out.println("3. Withdraw an amount in a specific currency");
		System.out.println("4. End your session (and withdraw all remaining currency in U.S. Dollars)");
		System.out.println();
		
		int menuOption = menuSelection.nextInt();
		
		while(menuOption < 1 || menuOption > 4) {
			System.out.println("Input failed validation. Please try again.");
			System.out.println();
			System.out.println("Please select an option from the list below:");
			System.out.println("1. Check the balance of your account");
			System.out.println("2. Make a deposit");
			System.out.println("3. Withdraw an amount in a specific currency");
			System.out.println("4. End your session (and withdraw all remaining currency in U.S. Dollars)");
			menuOption = menuSelection.nextInt();
		}
		return menuOption;
    }

    /**
     * Prints the conversion table at the start of the program (see the output examples).
     */
    
    private static void printConversionTable() {
    	System.out.println("Welcome to Currency Exchange 2.0");
		System.out.println();
		System.out.println("Current rates are as follows:");
		System.out.println();
		System.out.println("1 -  U.S. Dollar - 1.00");
		System.out.println("2 - Euro - 0.89");
		System.out.println("3 - British Pound - 0.78");
		System.out.println("4 - Indian Rupee - 66.53");
		System.out.println("5 - Australian Dollar - 1.31");
		System.out.println("6 - Canadian Dollar - 1.31");
		System.out.println("7 - Singapore Dollar - 1.37");
		System.out.println("8 - Swiss Franc - 0.97");
		System.out.println("9 - Malaysian Ringgit - 4.12");
		System.out.println("10 - Japanese Yen - 101.64");
		System.out.println("11 - Chinese Yuan Renminbi - 6.67");
		System.out.println();
    }
}