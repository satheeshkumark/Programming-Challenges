package TicTacToe;

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
