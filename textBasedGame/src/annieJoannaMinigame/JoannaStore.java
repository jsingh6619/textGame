package annieJoannaMinigame;

import caveExplorer.*;


public class JoannaStore extends NPCRoom {

	private Inventory inv ;
	private boolean boo;
	
	public JoannaStore(String description) {
		super(description);
		inv = CaveExplorer.inventory;
		boo = true;
	}

	public void performAction(int direction) {
		if(direction ==  4) {
			
				for(int i = 0; i < inv.getIngredients().length; i++) {
				while(inv.getMoney()>3 && boo) {
					inv.getHave()[i] = true;
					inv.setMoney(inv.getMoney()-3);
					boo = false;
					}
				boo = true;
					}
			}else {
				super.performAction(direction);
			}

		}
	
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move,  or you can press 'e' to purchase items.");
	}
	
	public String validMoves() {
		return "wdsae";
	}

}
