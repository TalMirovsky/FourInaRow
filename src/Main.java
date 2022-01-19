import java.awt.EventQueue;

public class Main {
	
	static char winner;
	private static final int ROWS = 6;
	private static final int COLS = 9;

	public static void main(String[] args) {
		
		Game game = new Game(ROWS, COLS);
		
		// Launch the application
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View(COLS, ROWS);
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
