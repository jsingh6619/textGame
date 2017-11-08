package annieJoannaMinigame;

import caveExplorer.CaveExplorer;

import caveExplorer.NPCRoom;

public class JoannaRoom extends NPCRoom {

	private ShopKeeper fishchant; 
	public JoannaRoom(String description) {
		super(description);
	}	 
	
	
	public void performAction(int direction) {
		if(direction ==  4 && !fishchant.buyNet()) {
			CaveExplorer.print("First you need to buy a net. Look for the shopkeeper in the (northwest). Once you have bought a net come back to learn how to play the game."); //instructions for game
		}
		if(direction ==  4 && fishchant.buyNet()) {
			CaveExplorer.print("To win try to outnumber Kevin C. Cucumber's score as he races against you."); //instructions for game
		}
		
			if(direction == 5 ) {
					//mini game
				}
			

		else {

			CaveExplorer.print("That key does nothing.");
		printValidMoves();
	}
	}
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move or you can press 'p' to play, but first make sure you have a net.");
	}
	
	public String validMoves() {
		return "wdsaipe";
	}

}
