package annieJoannaMinigame;

import caveExplorer.CaveExplorer;

import caveExplorer.NPCRoom;

public class JoannaRoom extends NPCRoom {

	public JoannaRoom(String description) {
		super(description);
	}
	   
	public void performAction(int direction) {
		if(direction ==  4 && CaveExplorer.inventory.getNets()==0) {
			CaveExplorer.print("First you need to buy a net. Look for the merchant in the end of the room. Once you have bought a net come back to play the game."); //instructions for game
		}
		else {
		
				if(direction == 4  ) {
					JoannaFrontend game = new JoannaFrontend(); 
					game.play();	
					CaveExplorer.inventory.setNets(CaveExplorer.inventory.getNets() - 1);
					if(game.isWon()) {
						CaveExplorer.inventory.setBooleanAtIndex(CaveExplorer.inventory.getDone(), 1, true);
						int jellyfishWon = (int)(game.getJellyfishCount()/3);
						CaveExplorer.inventory.setJellyfish(CaveExplorer.inventory.getJellyfish() + jellyfishWon);
					}
				}
				else {
					super.performAction(direction);
				}
			}
	}
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move,  or you can press 'e' to play.");
	}
	
	public String validMoves() {
		return "wdsae";
	}

}
