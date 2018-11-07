package connect;

public class Board {
	Disk board[][] = new Disk[6][7];
	private int lastRow;
	
	public Board() {}
	
	public boolean dropDisk(int col, Disk disk) {
		int row;
		row=emptyRow(col);
		
		if(row<0) return false;
		lastRow=row;
		board[row][col]= disk;
		
		return true;
	}
	
	public boolean isFull() {
		for(int i=0; i<6; i++) {
			if(board[0][i]==null) return false;
		}
		return true;
	}
	
 	public void displayBoard() {
		for(int i=0; i<=5; i++) {
			for(int j=0; j<=6; j++) {
				if(board[i][j]!=null) {
					if(board[i][j].getColor().equals("Blue")) System.out.print(board[i][j].getColor()+ "|");
					else System.out.print(board[i][j].getColor()+ " |");
				}
				else System.out.print("    |");
			}
			System.out.print("\n");
		}
	}
	
	public boolean checkWin(int row, int col) {
		String initColor=board[row][col].getColor();
		
		if(checkRight(row, col, initColor)) return true;
		if(checkLeft(row, col, initColor)) return true;
		if(checkDown(row, col, initColor)) return true;
		if(checkLDiag(row, col, initColor)) return true;
		if(checkRDiag(row, col, initColor)) return true;
		
		return false;
	}
	
	private boolean checkRDiag(int row, int col, String initColor) {
		int connected=0;
		
		for(int i=0; i<4; i++) {
			if(row>5 || col>6) return false;
			if(board[row][col]==null) return false;
			if(board[row][col].getColor().equals(initColor)) {
				connected++;
				if(connected==4) {
					System.out.println("Found a winner!");
					return true;
				}
			}
			row++;
			col++;
		}
		
		return false;
	}
	
	private boolean checkLDiag(int row, int col, String initColor) {
		int connected=0;
		
		for(int i=0; i<4; i++) {
			if(row>5 || col<0) return false;
			if(board[row][col]==null) return false;
			if(board[row][col].getColor().equals(initColor)) {
				connected++;
				if(connected==4) {
					System.out.println("Found a winner!");
					return true;
				}
			}
			row++;
			col--;
		}
		
		return false;
	}
	
	private boolean checkDown(int row, int col, String initColor) {
		int tempRow=row, connected=0;
		
		for(int i=0; i<4; i++) {
			
			if(tempRow>5) return false;
			if(board[tempRow][col]==null) return false;
			if(board[tempRow][col].getColor().equals(initColor)) {
				connected++;
				if(connected==4) {
					System.out.println("Found a winner!");
					return true;
				}
			}
			tempRow++;
		}
		
		return false;
	}
	
	private boolean checkLeft(int row, int col, String initColor) {
		int tempCol=col, connected=0;
		
		for(int i=0; i<4; i++) {
			
			if(tempCol<0) return false;
			if(board[row][tempCol]==null) return false;
			if(board[row][tempCol].getColor().equals(initColor)) {
				connected++;
				if(connected==4) {
					System.out.println("Found a winner!");
					return true;
				}
			}
			tempCol--;
		}
		
		return false;
	}
	
	private boolean checkRight(int row, int col, String initColor) {
		int tempCol=col, connected=0;
		for(int i=0; i<4; i++) {
			
			if(tempCol>6) return false;
			
			if(board[row][tempCol]==null) return false;
			if(board[row][tempCol].getColor().equals(initColor)) {
				connected++;
				if(connected==4) {
					System.out.println("Found a winner!");
					return true;
				}
			}
			tempCol++;
		}
		
		return false;
	}
	
	public int getLastRow() {
		return this.lastRow;
	}
	
	//This function returns how far down the disk is going
	private int emptyRow(int col) {
		for(int i=0; i<=5; i++) {
			if(board[i][col]!=null) {
				return i-1;
			}
		}
		return 5;
	}
	
}
