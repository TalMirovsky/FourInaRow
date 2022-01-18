

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;



public class View {

	JFrame frame;
	int result;
	private JLabel[][] chips;
	private JLabel lblColor;
	
	// Create the application
	public View(int cols, int rows) {
		initialize(cols, rows);
	}

	// Initialize the contents of the frame
	private void initialize(int cols, int rows) {
		frame = new JFrame("Four In a Row Game");
		frame.setBounds(100, 100, 629, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		// Create the game board
		chips = new JLabel[cols][rows];
		int i = 2;
		int j = 75;
		for(int col = 0; col < cols; col++) {
			for(int row = 0; row < rows; row++) {
				chips[col][row] = new JLabel("");
				chips[col][row].setIcon(new ImageIcon(View.class.getResource("/images/empty.png")));
				chips[col][row].setBounds(i, j, 58, 55);
				frame.getContentPane().add(chips[col][row]);
				
				j = j + 70;
			}
			i = i + 67;
			j = 75;
		}
		
		lblColor = new JLabel("");
		lblColor.setBounds(114, 485, 50, 43);
		lblColor.setIcon(new ImageIcon(View.class.getResource("/images/turnA.png")));
		frame.getContentPane().add(lblColor);
		
		JButton btn0 = new JButton("");
		btn0.setIcon(new ImageIcon(View.class.getResource("/images/push.png")));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result = Game.playerMove(0);
				putChipView(result, 0);
			}});
		btn0.setBounds(0, 0, 65, 73);
		frame.getContentPane().add(btn0);
		
		JButton btn1 = new JButton("");
		btn1.setIcon(new ImageIcon(View.class.getResource("/images/push.png")));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result = Game.playerMove(1);
				putChipView(result, 1);
			}});
		btn1.setBounds(66, 0, 65, 73);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("");
		btn2.setIcon(new ImageIcon(View.class.getResource("/images/push.png")));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result = Game.playerMove(2);
				putChipView(result, 2);
			}});
		btn2.setBounds(134, 0, 65, 73);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.setIcon(new ImageIcon(View.class.getResource("/images/push.png")));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result = Game.playerMove(3);
				putChipView(result, 3);
			}});
		btn3.setBounds(201, 0, 65, 73);
		frame.getContentPane().add(btn3);
		
		JButton btn4 = new JButton("");
		btn4.setIcon(new ImageIcon(View.class.getResource("/images/push.png")));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result = Game.playerMove(4);
				putChipView(result, 4);
			}});
		btn4.setBounds(270, 0, 65, 73);
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("");
		btn5.setIcon(new ImageIcon(View.class.getResource("/images/push.png")));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result = Game.playerMove(5);
				putChipView(result, 5);
			}});
		btn5.setBounds(338, 0, 65, 73);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("");
		btn6.setIcon(new ImageIcon(View.class.getResource("/images/push.png")));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result = Game.playerMove(6);
				putChipView(result, 6);
			}});
		btn6.setBounds(403, 0, 65, 73);
		frame.getContentPane().add(btn6);
		
		JButton btn7 = new JButton("");
		btn7.setIcon(new ImageIcon(View.class.getResource("/images/push.png")));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result = Game.playerMove(7);
				putChipView(result, 7);
			}});
		btn7.setBounds(469, 0, 65, 73);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("");
		btn8.setIcon(new ImageIcon(View.class.getResource("/images/push.png")));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result = Game.playerMove(8);
				putChipView(result, 8);
			}});
		btn8.setBounds(535, 0, 65, 73);
		frame.getContentPane().add(btn8);
		
		JLabel lblTurn = new JLabel("Turn of: ");
		lblTurn.setFont(new Font("Broadway", Font.BOLD, 20));
		lblTurn.setBounds(15, 495, 110, 20);
		frame.getContentPane().add(lblTurn);
		
	}
	
	// Shows end message for the game
	public static void endMessage(char winner) {
		String color = "";
		
		if(winner != '0') {   // There is a winner
			if(winner == 'A')
				color = "blue";
			else
				color = "red";
			
			JOptionPane.showMessageDialog(null, "The winner is the "+ color + " player");
		}
		else
			JOptionPane.showMessageDialog(null, "Game over! It's a tie :-)");
		
		System.exit(0);
	}
	
	// Update the board according to the users's selections
	private void putChipView(int result, int button) {
		
		if(result != -1) // The chosen column is not full
			chips[button][result].setIcon(new ImageIcon(View.class.getResource("/images/" + Game.player + ".png")));
		else
			JOptionPane.showMessageDialog(null, "Oops..The column is full. Please select another column");

		lblColor.setIcon(new ImageIcon(View.class.getResource("/images/turn" + Game.player + ".png")));	
	}
	
}
