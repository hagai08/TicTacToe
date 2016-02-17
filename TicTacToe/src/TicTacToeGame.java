
public class TicTacToeGame implements Game{

	Board b;
	IO io;

	public TicTacToeGame(){
		playGame();
	}




	public void playGame(){
		b=new Board();
		io=new IO();
		boolean flag=false;
		boolean ioCheck=true;

		int len= b.length;

		//loop to determine turn number
		for (int i = 1; i <= len*len; i++) {

			while (ioCheck){
				io.getInput(i);
				ioCheck= b.isUsed(io.getP(), io.getQ());
			}
			ioCheck=true;
			b.setPlay(io.getP(), io.getQ(), io.getC());

			b.printBoard();

			if (i >= 2){
				if (io.checkWin(b, io.getC())){
					flag=true;
					break;
				}
			}

			io.changeSign(io.getC());
		}

		if ( !flag ){
			io.printOutput("It's a tie!");
		}
	}

	public static void main(String[] args) {


		new TicTacToeGame();





	}

}
