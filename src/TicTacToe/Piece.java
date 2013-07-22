package TicTacToe;

/*	@author satheeshkumark
 * 
 * 	This class defines the basic data structures for Piece object 
 */

public class Piece {
	private Symbol sym;
	
	/* Initialize each new piece with the symbol s */
	public Piece(Symbol s){
		sym = s;
	}
	
	/* Returns the symbol associated with each piece */
	public Symbol getSym() {
		return sym;
	}	
}
