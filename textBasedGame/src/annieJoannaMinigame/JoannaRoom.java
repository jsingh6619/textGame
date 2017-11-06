package annieJoannaMinigame;

import caveExplorer.CaveExplorer;

import caveExplorer.NPCRoom;

public class JoannaRoom extends NPCRoom {

	public JoannaRoom(String description) {
		super(description);
	}	 
	
	
	public void performAction(int direction) {
		if(direction ==  4) {
			CaveExplorer.print("You obtained the net, now you can play. Press 'p' to play");
			if(direction == 5 ) {
					//mini game
				}
			else {
				System.out.println("You can only enter 'w', 'a', 's', or 'd' to move or you can press 'p' to play since you already have a net.");
			}
		}
			
		
		 
		else
			CaveExplorer.print("That key does nothing.");
		printValidMoves();
	}
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move or you can press 'p' to play, but first you need a net so press 'n'");
	}
	
	public String validMoves() {
		return "wdsaip";
	}

}
