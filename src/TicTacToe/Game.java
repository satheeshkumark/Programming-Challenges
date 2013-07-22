package TicTacToe;

/*	@author satheeshkumark
 * 
 * 	This class defines the basic data structures for Game object 
 */

import java.util.Random;

public class Game {
	private Board board;
	private Player[] players;
	private static Game gameInstance;
	private int rowColValue = 3;	
	
	/* Creates the board and the players */
	private Game(){
		board = new Board(rowColValue,rowColValue);
		players = new Player[2];
		players[0] = new Player(Symbol.Cross);
		players[1] = new Player(Symbol.Dot);
	}
	
	/* Singleton Game Instance */
	public static Game getGameInstance() {
		if (gameInstance == null)
			gameInstance = new Game();		
		return gameInstance;
	}

	public Board getBoard() {
		return board;
	}

	public Player[] getPlayers() {
		return players;
	}

	public int getRowColValue() {
		return rowColValue;
	}

	public void setRowColValue(int rowColValue) {
		this.rowColValue = rowColValue;
	}
	
	/* Places the symbol in the position (row,column) on the board */
	public int placeSymbol(int row, int column, Player p) {
		int flag = 0;
		
		if(p.getSym() == Symbol.Cross){
			if(row > rowColValue || row < 0 || column > rowColValue || column < 0){
				flag = -2;
				return flag;
			}
			flag = this.getBoard().placeSymbol(row, column, p.getSym());
		}
		else{
			row = chooseRandom();
			column = chooseRandom();
			flag = this.getBoard().placeSymbol(row, column, p.getSym());
			
			while(flag == -2){
				row = chooseRandom();
				column = chooseRandom();
				flag = this.getBoard().placeSymbol(row, column, p.getSym());
			}
		}
		
		return flag;
	}
	
	
	/* Computer AI chooses some random row and column value to place its piece */ 
	public int chooseRandom(){
		Random randomGenerator = new Random();
		int rndNumber = randomGenerator.nextInt(this.getRowColValue());
		return rndNumber;
	}
}