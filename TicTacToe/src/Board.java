
public class Board {
	
	char[][] board;
	
	protected Board(){
		this.board = new char[3][3];
	}
	
	protected char[][] getBoard() {
		return board;
	}

	protected void setBoard(int num) {
		this.board = new char[num][num];
	}



}
