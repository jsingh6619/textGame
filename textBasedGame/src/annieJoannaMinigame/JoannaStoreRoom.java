package annieJoannaMinigame;

import caveExplorer.CaveExplorer;
import caveExplorer.NPCRoom;

public class JoannaStoreRoom extends NPCRoom {
	
	private String[] items;
	private boolean[] bought;

	public JoannaStoreRoom(String description) {
		super(description);
		

	}
	
	public void performAction(int direction) {
		
		if(direction > 3)//z
		{
			interact(direction);
		}
		else {
			super.performAction(direction);
	}
	
	

	
	
	
	}
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move, or you can press 'e' to look at the products available.");
	}
	
	public String validMoves() {
		return "wdsaezxcvb";
	}

}
