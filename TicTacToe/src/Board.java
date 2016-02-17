
public class Board {

	char[][] board;
	int length;

	
	protected Board(){
		board = new char[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j]='_';
			}
		}
		length=3;
	}
	
	protected boolean isUsed(int p, int q){
		
		if ( ( board[p][q] == 'x' ) || ( board[p][q] == 'y' ) ){
			
			return true;
		}
		else{
			
			return false;
		}
	}

	protected void printBoard(){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if ( j == board.length-1){
					System.out.print(board[i][j]);
				}
				else{
					System.out.print(board[i][j]+" ,");
				}
			}
			System.out.println();	
		}
	}

	protected char getCell(int i, int j) {
		return board[i][j];
	}

	/**
	 * Fills board with X or Y.
	 * @param x latitude
	 * @param y longitude 
	 */
	protected void setPlay(int x, int y, char c) {
		board[x][y] = c;		
	}


}
