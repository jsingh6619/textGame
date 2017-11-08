/*
 * In this room, it will give the user a random amount of money, which could be used in a different room ("shop") to purchase better equipment for the tetra game.
 * 0 attack only left
 * 1 attack left and right			- purchase
 * 2 attack up and down				- purchase
 * 3 attack up, down, left, right	- purchase
 * 4 attack diagonally ("if possible")
 */

package abidAbedJasMinigame;

import caveExplorer.*;

public class JasRoom extends NPCRoom {

	private int reward;

	public JasRoom(String description) {
		super(description);
		reward = (int)((Math.random()*5)*1000);
	}
	
	public void giveReward(){
		CaveExplorer.inventory.setMoney(CaveExplorer.inventory.getMoney() + reward);
	}
	
	public String validMoves() {
		return "wdsae";
	}

	/**
	 * override to create response to keys other than wdsa
	 * @param direction
	 */
	public void performAction(int direction) {
		if(direction == 5) {
			giveReward();
			System.out.println("You could use your money to aid your battle against Plankton.");
		}
		else {
			super.performAction(direction);
		}
	}
	
	public String getContents() {
		if(containsNPC() && getNPC().isActive()) {
			return getNPC().getSymbol();
		}else {
			return super.getContents();
		}
	}
	
	public String getDescription() {
		if(containsNPC() && getNPC().isActive()) {
			return super.getDescription()+"\n"+getNPC().getDescription();
		}else if(containsNPC() && !getNPC().isActive()){
			return super.getDescription()+"\n"+getNPC().getInactiveDescription();
		}else {
			return super.getDescription();
		}
	}
}
