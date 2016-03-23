import java.util.Scanner;

public class IO {
	
	char c;
	String output;
	int p,q;
	private Scanner in;
	int turnNum;
	
	
	protected IO(){
		c='x';		
	}
	
	protected IO(char c) {
		this.c = c;
	}
	
	protected int getP() {
		return p;
	}

	protected int getQ() {
		return q;
	}

	protected void setPQ(int p, int q){
		this.p=p;
		this.q=q;
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



}
