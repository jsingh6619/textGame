package annieJoannaMinigame;

import caveExplorer.*;


public class JoannaStoreKeeper extends NPC {

	public JoannaStoreKeeper() {

	
	}
	
	public void interact() {
		printS('z',0,10);
		printS('x',1,10);
		printS('c',2,10);
		printS('v',3,20);
		printS('b',4,50);
		String s = CaveExplorer.in.nextLine();
		while(!s.equals("bye")) {
			CaveExplorer.print("Yeah... I don't do a whole lot.");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Later, friend!");
		active = false;
	}

	public void printS(char l, int idx, int amt) {
		CaveExplorer.print("Press '" + l+"' to buy " + items[idx] + " for $" +amt);
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

