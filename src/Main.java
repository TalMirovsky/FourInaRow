import java.awt.EventQueue;
import java.util.Scanner;

public class Main {
	
	static char winner;

	public static void main(String[] args) {
		
		Game game = new Game(6,9);
		
		// Launch the application
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
