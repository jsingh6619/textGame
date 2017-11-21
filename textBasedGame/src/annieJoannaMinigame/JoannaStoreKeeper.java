package annieJoannaMinigame;

import caveExplorer.*;


public class JoannaStoreKeeper extends NPC {

	public JoannaStoreKeeper() {

	
	}
	
	public void interact() {
		CaveExplorer.print("Let's interact! Type 'bye' to stop.");
		String s = CaveExplorer.in.nextLine();
		while(!s.equals("bye")) {
			CaveExplorer.print("Yeah... I don't do a whole lot.");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Later, friend!");
		active = false;
	}

	public String getSymbol() {
		return "W";
	}
	
	/**
	 * for(int i = 0; i < inv.getIngredients().length; i++) {
				while(inv.getMoney()>10 && boo) {
					inv.getHave()[i] = true;
					inv.setMoney(inv.getMoney()-10);
					boo = false;
					}
				boo = true;
					}
			}else {
				super.performAction(direction);
			}
	 */
}

