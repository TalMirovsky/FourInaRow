import java.util.Arrays;

public class Game {
	
	private static char[][] board = null;
	private static int rows;
	private static int columns;
	static char player= 'A';

	public Game(int rows, int columns) {
		super();
		Game.rows = rows;
		Game.columns = columns;
		board = new char[rows][columns];
		
		for(char[] row: board) 
			Arrays.fill(row, '0');
	}
	
	// Checks if the column is not full
	public static boolean isValid(int chosenColumn) {
		
		if(board[0][chosenColumn] != '0') {
			return false;
		}
		
		return true;
	}
	
	// Put the chip in the first free cell in the column and returns the row number of the free cell
	public static int putChip(int column, char player) {
		for(int i = rows-1; i >= 0 ; i--) {
			if(board[i][column] == '0') {
				if(player == 'A')
					board[i][column] = 'A';
				else
					board[i][column] = 'B';
				
				return i;
			}
		}
		return -1;
	}
	
	// Checks if there is a winning condition 
	public char isWin() {
		char temp;
		int move;
		for(int row = rows-1; row >= 0; row--) {
			for(int col = 0; col < columns; col++) {
				if(board[row][col] == '0') // Cell is empty
					continue;
				if(col + 3 < columns) {  // Check horizontal 
					temp = board[row][col];
					for(move = 1; move < 4; move++) {
						if(board[row][col + move] != temp)
							break;
					}
					if(move == 4)
						return temp;
				}
				if(row - 3 >= 0) {     // Check vertical
					temp = board[row][col];
					for(move = 1; move < 4; move++) {
						if(board[row - move][col] != temp)
							break;
					}
					if(move == 4)
						return temp;
				}
				if(row - 3 >= 0 && col + 3 < columns) {  // Check right diagonal
					temp= board[row][col];
					for(move = 1; move < 4; move++) {
						if(board[row - move][col + move] != temp)
							break;
					}
					if(move == 4)
						return temp;
				}
				if(row - 3 >= 0 && col - 3 >= 0) {    // Check left diagonal
					temp= board[row][col];
					for(move = 1; move < 4; move++) {
						if(board[row - move][col - move] != temp)
							break;
					}
					if(move == 4)
						return temp;
				}
			}
		}
		return '0';
	}
	
	// Checks if all columns are full
	public boolean isEnd() {
		for(char c : board[0]) {
			if(c == '0')
				return false;
		}
		return true;
	}
	
	// Checks if the chosen column is valid, put a chip and replace the players
	public static int playerMove(int chosenColumn) {
		int toReturn = -1;
		if(isValid(chosenColumn)) {
			toReturn = putChip(chosenColumn, player);
			player = player == 'A' ? 'B' : 'A';
		}
		return toReturn;
	}
	
}
