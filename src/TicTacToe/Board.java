package TicTacToe;

/*	@author satheeshkumark
 * 
 * 	This class defines the basic data structures for board object 
 */

public class Board {
	private Piece[][] board;
	
	
	/* Initialize the Board */
	public Board(int rows, int columns) {
		if(rows > 0 && columns > 0)
			board = new Piece[rows][columns];
	}
	
	/* Prints the current content of the Board */
	public void printBoard() {
		if(board == null){
			System.out.println("Board has not been created yet");
			return;
		}
		System.out.println();
		System.out.println("==============BOARD====================");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == null) {
					System.out.print("_ ");
				}
				else if (board[i][j].getSym() == Symbol.Cross) {
					System.out.print("* ");
				}
				else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		System.out.println("==================================");
		System.out.println();
	}
	
	/* Places the input symbol at the respective position in the board */ 
	public int placeSymbol(int row, int column, Symbol sym) {
		if (row < 0 || column < 0 || board[row][column] != null) {
			return -2;
		}
		
		/* Place the symbol in the corresponding row and column position */
		board[row][column] = new Piece(sym);
		int flag = checkEndOfGame(row, column, sym);
		if(flag != 0 && isBoardFull() == 1){
				flag = 2;
		}
		this.printBoard();
		return flag;
	}
	
	/* Checks whether the game has ended */
	public int checkEndOfGame(int row, int column, Symbol sym){
		int flag = 0;
		flag = checkHorizontalLinePieces(row, sym);
		if(flag == -1)
			flag = checkVerticalLinePieces(row, sym);
		if(flag == -1)
			flag = checkDiagonalPieces(sym);
		return flag;		
	}
	
	/* Checks whether the Pieces in the diagonals are of same symbols */
	public int checkDiagonalPieces(Symbol sym){
		int row = 0;
		int column = 0;
		int flag = 0;
		while(row < board.length){
			if(board[row][column] != null && board[row][column].getSym() == sym){
				 row += 1;
				 column += 1;
			}
			else{
				flag = -1;
				break;
			}
		}
		column = 0;
		if(flag == -1){
			while(row >= 0){
				if(board[row][column] != null && board[row][column].getSym() == sym){
					 row -= 1;
					 column += 1;
				}
				else{
					flag = -1;
					break;
				}
			}
		}
		return flag;
	}
	
	
	/* Checks whether the Pieces in the horizontal line are of same symbols */
	public int checkHorizontalLinePieces(int row, Symbol sym){
		int flag = 0;
		int column = 0;
		while(column < board.length){
			if(board[row][column] != null && board[row][column].getSym() == sym)
				column += 1;
			else{
				flag = -1;
				break;
			}
		}
		return flag;
	}
	
	/* Checks whether the Pieces in the vertical line are of same symbols */
	public int checkVerticalLinePieces(int column, Symbol sym){
		int flag = 0;
		int row = 0;
		while(row < board.length){
			if(board[row][column] != null && board[row][column].getSym() == sym)
				row += 1;
			else{
				flag = -1;
				break;
			}
		}
		return flag;
	}
	
	public int isBoardFull(){
		int flag = 1;
		for(int i = 0 ; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] == null){
					flag = 0;
					break;
				}
			}
		}
		return flag;
	}
}