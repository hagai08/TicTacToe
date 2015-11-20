
public class IO {
	
	char c;
	
	protected IO(){
		c='x';
	}

	protected IO(char c) {
		this.c = c;
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
				if (b.getCell(i, j) == c){
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
		for (int i = 0; i < b.length; i++) {//check secondary diagonal						
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
