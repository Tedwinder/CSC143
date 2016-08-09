//Connect Four by Komisi Petelo, Mina Akhnoukh, and Nolan Briggs 

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class ConnectFour {

	private JFrame frmConnectFour;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;
	private int turnCounter = 1;
	private static int SPACER = 5;
	private static int GRID_WIDTH = 50;
	private static int BOARD_WIDTH = 7;
	private static int BOARD_HEIGHT = 6;
	private static ArrayList<ArrayList> boardArray;
	private static Player playerOne, playerTwo, activePlayer;
	private static Grid targetGrid;
	private static boolean gameWinner = false;
	private JLabel lblActivePlayerText;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectFour window = new ConnectFour();
					window.frmConnectFour.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConnectFour() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JOptionPane.showMessageDialog(null,"Connect Four by Komisi Petelo, Mina Akhnoukh, and Nolan Briggs");

		playerOne = playerSetup(1, Color.BLUE);
		playerTwo = playerSetup(2, Color.RED);
		activePlayer = playerOne;

		frmConnectFour = new JFrame();
		frmConnectFour.setTitle("Connect Four!");
		frmConnectFour.setBounds(100, 100, 409, 462);
		frmConnectFour.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnectFour.getContentPane().setLayout(null);

		btn1 = new JButton("1");
		btn1.addActionListener(new Btn1ActionListener());
		btn1.setBounds(SPACER, ((BOARD_HEIGHT + 1) * (GRID_WIDTH + SPACER)), GRID_WIDTH, 25);
		frmConnectFour.getContentPane().add(btn1);

		btn2 = new JButton("2");
		btn2.addActionListener(new Btn2ActionListener());
		btn2.setBounds((SPACER * 2) + GRID_WIDTH, ((BOARD_HEIGHT + 1) * (GRID_WIDTH + SPACER)), GRID_WIDTH, 25);
		frmConnectFour.getContentPane().add(btn2);

		btn3 = new JButton("3");
		btn3.addActionListener(new Btn3ActionListener());
		btn3.setBounds((SPACER * 3) + (GRID_WIDTH * 2), ((BOARD_HEIGHT + 1) * (GRID_WIDTH + SPACER)), GRID_WIDTH, 25);
		frmConnectFour.getContentPane().add(btn3);

		btn4 = new JButton("4");
		btn4.addActionListener(new Btn4ActionListener());
		btn4.setBounds((SPACER * 4) + (GRID_WIDTH * 3), ((BOARD_HEIGHT + 1) * (GRID_WIDTH + SPACER)), GRID_WIDTH, 25);;
		frmConnectFour.getContentPane().add(btn4);

		btn5 = new JButton("5");
		btn5.addActionListener(new Btn5ActionListener());
		btn5.setBounds((SPACER * 5) + (GRID_WIDTH * 4), ((BOARD_HEIGHT + 1) * (GRID_WIDTH + SPACER)), GRID_WIDTH, 25);;
		frmConnectFour.getContentPane().add(btn5);

		btn6 = new JButton("6");
		btn6.addActionListener(new Btn6ActionListener());
		btn6.setBounds((SPACER * 6) + (GRID_WIDTH * 5), ((BOARD_HEIGHT + 1) * (GRID_WIDTH + SPACER)), GRID_WIDTH, 25);;
		frmConnectFour.getContentPane().add(btn6);

		btn7 = new JButton("7");
		btn7.addActionListener(new Btn7ActionListener());
		btn7.setBounds((SPACER * 7) + (GRID_WIDTH * 6), ((BOARD_HEIGHT + 1) * (GRID_WIDTH + SPACER)), GRID_WIDTH, 25);;
		frmConnectFour.getContentPane().add(btn7);

		lblActivePlayerText = new JLabel("Active player text");
		lblActivePlayerText.setForeground(Color.BLACK);
		lblActivePlayerText.setBackground(Color.LIGHT_GRAY);
		lblActivePlayerText.setFont(new Font("Consolas", lblActivePlayerText.getFont().getStyle() | Font.BOLD, lblActivePlayerText.getFont().getSize() + 5));
		lblActivePlayerText.setHorizontalAlignment(SwingConstants.CENTER);
		lblActivePlayerText.setBounds(5, 5, (GRID_WIDTH * 7) + (SPACER * 6), GRID_WIDTH - SPACER);
		lblActivePlayerText.setBorder(BorderFactory.createLineBorder(Color.black));
		frmConnectFour.getContentPane().add(lblActivePlayerText);

		generateGrid(); //set up our game grid!
		updateTurnLabel(); //set the first person's turn!
	}

	private Player playerSetup(int playerNum, Color color) {
		boolean validEntry = false;

		do {
			String prompt = "Player " + playerNum + ", enter your name!";
			String response = JOptionPane.showInputDialog(prompt);


			if (response == null || response.replaceAll("\\s+","").isEmpty() ){
				if (playerNum == 1){
					String[] names = {"Captain Qwark", "M. Night Shamamallamasama", "Iron Guts Kelly", "Sgt. Sarcasm", "THE NULL", "Tron", "Dot Matrix", "Skynet", "GLaDoS (the potato)", "Deep Thought"};
					Random randomGen = new Random();
					int random = randomGen.nextInt(10);
					response = names[random];
					JOptionPane.showMessageDialog(null, "Fine, then you shall be named:\n" + response);
				} else {
					String[] names = {"Dr. Nefarious", "Mickey Bay", "Ferret Face Burns", "Captain Oblivious", "THE VOID", "Clu", "Bob", "Da Terminator", "Baby Chell", "Arthur Dent"};
					Random randomGen = new Random();
					int random = randomGen.nextInt(10);
					response = names[random];
					JOptionPane.showMessageDialog(null, "A wise guy, eh?\nThen you shall be called:\n" + response);				
				}
			}
			Color playerColor = color;
			Player genPlayer = new Player(playerNum, playerColor, response);
			return genPlayer;
		} while (!validEntry);
	}

	private void generateGrid() {

		ArrayList<ArrayList> tempArray = new ArrayList<ArrayList>();
		for (int x = 1; x <= BOARD_WIDTH; x++){

			ArrayList<Grid> gridArray = new ArrayList<Grid>();

			for (int y = 1; y <= BOARD_HEIGHT; y ++){

				Grid grid = new Grid();
				grid.setForeground(Color.BLACK);
				grid.setBackground(Color.GRAY);
				grid.setBounds((SPACER * x) + (GRID_WIDTH * (x-1)), (GRID_WIDTH * y) + (SPACER * y), GRID_WIDTH, GRID_WIDTH);
				frmConnectFour.getContentPane().add(grid);

				grid.setXBlock(x-1);
				grid.setYBlock(y-1);
				gridArray.add(grid);
			}
			tempArray.add(gridArray);
		}
		boardArray = tempArray;
	}

	private class Btn1ActionListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			int xTarget = 0;
			checkColumn(xTarget);
			checkVictory(xTarget);
		}
	}

	private void checkColumn(int column) {
		int xTarget = column;	

		ArrayList<Grid> yArray = boardArray.get(xTarget);
		int yTarget = yArray.size()-1;

		boolean doneYet = false;
		boolean canPlace = true;
		do {
			Grid grid = yArray.get(yTarget);

			if (!grid.isFilled()) {
				doneYet = true;
				targetGrid = grid;
				break;
			} else {
				if (yTarget == 0) {
					errorMessage();
					canPlace = false;
					break;
				}
				yTarget--;
			}

		} while (!doneYet); 

		if (canPlace) {
			targetGrid.setBackground(activePlayer.getPlayerColor());
			targetGrid.setPlayerOwner(activePlayer.getPlayerNum());	
		}
	}

	private void updateTurnLabel() {
		lblActivePlayerText.setText(activePlayer.getPlayerName() + "'s Turn!");
	}

	private void changePlayer() {
		if ((activePlayer.getPlayerNum()) == 2){
			activePlayer = playerOne; //player two had their turn, player 1 is next
		} else {
			activePlayer = playerTwo; //player one had their turn, player 2 is next
		}
		turnCounter++; 
		/* Yes, the lines above were intentional.
		 * Should a player be clumsy, sarcastic, or (heaven forbid) foolish enough
		 * to place a piece at the top of a full column,
		 * they fully deserve to lose their turn. :)
		 */
	}

	private void errorMessage() {
		JOptionPane.showMessageDialog(null, "You can't put a piece there!\nHaha, you lose your turn!");

		if (activePlayer.getPlayerNum() == 1){
			JOptionPane.showMessageDialog(null, "Player 2, your turn!");
		} else {
			JOptionPane.showMessageDialog(null, "Player 1, your turn!");
		}
		targetGrid = null;
	}

	private class Btn2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int xTarget = 1;	
			checkColumn(xTarget);
			checkVictory(xTarget);
		}
	}
	private class Btn3ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int xTarget = 2;	
			checkColumn(xTarget);
			checkVictory(xTarget);
		}
	}
	private class Btn4ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int xTarget = 3;	
			checkColumn(xTarget);
			checkVictory(xTarget);
		}
	}
	private class Btn5ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int xTarget = 4;	
			checkColumn(xTarget);
			checkVictory(xTarget);
		}
	}
	private class Btn6ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int xTarget = 5;	
			checkColumn(xTarget);
			checkVictory(xTarget);
		}
	}
	private class Btn7ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int xTarget = 6;	
			checkColumn(xTarget);
			checkVictory(xTarget);
		}
	}
	private void checkVictory(int activeColumn){
		if (targetGrid != null){
			int gridY = targetGrid.getYBlock();
			int horizCount = 1;
			int vertCount = 1;
			int negDiagCount = 1;
			int posDiagCount = 1;

			ArrayList<Grid> testColumn = boardArray.get(activeColumn);
			Grid activeGrid = testColumn.get(gridY);

			vertCount = testDown(activeGrid, activeColumn, vertCount);
			horizCount = testRight(activeGrid, activeColumn, horizCount);
			horizCount = testLeft(activeGrid, activeColumn, horizCount);
			negDiagCount = testUpLeft(activeGrid, activeColumn, negDiagCount);
			negDiagCount = testDownRight(activeGrid, activeColumn, negDiagCount);
			posDiagCount = testDownLeft(activeGrid, activeColumn, posDiagCount);
			posDiagCount = testUpRight(activeGrid, activeColumn, posDiagCount);

			if (horizCount >= 4 || vertCount >= 4 || negDiagCount >= 4 || posDiagCount >= 4){
				gameWinner = true;
			}

			if (gameWinner) {
				JOptionPane.showMessageDialog(null, activePlayer.getPlayerName() + " has won the game!\n" + 
						"It took " + turnCounter + " turns to do so!\n" + generateWittyRemark());
				System.exit(3); //close program
			} 
		}
		if (turnCounter > 43) {
			forceDraw();
		}
		changePlayer();
		updateTurnLabel();
	}

	private void forceDraw() {
		JOptionPane.showMessageDialog(null, playerOne.getPlayerName() + "!\n" + playerTwo.getPlayerName() + "!\n" + 
				"Y'all need to take this serious!\n\n Come back when you can play properly!");
		System.exit(3); //close program
	}

	private String generateWittyRemark() {
		String remark;
		if (turnCounter < 7) {
			remark = "Did you cheat or did we have a bug?";
		} else if (turnCounter == 7) {
			remark = "Was this a test, or was someone drinking?";
		} else if (turnCounter < 12) {
			remark = "That was...quick.";
		} else if (turnCounter < 24 ) {
			remark = "Good game!";
		} else if (turnCounter < 36 ) {
			remark = "Do you guys have a system for this?";
		} else if (turnCounter < 41 ) {
			remark = "You really didn't want to lose!";
		} else if (turnCounter == 41 ){
			remark = "Holy cheese!\nIf this was a legitimate match,\nI want a video!";
		} else {
			remark = "Now how about double or nothing?";
		}
		return remark;
	}

	private int testUpRight(Grid activeGrid, int activeColumn, int posDiagCount) {
		int gridY = targetGrid.getYBlock();
		int gridX = targetGrid.getXBlock();
		ArrayList<Grid> testColumn = boardArray.get(activeColumn);
		int returnCount = posDiagCount;

		testColumn = boardArray.get(activeColumn);
		activeGrid = testColumn.get(gridY);

		if (activeGrid.getXBlock() != BOARD_WIDTH - 1 && activeGrid.getYBlock() != 0) {

			Grid gridToTest = (Grid) boardArray.get(gridX + 1).get(gridY - 1);

			boolean keepGoing = true;

			do {
				if (activeGrid.getPlayerOwner() == gridToTest.getPlayerOwner()){
					returnCount++;
					activeGrid = gridToTest;
					if (activeGrid.getXBlock() != BOARD_WIDTH - 1 && activeGrid.getYBlock() != 0){
						gridToTest = (Grid) boardArray.get((activeGrid.getXBlock() + 1)).get(activeGrid.getYBlock() - 1);
					} else {
						keepGoing = false;
						break;
					}
				} else {
					keepGoing = false;
					break;
				}
			}while (keepGoing);
		}
		return returnCount;
	}

	private int testDownRight(Grid activeGrid, int activeColumn, int negDiagCount) {
		int gridY = targetGrid.getYBlock();
		int gridX = targetGrid.getXBlock();
		ArrayList<Grid> testColumn = boardArray.get(activeColumn);
		int returnCount = negDiagCount;

		testColumn = boardArray.get(activeColumn);
		activeGrid = testColumn.get(gridY);

		if (activeGrid.getXBlock() != BOARD_WIDTH - 1 && activeGrid.getYBlock() != BOARD_HEIGHT - 1) {

			Grid gridToTest = (Grid) boardArray.get(gridX + 1).get(gridY + 1);

			boolean keepGoing = true;

			do {
				if (activeGrid.getPlayerOwner() == gridToTest.getPlayerOwner()){
					returnCount++;
					activeGrid = gridToTest;
					if (activeGrid.getXBlock() != BOARD_WIDTH - 1 && activeGrid.getYBlock() != BOARD_HEIGHT - 1){
						gridToTest = (Grid) boardArray.get((activeGrid.getXBlock() + 1)).get(activeGrid.getYBlock() + 1);
					} else {
						keepGoing = false;
						break;
					}
				} else {
					keepGoing = false;
					break;
				}
			}while (keepGoing);
		}
		return returnCount;
	}

	private int testDownLeft(Grid activeGrid, int activeColumn, int posDiagCount) {
		int gridY = targetGrid.getYBlock();
		int gridX = targetGrid.getXBlock();
		ArrayList<Grid> testColumn = boardArray.get(activeColumn);
		int returnCount = posDiagCount;

		testColumn = boardArray.get(activeColumn);
		activeGrid = testColumn.get(gridY);

		if (activeGrid.getXBlock() != 0 && activeGrid.getYBlock() != BOARD_HEIGHT - 1) {

			Grid gridToTest = (Grid) boardArray.get(gridX - 1).get(gridY + 1);

			boolean keepGoing = true;

			do {
				if (activeGrid.getPlayerOwner() == gridToTest.getPlayerOwner()){
					returnCount++;
					activeGrid = gridToTest;
					if (activeGrid.getXBlock() != 0 && activeGrid.getYBlock() != BOARD_HEIGHT - 1){
						gridToTest = (Grid) boardArray.get((activeGrid.getXBlock() - 1)).get(activeGrid.getYBlock() + 1);
					} else {
						keepGoing = false;
						break;
					}
				} else {
					keepGoing = false;
					break;
				}
			}while (keepGoing);
		}
		return returnCount;
	}

	private int testUpLeft(Grid activeGrid, int activeColumn, int negDiagCount) {
		int gridY = targetGrid.getYBlock();
		int gridX = targetGrid.getXBlock();
		ArrayList<Grid> testColumn = boardArray.get(activeColumn);
		int returnCount = negDiagCount;

		testColumn = boardArray.get(activeColumn);
		activeGrid = testColumn.get(gridY);

		if (activeGrid.getXBlock() != 0 && activeGrid.getYBlock() != 0) {


			Grid gridToTest = (Grid) boardArray.get(gridX - 1).get(gridY - 1);

			boolean keepGoing = true;
			do {
				if (activeGrid.getPlayerOwner() == gridToTest.getPlayerOwner()){
					returnCount++;
					activeGrid = gridToTest;
					if (activeGrid.getXBlock() != 0 && activeGrid.getYBlock() != 0){
						gridToTest = (Grid) boardArray.get((activeGrid.getXBlock() - 1)).get(activeGrid.getYBlock() - 1);
					} else {
						keepGoing = false;
						break;
					}
				} else {
					keepGoing = false;
					break;
				}
			}while (keepGoing);
		}
		return returnCount;
	}

	private int testLeft(Grid activeGrid, int activeColumn, int horizCount) {
		int gridY = targetGrid.getYBlock();
		int gridX = targetGrid.getXBlock();
		ArrayList<Grid> testColumn = boardArray.get(activeColumn);
		int returnCount = horizCount;

		testColumn = boardArray.get(activeColumn);
		activeGrid = testColumn.get(gridY);

		if (activeGrid.getXBlock() != 0) {

			Grid gridToTest = (Grid) boardArray.get(gridX - 1).get(gridY);

			boolean keepGoing = true;

			do {
				if (activeGrid.getPlayerOwner() == gridToTest.getPlayerOwner()){
					returnCount++;
					activeGrid = gridToTest;
					if (activeGrid.getXBlock() != 0){
						gridToTest = (Grid) boardArray.get((activeGrid.getXBlock() - 1)).get(gridY);
					} else {
						keepGoing = false;
						break;
					}
				} else {
					keepGoing = false;
					break;
				}
			}while (keepGoing);
		}
		return returnCount;
	}

	private int testRight(Grid activeGrid, int activeColumn, int horizCount) {
		int gridY = targetGrid.getYBlock();
		int gridX = targetGrid.getXBlock();
		ArrayList<Grid> testColumn = boardArray.get(activeColumn);
		int returnCount = horizCount;

		testColumn = boardArray.get(activeColumn);
		activeGrid = testColumn.get(gridY);

		if (activeGrid.getXBlock() < BOARD_WIDTH - 1) {

			Grid gridToTest = (Grid) boardArray.get(gridX + 1).get(gridY);

			boolean keepGoing = true;

			do {
				if (activeGrid.getPlayerOwner() == gridToTest.getPlayerOwner()){
					returnCount++;
					activeGrid = gridToTest;
					if (activeGrid.getXBlock() != BOARD_WIDTH - 1){
						gridToTest = (Grid) boardArray.get((activeGrid.getXBlock() + 1)).get(gridY);
					} else {
						keepGoing = false;
						break;
					}
				} else {
					keepGoing = false;
					break;
				}
			}while (keepGoing);
		}
		return returnCount;
	}

	private int testDown(Grid activeGrid, int activeColumn, int vertCount) {
		int gridY = targetGrid.getYBlock();
		ArrayList<Grid> testColumn = boardArray.get(activeColumn);
		int returnCount = vertCount;


		testColumn = boardArray.get(activeColumn);
		activeGrid = testColumn.get(gridY);

		if (activeGrid.getYBlock() != BOARD_HEIGHT - 1) {

			Grid gridToTest = testColumn.get(gridY + 1);

			boolean keepGoing = true;
			do {
				if (activeGrid.getPlayerOwner() == gridToTest.getPlayerOwner()){
					returnCount++;
					activeGrid = gridToTest;
					if (activeGrid.getYBlock() != BOARD_HEIGHT - 1){
						gridToTest = testColumn.get(gridToTest.getYBlock() + 1);
					} else {
						keepGoing = false;
						break;
					}
				} else {
					keepGoing = false;
					break;
				}
			}while (keepGoing);
		}
		return returnCount;
	}
}
