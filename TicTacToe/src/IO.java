import java.util.Scanner;

public class IO {
	
	char c;
	String output;
	int p,q;
	private Scanner in;
	int turnNum;
	
	
	protected int getP() {
		return p;
	}

	protected int getQ() {
		return q;
	}

	protected IO(){
		c='x';		
	}
	
	//need to check input- out of board bounds
	protected void getInput(int i){
		turnNum = i;
		in = new Scanner(System.in);
		printOutput("turn number "+i);
		printOutput("now it's turn of "+ getC()+" player");
		printOutput("enter two numbers to determine location of your sign");
		this.p=in.nextInt();
		this.q=in.nextInt();
		ioCheck(this.p,this.q);
		
	}
	
	protected void setPQ(int p, int q){
		this.p=p;
		this.q=q;
	}
	
	
	
	
	protected IO(char c) {
		this.c = c;
	}
	
	protected void printOutput(String out) {
		System.out.println(out);
	}

	protected void ioCheck(int p, int q){
		if ( ( p < 0 ) || ( p > 2 )  ||  ( q < 0 ) || ( q > 2 ) ){
			System.out.println("Out of Bounds of GameBoardS");
			getInput(turnNum);
		}
				
	}
	
	
	protected char getC() {
		return c;
	}

	protected void setC(char c) {
		this.c = c;
	}

	/**
	 * Changes signs
	 */
	protected void changeSign(char ch) {
		
		if (ch =='x') this.c='y';
		if (ch =='y') this.c='x';
	}

	
	
	/**
	 * Checks who wins
	 * It will work after every player's turn until the end
	 * Will be operated after 3 turns-  
	 */
	/*i'v changed type checkWin function
	 * 
	 * maybe i can check win with one run on the matrix-4 counters.
	 * 
	 *maybe return value need to be  : win lose or tie.
	 */
	public boolean checkWin(Board b, char c) {
		
		int count=0;
		
		for (int i = 0; i < b.length; i++) {//check latitude
			for (int j = 0; j < b.length; j++) {
				if (b.getCell(i, j) == c){
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
				if (b.getCell(j, i) == c){
					count++;
				}
			}
			if (count == b.length) {
				System.out.println("player "+c+ " wins!"+" at column "+i);
				return true;
			}
			count=0;
		}
		
		count=0;
		for (int i = 0; i < b.length; i++) {//check primary diagonal
			if (b.getCell(i, i) == c){
				count++;
			}		
		}
		if (count == b.length){
			System.out.println("player "+c+ " wins! primary diagonal!");
			return true;
		}
		
		
		count=0;
		int j=b.length-1;
		for (int i = 0; i < b.length; i++) {//check secondary diagonal- ne			
			char arrChar=b.getCell(i, j);
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




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
