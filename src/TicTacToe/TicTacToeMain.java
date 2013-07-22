package TicTacToe;

/*	@author satheeshkumark
 * 
 * 	Main function for TcTacToe Application 
 */

import java.util.Scanner;

public class TicTacToeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = Game.getGameInstance();
		int endFlag = -1;
		Scanner sc = new Scanner(System.in);
		outerloop :
		while(endFlag != 0){
			int row = -1; 
			int column = -1;
			Player[] p = game.getPlayers();
			do{
				System.out.println("PLAYER1 : Your turn");
				System.out.println("Enter the row and column values separated by comma(0 to 3)");
				String[] inputString = sc.nextLine().split(",");
				if(inputString.length != 2){
					System.out.println("Arguments doesnt match.. Please re-enter input positions");
					endFlag = -2;
					continue;
				}
				row = Integer.parseInt(inputString[0]);
				column = Integer.parseInt(inputString[1]);
				endFlag = game.placeSymbol(row, column, p[0]);
				if(endFlag == -2)
					System.out.println("The position you have entered has already been filled");
				else if(endFlag == 0){
					System.out.println();
					System.out.println("PLAYER 1 WINS...............!!!!!!!!!!!!!!!!");
					break outerloop;
				}
				else if(endFlag == 2){
					System.out.println();
					System.out.println("Drawn...............!!!!!!!!!!!!!!!!");
					break outerloop;
				}
			}while(endFlag == -2);
			
			endFlag = game.placeSymbol(row, column, p[1]);
			if(endFlag == 0){
				System.out.println();
				System.out.println("PLAYER 2 WINS...............!!!!!!!!!!!!!!!!");
				break;
			}
		}
	}
}