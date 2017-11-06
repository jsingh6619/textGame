package annieJoannaMinigame;

import caveExplorer.CaveExplorer;

import caveExplorer.NPCRoom;

public class JoannaRoom extends NPCRoom {

	public JoannaRoom(String description) {
		super(description);
	}	 
	
	
	public void performAction(int direction) {
		if(direction ==  4) {
			
			
		}
			
		
		if(direction == 5 ) {
					//mini game
				}
		else
			CaveExplorer.print("That key does nothing.");
	}
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move or you can press 'p' to play or 'i' for instructions.");
	}
	
	public String validMoves() {
		return "wdsaip";
	}

}
