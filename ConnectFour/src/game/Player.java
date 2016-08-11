package game;

import java.awt.Color;

public class Player {

	private Color playerColor;
	private int playerNum;
	private String playerName;
	
	public Player(int playerNum, Color color, String playerName) {
		this.playerNum = playerNum;
		this.playerColor = color;
		this.playerName = playerName;
	}
	
	public Color getPlayerColor() {
		return playerColor;
	}

	public int getPlayerNum() {
		return playerNum;
	}
	
	public String getPlayerName() {
		return playerName;
	}
}
