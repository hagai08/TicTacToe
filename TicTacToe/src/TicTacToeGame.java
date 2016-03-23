
public class TicTacToeGame implements Game{

	private Board b;
	private IO io;

	
	public TicTacToeGame(){
		playGame();
	}

	public void init(){
		b = new Board();
		io = new IO();
	}
	
	public void changePlayer(){
		io.changeSign(io.getC());
	}
	
	/**
	 * Checks who wins
	 * It will work after every player's turn until the end
	 */
	public boolean checkWin(Board b) {
		
		int count=0;
		
		char c = io.getC();
		
		
		for (int i = 0; i < b.getBoardLength(); i++) {//check latitude
			for (int j = 0; j < b.getBoardLength(); j++) {
				if (b.getCell(i, j) == c){
					count++;
				}
			}
			if (count == b.getBoardLength()) {
				System.out.println("player "+c+ " wins!"+" at line "+i);
				return true;
			}
			count=0;
		}
		
		for (int i = 0; i < b.getBoardLength(); i++) {//check longitude
			for (int j = 0; j < b.getBoardLength(); j++) {
				if (b.getCell(j, i) == c){
					count++;
				}
			}
			if (count == b.getBoardLength()) {
				System.out.println("player "+c+ " wins!"+" at column "+i);
				return true;
			}
			count=0;
		}
		
		count=0;
		for (int i = 0; i < b.getBoardLength(); i++) {//check primary diagonal
			if (b.getCell(i, i) == c){
				count++;
			}		
		}
		if (count == b.getBoardLength()){
			System.out.println("player "+c+ " wins! primary diagonal!");
			return true;
		}
		
		
		count=0;
		int j=b.getBoardLength()-1;
		for (int i = 0; i < b.getBoardLength(); i++) {//check secondary diagonal- ne			
			char arrChar=b.getCell(i, j);
			if (arrChar == c){
					count++;
			}		
			j--;	
		}
		
		
		if (count == b.getBoardLength()){
			System.out.println("player "+c+ " wins! secondary diagonal!");
			return true;
		}
		
		return false;

	}


	public void playGame(){
		
		init();
		
		boolean thereIsWin = false;
		boolean ioIsOK = true;

		int length= b.getBoardLength();
		int numberOfTurns = length*length;

		//loop to determine turn number
		for (int i = 1; i <= numberOfTurns; i++) {

			while (ioIsOK){
				
				io.getInput(i);
				ioIsOK = b.isUsed(io.getP(), io.getQ());
				
			}
			
			ioIsOK = true;
			
			b.setPlay(io.getP(), io.getQ(), io.getC());
			b.printBoard();

			if (i >= 2){
				
				if (checkWin(b)){
					thereIsWin  = true;
					break;
				}
			}
			
			changePlayer();
		}

		if ( !thereIsWin  ){
			io.printOutput("It's a tie!");
		}
	}

	
	public static void main(String[] args) {

		new TicTacToeGame();


	}

}
