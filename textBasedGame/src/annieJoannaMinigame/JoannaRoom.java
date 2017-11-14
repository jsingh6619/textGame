package annieJoannaMinigame;

import caveExplorer.CaveExplorer;

import caveExplorer.NPCRoom;

public class JoannaRoom extends NPCRoom {

	public JoannaRoom(String description) {
		super(description);
	}
	   
	public void performAction(int direction) {
		if(direction ==  6 && CaveExplorer.inventory.getNets()==0) {
			CaveExplorer.print("First you need to buy a net. Look for the merchant in the end of the room. Once you have bought a net come back to learn how to play the game."); //instructions for game
		}
		else {
			if(direction ==  6 && CaveExplorer.inventory.getNets()>0) {
				CaveExplorer.print("To win try to outnumber Kevin C. Cucumber's score as he races against you. Press 'p' when you're ready to play."); //instructions for game
			}
			else {
				if(direction == 5  ) {
						//mini game
				}
				else {
					super.performAction(direction);
				}
			}
		}
	}
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move, 'i' to learn how to play or you can press 'p' to play, but make sure you have a net first.");
	}
	
	public String validMoves() {
		return "wdsaepi";
	}

}
