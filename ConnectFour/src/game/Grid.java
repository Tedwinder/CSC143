package game;

import java.awt.Canvas;

public class Grid extends Canvas {
	
	private int playerOwner = 0;
	private boolean isFilled;
	private int xBlock;
	private int yBlock;
	
	public int getPlayerOwner() {
		return playerOwner;
	}
	
	public void setPlayerOwner(int playerOwner) {
		this.playerOwner = playerOwner;
	}
	
	public boolean isFilled() {
		if (playerOwner != 0){
			isFilled = true;
		} else {
			isFilled = false;
		}
		return isFilled;
	}	

	public int getXBlock() {
		return xBlock;
	}

	public void setXBlock(int xBlock) {
		this.xBlock = xBlock;
	}

	public int getYBlock() {
		return yBlock;
	}

	public void setYBlock(int yBlock) {
		this.yBlock = yBlock;
	}


}
