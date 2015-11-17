
public class Board {

	char[][] board;
	int length;

	protected Board(){
		board = new char[3][3];
		length=3;
	}
	

	protected Board(char[][] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				board[i][j]=arr[i][j];
			}
		}
	}
	
	protected void printBoard(Board b){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(b.getCell(i, j)+" ,");
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
