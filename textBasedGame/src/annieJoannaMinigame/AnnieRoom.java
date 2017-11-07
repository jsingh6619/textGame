package annieJoannaMinigame;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class AnnieRoom extends CaveRoom {
	
	private int amount;
	private boolean visited;
	private String contents;

	public AnnieRoom(String description, int amount) {
		super(description);
		this.amount = amount;
		this.visited = false;
		this.contents = "$";
	}
	
	public void performAction(int direction) {
		if(!visited) {
			CaveExplorer.print("You've stumbled upon treasure!");
			CaveExplorer.inventory.setMoney(CaveExplorer.inventory.getMoney() + amount);
			visited = true;
		}
	}
	
	public String getContents() {
		if(!visited)
			return contents;
		else
			return super.getContents();
	}

}
