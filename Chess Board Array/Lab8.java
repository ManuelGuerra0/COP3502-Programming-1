import java.util.Scanner;

public class Lab8 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//Part 1
		System.out.println("Lab 8: Part 1");
		String userInput = input.nextLine();
		
		char test[] = new char[userInput.length()];
		
		for(int i = 0; i < userInput.length(); i++) {
			test[i] = userInput.charAt(i);
		}
		
		//Calling methods for part 1, 2, and 3
		print_array(test); 
		print_array(reverse_array(test)); 
		int[][] board = new int[8][8];
		print_board(board);

		//Part 4
		System.out.println("\nLab 8: Part 4");
		
		char[][] chessBoard = { 
				{'b','k','r','K','Q', 'r', 'k','b'},
				{'1','1','1','1','1', '1', '1','1'},
				{'-','-','-','-','-', '-', '-','-'},
				{'-','-','-','-','-', '-', '-','-'},
				{'-','-','-','-','-', '-', '-','-'},
				{'-','-','-','-','-', '-', '-','-'},
				{'1','1','1','1','1', '1', '1','1'},
				{'b','k','r','K','Q', 'r', 'k','b'}};

		for(int i = 0; i < chessBoard.length; i++) {
			for(int j = 0; j < chessBoard[0].length;j++) {
				System.out.print(chessBoard[i][j]);
			}
			System.out.println("");
		}
	}

	//Part 1 method
	public static void print_array(char[] x) {
		System.out.println("the length of the string and array is: " + x.length);
		
		for(int i = 0; i < x.length; i++) {
			System.out.println("index " + i + " contains: " + x[i]);
		}
	}

	//Part 2 method
	public static char[] reverse_array(char[] original) {
		System.out.println("");
		System.out.println("Lab 8: Part 2");
		
		char[] reverse = new char[original.length];
		for(int i = original.length-1,  j = 0; i >= 0 && j < original.length; i--, j++) {

			reverse[j] = original[i];
		}
		return reverse;
	}
	
	//Part 3 method
	public static void print_board(int[][] x) {
		System.out.println("");
		System.out.println("Lab 8: Part 3");
		for(int i = 0; i < x[0].length; i++) {
			for(int j = 0; j < x.length; j++) {
				if(i==0) {
					x[0][j]=1;
				}
				else if(j==0) {
					x[i][0]=1;
				}
				else {
					x[i][j] =x[i-1][j]+ x[i][j-1];
				}
				System.out.print(x[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
}