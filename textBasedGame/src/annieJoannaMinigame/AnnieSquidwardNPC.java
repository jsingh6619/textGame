package annieJoannaMinigame;

import caveExplorer.*;

public class AnnieSquidwardNPC extends NPC {
	
	private boolean visited;
	private boolean hasClarinet;

	public AnnieSquidwardNPC() {
		visited = hasClarinet = false;
	}
	
	public String getDescription() {
		return "You encounter Squidward. Press 'e' to interact.";
	}
	
	public String getSymbol() {
		return "Q";
	}
	
	public void interact() {
		if(!CaveExplorer.inventory.gotClarinet())
			panic();
		else {
			takeClarinet();
			CaveExplorer.inventory.setBooleanAtIndex(CaveExplorer.inventory.getDone(), 4, true);
		}
	}
	
	private void takeClarinet() {
		CaveExplorer.inventory.setGotClarinet(false);
		hasClarinet = true;
		CaveExplorer.print("Squidward: SpongeBob! Thanks for the clarinet. Now I can play my recital!");
	}

	private void panic() {
		if(!visited) {
			CaveExplorer.print("Squidward: SpongeBob! My clarinet broke. I can't play the recital without a clarinet!");
			CaveExplorer.inventory.setTaskAtIndex(4, "Help Squidward get a clarinet");
			visited = true;
		} else
			CaveExplorer.print("Squidward: SpongeBob! I need a clarinet!");
	}

	public boolean hasClarinet() {
		return hasClarinet;
	}
	
}
