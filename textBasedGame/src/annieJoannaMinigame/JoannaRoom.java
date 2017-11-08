package annieJoannaMinigame;

import caveExplorer.CaveExplorer;

import caveExplorer.NPCRoom;

public class JoannaRoom extends NPCRoom {

	private ShopKeeper fishchant; 
	public JoannaRoom(String description) {
		super(description);
	}	 
	
	
	public void performAction(int direction) {
		if(direction ==  4) {
			CaveExplorer.print("You play the game like....."); //instructions for game
		}
			if(direction == 5 ) {
					//mini game
				}
			if(direction ==6)
			{
				fishchant.buyNet(100);
			}
			

		else {

			CaveExplorer.print("That key does nothing.");
		printValidMoves();
	}
	}
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move or you can press 'p' to play, but first make sure you have a net" 
				+"'e' to talk to the Fishchant.");
	}
	
	public String validMoves() {
		return "wdsaipe";
	}

}
