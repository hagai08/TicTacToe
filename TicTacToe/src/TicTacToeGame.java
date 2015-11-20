import java.util.Scanner;

//implements Game
public class TicTacToeGame {

	static Board b;
	static IO io;

	
	/**
	 * Starts New Game
	 * Opens new Board and starts the Game
	 */
	public static void initB() {
		b=new Board();
	}

	public static void initIO() {
		io=new IO();
	}

	
	@SuppressWarnings("resource")
	public static void playGame(){
		initB();
		initIO();
				
		int l= b.length;
		int p, q;
		Scanner in = new Scanner(System.in);
		
		for (int i = 0; i <= l*l; i++) {//loop to determine turn number
			
			System.out.println("turn number "+i);
			System.out.println("enter to numbers to determine location of your sign");
			p=in.nextInt();
			q=in.nextInt();
			b.setPlay(p, q, io.getC());
			b.printBoard();
			if (i >= 2){
				if (io.checkWin(b, io.getC())) break;
			}
			
			io.changeSign(io.getC());
		}
		System.out.println("It's a tie!");
	}

	public static void main(String[] args) {
		
		//why i had to change both init functions to be static?
		
		playGame();
		
		

	
		
	}

}
