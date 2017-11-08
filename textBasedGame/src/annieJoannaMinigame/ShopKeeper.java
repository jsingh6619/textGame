package annieJoannaMinigame;

import caveExplorer.*;

public class ShopKeeper extends NPC {
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	private static boolean gotNet;
	public static boolean isGotNet() {
		return gotNet;
	}
	
	public ShopKeeper() {
		this.activeDescription = "There is a fish merchant here. Press 'e' to talk.";
		this.inactiveDescription = "No new items in stock right now.";
		active = true;
		gotNet = false;
				 
	}
	public String getDescription() {
		return activeDescription;
	}
	
	
	public void interact() {
		CaveExplorer.print("You bought a net.");
		
		buyNet();
		
		active = false;
	}
	
	
	
	
 	

	public String getInactiveDescription() {
		return inactiveDescription;
	}
	public String getSymbol() {
		return "F";
	}
	public boolean isActive() {
		return active;
	}
	public void buyNet() {
		//if(money>=50) {
			
		gotNet = true;	
		
		
	}
	
}
