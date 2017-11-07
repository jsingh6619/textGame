package annieJoannaMinigame;

import caveExplorer.*;

public class AnnieRoom extends CaveRoom {
	
	private int amount;
	private boolean visited;

	public AnnieRoom(String description, int amount) {
		super(description);
		this.amount = amount;
		this.visited = false;
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
			return "$";
		else
			return super.getContents();
	}

}
