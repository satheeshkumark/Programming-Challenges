package TicTacToe;

/*	@author satheeshkumark
 * 
 * 	This class defines the basic data structures for Player object 
 */

public class Player {
	private Symbol sym;
	
	public Player(){
		
	}
	
	public Player(Symbol s){
		sym = s;
	}	
	
	public int playPiece(int row, int column) {
		return Game.getGameInstance().getBoard().placeSymbol(row, column, sym);
	}

	public Symbol getSym() {
		return sym;
	}
}
