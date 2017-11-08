package annieJoannaMinigame;

import caveExplorer.NPC;

public class ShopKeeper extends NPC {
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;

	public ShopKeeper() {
		this.activeDescription = "There is a fish merchant here. Press 'e' to talk.";
		this.inactiveDescription = "No new items in stock right now.";
		active = true;
	}

	public String getSymbol() {
		return "F";
	}
	 
	public boolean buyNet() {
		
	}
}
