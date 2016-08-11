//Connect Four by Komisi Petelo, Hana Bechara, Alex Gonzaga and Ted Callow 
package game;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;


public class ConnectFour {

	JFrame frmConnectFour;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;
	private JButton btn1_1;
	private int turnCounter = 1;
	private static int SPACER = 5;
	private static int GRID_WIDTH = 50; //Size of grid
	private static int BOARD_WIDTH = 7;// x axis (size of width)
	private static int BOARD_HEIGHT = 6;// y axis (size of height)
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
	 * @throws IOException 
	 */
	public ConnectFour() throws IOException {
		initialize();
	} 

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {

		JOptionPane.showMessageDialog(null,"Connect Four by Komisi Petelo, Hana Bechara, Alex Gonzaga, and Ted Callow");

		playerOne = playerSetup(1, Color.YELLOW);//player 1 && color; change by Alex: Changed to yellow for a different color scheme
		playerTwo = playerSetup(2, Color.RED);//player 2 && color
		activePlayer = playerOne;//player 1 begins

		frmConnectFour = new JFrame();
		frmConnectFour.setTitle("Connect Four!");
		frmConnectFour.setBounds(100, 100, 409, 462);
		frmConnectFour.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnectFour.getContentPane().setLayout(null);
		
		//each button calls a piece on the grid
		btn1 = new JButton("1");//button to throw square in the first column
		btn1_1 = new RoundButton("1"); // creates look of round button in background
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		//InputStream input = classLoader.getResourceAsStream("src/c4red2.jpg");
		//Image logo = ImageIO.read(input);
		InputStream input = getClass().getResourceAsStream("/c4yellow.jpg");
		Image logo = ImageIO.read(input);
		btn1_1.setIcon(new ImageIcon(logo));
		
		
		InputStream input2 = getClass().getResourceAsStream("/c4red.jpg");
		Image logo2 = ImageIO.read(input2);
		//btn1_1.setIcon(new ImageIcon(logo2));
		
		
		btn1_1.addActionListener(new Btn1ActionListener());
		btn1_1.setBounds(5, 18, GRID_WIDTH, 25); //spaces out the width of grid; moved all of the buttons to the top
		frmConnectFour.getContentPane().add(btn1_1);

		btn2 = new JButton("2");//button to throw square in the second column
		btn2 = new RoundButton("2"); // repeated for remaining buttons
		btn2.addActionListener(new Btn2ActionListener());
		btn2.setBounds(60, 18, GRID_WIDTH, 25);
		frmConnectFour.getContentPane().add(btn2);
		btn2.setIcon(new ImageIcon(logo));

		btn3 = new JButton("3");//button to throw square in the third column
		btn3 = new RoundButton("3"); 
		btn3.addActionListener(new Btn3ActionListener());
		btn3.setBounds(115, 18, GRID_WIDTH, 25);
		frmConnectFour.getContentPane().add(btn3);
		btn3.setIcon(new ImageIcon(logo));

		btn4 = new JButton("4");//button to throw square in the fourth column
		btn4 = new RoundButton("4");
		btn4.addActionListener(new Btn4ActionListener());
		btn4.setBounds(170, 18, GRID_WIDTH, 25);;
		frmConnectFour.getContentPane().add(btn4);
		btn4.setIcon(new ImageIcon(logo));

		btn5 = new JButton("5");//button to throw square in the fifth column
		btn5 = new RoundButton("5");
		btn5.addActionListener(new Btn5ActionListener());
		btn5.setBounds(225, 18, GRID_WIDTH, 25);;
		frmConnectFour.getContentPane().add(btn5);
		btn5.setIcon(new ImageIcon(logo));

		btn6 = new JButton("6");//button to throw square in the sixth column
		btn6 = new RoundButton("6");
		btn6.addActionListener(new Btn6ActionListener());
		btn6.setBounds(280, 18, GRID_WIDTH, 25);;
		frmConnectFour.getContentPane().add(btn6);
		btn6.setIcon(new ImageIcon(logo));

		btn7 = new JButton("7");//button to throw square in the seventh column
		btn7 = new RoundButton("7");
		btn7.addActionListener(new Btn7ActionListener());
		btn7.setBounds(335, 18, GRID_WIDTH, 25);;
		frmConnectFour.getContentPane().add(btn7);
		btn7.setIcon(new ImageIcon(logo));
		
	

		lblActivePlayerText = new JLabel("Active player text");
		lblActivePlayerText.setForeground(Color.BLACK);
		lblActivePlayerText.setBackground(Color.LIGHT_GRAY);
		lblActivePlayerText.setFont(new Font("Consolas", lblActivePlayerText.getFont().getStyle() | Font.BOLD, lblActivePlayerText.getFont().getSize() + 5));
		lblActivePlayerText.setHorizontalAlignment(SwingConstants.CENTER);//player's name in the title box above grid
		lblActivePlayerText.setBounds(5, 389, 398, 45); // moved the activeplayer text
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
					int random = randomGen.nextInt(10);//Generates a given name within the arraylist if player didn't type a name yet
					response = names[random];
					JOptionPane.showMessageDialog(null, "Fine, then you shall be named:\n" + response);//Change response quote
				} else {
					String[] names = {"Dr. Nefarious", "Mickey Bay", "Ferret Face Burns", "Captain Oblivious", "THE VOID", "Clu", "Bob", "Da Terminator", "Baby Chell", "Arthur Dent"};
					Random randomGen = new Random();
					int random = randomGen.nextInt(10);
					response = names[random];
					JOptionPane.showMessageDialog(null, "A wise guy, eh?\nThen you shall be called:\n" + response);//Change response quote			
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

	private class Btn1ActionListener implements ActionListener {//Activates button 1 to set piece on grid into the 1st row

		public void actionPerformed(ActionEvent arg0) {
			int xTarget = 0;
			checkColumn(xTarget);
			try {
				checkVictory(xTarget);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void checkColumn(int column) {//Checks column for pieces to go into
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
				yTarget--;//Causes players to put pieces on to of each in the next row above
			}

		} while (!doneYet); 

		if (canPlace) {
			targetGrid.setBackground(activePlayer.getPlayerColor());//Identifies whose piece is whose on the grid by color//Identifies whose piece is whose on the grid by color
			targetGrid.setPlayerOwner(activePlayer.getPlayerNum());//Identifies whose piece is whose on the grid by players #
		}
	}

	private void updateTurnLabel() {
		lblActivePlayerText.setText(activePlayer.getPlayerName() + "'s Turn!");
	}

	private void changePlayer() throws IOException {
		if ((activePlayer.getPlayerNum()) == 2){
			activePlayer = playerOne; //player two had their turn, player 1 is next
			
			InputStream input = getClass().getResourceAsStream("/c4yellow.jpg");
			Image logo = ImageIO.read(input);
			btn1_1.setIcon(new ImageIcon(logo));
			btn2.setIcon(new ImageIcon(logo));
			btn3.setIcon(new ImageIcon(logo));
			btn4.setIcon(new ImageIcon(logo));
			btn5.setIcon(new ImageIcon(logo));
			btn6.setIcon(new ImageIcon(logo));
			btn7.setIcon(new ImageIcon(logo));
			
			
			
			
			
		} else {
			activePlayer = playerTwo; //player one had their turn, player 2 is next
			Color r = new Color(255,0,0);
			InputStream input2 = getClass().getResourceAsStream("/c4red.jpg");
			Image logo2 = ImageIO.read(input2);
			btn1_1.setIcon(new ImageIcon(logo2));
			
			btn2.setIcon(new ImageIcon(logo2));
			btn3.setIcon(new ImageIcon(logo2));
			btn4.setIcon(new ImageIcon(logo2));
			btn5.setIcon(new ImageIcon(logo2));
			btn6.setIcon(new ImageIcon(logo2));
			btn7.setIcon(new ImageIcon(logo2));
		}
		turnCounter++; 
		/* Yes, the lines above were intentional.
		 * Should a player be clumsy, sarcastic, or (heaven forbid) foolish enough
		 * to place a piece at the top of a full column,
		 * they fully deserve to lose their turn. :)
		 */
		
	}

	private void errorMessage() {//lose your turn if you overflow the column
		JOptionPane.showMessageDialog(null, "You can't put a piece there!\nHaha, you lose your turn!");//change response quote/message

		if (activePlayer.getPlayerNum() == 1){
			JOptionPane.showMessageDialog(null, "Player 2, your turn!");
		} else {
			JOptionPane.showMessageDialog(null, "Player 1, your turn!");
		}
		targetGrid = null;
	}

	private class Btn2ActionListener implements ActionListener {//Activates button 2 to input colored square into the 2nd row
		public void actionPerformed(ActionEvent e) {
			int xTarget = 1;	
			checkColumn(xTarget);
			try {
				checkVictory(xTarget);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class Btn3ActionListener implements ActionListener {//Activates button 3 to input colored square into the 3rd row
		public void actionPerformed(ActionEvent e) {
			int xTarget = 2;	
			checkColumn(xTarget);
			try {
				checkVictory(xTarget);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class Btn4ActionListener implements ActionListener {//Activates button 4 to input colored square into the 4th row
		public void actionPerformed(ActionEvent e) {
			int xTarget = 3;	
			checkColumn(xTarget);
			try {
				checkVictory(xTarget);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class Btn5ActionListener implements ActionListener {//Activates button 5 to input colored square into the 5th row
		public void actionPerformed(ActionEvent e) {
			int xTarget = 4;	
			checkColumn(xTarget);
			try {
				checkVictory(xTarget);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class Btn6ActionListener implements ActionListener {//Activates button 6 to input colored square into the 6th row
		public void actionPerformed(ActionEvent e) {
			int xTarget = 5;	
			checkColumn(xTarget);
			try {
				checkVictory(xTarget);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class Btn7ActionListener implements ActionListener {//Activates button 7 to input colored square into the 7th row
		public void actionPerformed(ActionEvent e) {
			int xTarget = 6;	
			checkColumn(xTarget);
			try {
				checkVictory(xTarget);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private void checkVictory(int activeColumn) throws IOException{//Makes sure if somebody wins the game
		if (targetGrid != null){//if == to null, nobody wouldn't win at all
			int gridY = targetGrid.getYBlock();
			int horizCount = 1;
			int vertCount = 1;
			int negDiagCount = 1;
			int posDiagCount = 1;

			ArrayList<Grid> testColumn = boardArray.get(activeColumn);
			Grid activeGrid = testColumn.get(gridY);

			vertCount = testDown(activeGrid, activeColumn, vertCount);//connects with the class testDown
			horizCount = testRight(activeGrid, activeColumn, horizCount);//connects with the class testRight
			horizCount = testLeft(activeGrid, activeColumn, horizCount);//connects with the class testLeft
			negDiagCount = testUpLeft(activeGrid, activeColumn, negDiagCount);//connects with the class testUpLeft
			negDiagCount = testDownRight(activeGrid, activeColumn, negDiagCount);//connects with the class testDownRight
			posDiagCount = testDownLeft(activeGrid, activeColumn, posDiagCount);//connects with the class testDownLeft
			posDiagCount = testUpRight(activeGrid, activeColumn, posDiagCount);//connects with the class testUpRight

			if (horizCount >= 4 || vertCount >= 4 || negDiagCount >= 4 || posDiagCount >= 4){//checking every angle to declare
				gameWinner = true;
			}

			if (gameWinner) {
				JOptionPane.showMessageDialog(null, activePlayer.getPlayerName() + " has won the game!\n" + 
						"It took " + turnCounter + " turns to do so!\n" + generateWittyRemark());//congratulates player's victory with witty response
				
				ContinueOrQuit corq = new ContinueOrQuit();
				corq.setVisible(true);
				gameWinner=false;
				frmConnectFour.setVisible(false);
				
				
				//close program
			} 
		}
		if (turnCounter > 43) {
			forceDraw();//game over, can't wait all day for a winner
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
		if (turnCounter < 7) {//if player wins in less than 7 turns
			remark = "Did you cheat or did we have a bug?";
		} else if (turnCounter == 7) {//if player wins in than 7 turns
			remark = "Was this a test, or was someone drinking?";
		} else if (turnCounter < 12) {//if player wins in more than 12 turns
			remark = "That was...quick.";
		} else if (turnCounter < 24 ) {//if player wins in more than 24 turns
			remark = "Good game!";
		} else if (turnCounter < 36 ) {//if player wins in more than 36 turns
			remark = "Do you guys have a system for this?";
		} else if (turnCounter < 41 ) {//if player wins in more than 41 turns
			remark = "You really didn't want to lose!";
		} else if (turnCounter == 41 ){//if player wins in exactly 41 turns
			remark = "Holy cheese!\nIf this was a legitimate match,\nI want a video!";
		} else {
			remark = "Now how about double or nothing?";
		}
		return remark;
	}

	private int testUpRight(Grid activeGrid, int activeColumn, int posDiagCount) {//checks positive diagonal for a winner (/)
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

	private int testDownRight(Grid activeGrid, int activeColumn, int negDiagCount) {//checks negative diagonally for a winner (\)
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

	private int testDownLeft(Grid activeGrid, int activeColumn, int posDiagCount) {//checks positive diagonally for a winner (/)
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

	private int testUpLeft(Grid activeGrid, int activeColumn, int negDiagCount) {//checks negative diagonally for a winner (\)
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

	private int testLeft(Grid activeGrid, int activeColumn, int horizCount) {//checks left side for a winner (<--)
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

	private int testRight(Grid activeGrid, int activeColumn, int horizCount) {//checks right side to declare winner (-->)
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

	private int testDown(Grid activeGrid, int activeColumn, int vertCount) {//Checks down the column to declare winner (|)
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
