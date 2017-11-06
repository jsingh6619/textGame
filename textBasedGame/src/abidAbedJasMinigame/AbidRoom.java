package abidAbedJasMinigame;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class AbidRoom extends CaveRoom{
	
	private int row;
	private int col;
	private NPCRoom currentRoom;
	private NPC npc;
	
	public AbidRoom(String description) {
		super(description);
		
	}
	public boolean canEnter() {
		return npc == null;
	}
	
	public void enterNPC(NPC n) {
		this.npc = n;
	}
	
	public void leaveNPC() {
		this.npc = null;
	}
	
	public boolean containsNPC() {
		return npc != null;
	}
	
	public String validMoves() {
		super.validMoves();
		return "wdsaez";
	}
	public void printValidMoves() {
		super.printValidMoves();
		System.out.println("Press z to whistle for Gary");
	}
	public void performAction(int direction) {
		super.performAction(direction);
		CaveExplorer.print("That key does nothing.");
	}


}
