package abidAbedJasMinigame;

import caveExplorer.*;

public class Gary extends NPC{

	private boolean isHungry;
	private int currentRow;
	private int currentCol;

	public Gary() {
		this.isHungry = true;
		this.currentRow = 3;
		this.currentCol = 1;
	}
	public void whistle() {
		this.currentRow =;
		this.currentCol =;
	}
	public void setHungry(boolean isHungry) {
		this.isHungry = isHungry;
	}
	public boolean getIsHungry() {
		return isHungry;
	}
	public String getSymbol() {
		return "G";
	}
	
}
