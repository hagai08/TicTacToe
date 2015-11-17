import java.awt.Checkbox;
import java.util.Scanner;

public class TicTacToeGame implements Game{

	static Board b;
	static char c;

	/**
	 * Starts New Game
	 * Opens new Board and starts the Game
	 */
	public void init() {
		b=new Board();
	}

	/**
	 * Changes signs
	 */
	public static void changeSign() {
		if (c=='x') c='y';
		if (c=='y') c='x';
	}


	/**
	 * Checks who wins
	 * It will work after every player's turn until the end
	 * Will be operated after 3 turns-  
	 */
	/*i'v changed type checkWin function
	 * need to return parameter to Board instead of char[][]
	*/
	public static boolean checkWin(char[][] b, char c) {
		
		int count=0;
		
		for (int i = 0; i < b.length; i++) {//check latitude
			for (int j = 0; j < b.length; j++) {
				if (b[i][j] == c){
					count++;
				}
			}
			if (count == b.length) {
				System.out.println("player "+c+ " wins!"+" at line "+i);
				return true;
			}
			count=0;
		}
		
		for (int i = 0; i < b.length; i++) {//check longitude
			for (int j = 0; j < b.length; j++) {
				if (b[j][i] == c){
					count++;
				}
			}
			if (count == b.length) {
				System.out.println("player "+c+ " wins!"+" at column ");
				return true;
			}
			count=0;
		}
		
		count=0;
		for (int i = 0; i < b.length; i++) {//check primary diagonal
			if (b[i][i] == c){
				count++;
			}		
		}
		if (count == b.length){
			System.out.println("player "+c+ " wins! primary diagonal!");
			return true;
		}
		
		
		count=0;
		int j=b.length-1;
		for (int i = 0; i < b.length; i++) {//check secondary diagonal						
			char arrChar=b[i][j];
			if (arrChar == c){
					count++;
			}		
			j--;	
		}
		if (count == b.length){
			System.out.println("player "+c+ " wins! secondary diagonal!");
			return true;
		}
		
		return false;

	}

	
	public static playGame(){
		init();
		//אולי אפשר לעשות איזה רנדום שיהיה כמו הטלת מטבע לקבוע מי יתחיל...
		c='x';
		int l= b.length;
		int p, q;
		Scanner in = new Scanner(System.in);
		for (int i = 0; i <= l*l; i++) {//loop to determine turn number
			System.out.println("tunn number "+i);
			System.out.println("enter to numbers to determine location of your sign");
			p=in.nextInt();
			q=in.nextInt();
			b.setPlay(p, q, c);
			if (i >= 2){
				if (checkWin(b, c)) break;//need to fix parameter b
			}
			
			changeSign();
		}
		System.out.println("It's a tie!");
	}

	public static void main(String[] args) {

		//init(); why Eclipse asks me to change INIT to STATIC?

		char[][] b= {{'x','x','x'}
					,{'y','x','y'}
					,{'x','x','x'}};
	//	Board br=new Board(b);
		
		checkWin(b, 'x');
	}

}
