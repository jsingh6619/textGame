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
	public void setHungry(boolean isHungry) {
		this.isHungry = isHungry;
	}
	public boolean getIsHungry() {
		return isHungry;
	}
	public void interact() {
		if(!isHungry) {
			CaveExplorer.print("Gary's not hungry anymore.");
		}else {
			if(CaveExplorer.inventory.getHasFood()) {
				setHungry(false);
				CaveExplorer.inventory.setHasFood(false);
				CaveExplorer.inventory.setBooleanAtIndex(CaveExplorer.inventory.getDone(), 0 , true);
			}
			else {
				CaveExplorer.print("You don't have any snail food. You can buy more at the store.");
			}
		}
	}
	public String getSymbol() {
		return "G";
	}
	
}
