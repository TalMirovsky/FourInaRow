import java.awt.EventQueue;
import java.util.Scanner;

public class Main {
	
	static char winner;
	private final static int rows = 6;
	private final static int cols = 9;

	public static void main(String[] args) {
		
		Game game = new Game(rows, cols);
		
		// Launch the application
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View(cols, rows);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		while(!game.isEnd()) {
			
			winner = game.isWin(); // Checks the winning condition 
			if(winner != '0') {
			// There is a winner
				View.endMessage(winner);
			}	
		}
		
		// The game is over, there is no winner
		View.endMessage(winner);		

	}

}
