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
			CaveExplorer.inventory.setBooleanAtIndex(CaveExplorer.inventory.getDone(), 6, true);
		}
	}
	
	private void takeClarinet() {
		CaveExplorer.inventory.setGotClarinet(false);
		hasClarinet = true;
		CaveExplorer.print("SpongeBob! Thanks for the clarinet. Now I can play my recital!");
	}

	private void panic() {
		if(!visited) {
			CaveExplorer.print("SpongeBob! My clarinet broke. I can't play the recital without a clarinet!");
			CaveExplorer.inventory.setTaskAtIndex(6, "Help Squidward get a clarinet");
			visited = true;
		} else if(visited)
			CaveExplorer.print("SpongeBob! I need a clarinet!");
	}

	public boolean hasClarinet() {
		return hasClarinet;
	}
	
}