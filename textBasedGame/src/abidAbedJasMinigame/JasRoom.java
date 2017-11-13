//the krust krab npc room, plankton will be located here - the room where minigame will occur - need some interaction between user and NPC
package abidAbedJasMinigame;

import caveExplorer.*;

public class JasRoom extends NPCRoom {

	public JasRoom(String description) {
		super(description);
	}
	
	public String validMoves() {
		return "wdsae";
	}

	/**
	 * override to create response to keys other than wdsa
	 * @param direction
	 */
	public void performAction(int direction) {
		if(direction ==  4)
			if(getNPC() != null && getNPC().isActive())
				getNPC().interact();
			else
				CaveExplorer.print("There is nothing to interact with.");
		else
			CaveExplorer.print("That key does nothing.");
	
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
