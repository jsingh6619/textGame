package annieJoannaMinigame;

import caveExplorer.*;

public class AnnieNPC extends NPC {
	
	private int netsLeft;
	private int netCost;

	public AnnieNPC() {
		netsLeft = 5;
		netCost = 30;
	}
	
	public String getSymbol() {
		return "F";
	}
	
	public String getDescription() {
		return "There is a merchant here. Press 'e' to buy a net.";
	}
	
	public void interact() {
		if(netsLeft > 0)
			if(CaveExplorer.inventory.getMoney() >= netCost) {
				netsLeft--;
				CaveExplorer.inventory.setMoney(CaveExplorer.inventory.getMoney() - netCost);
				CaveExplorer.inventory.setNets(CaveExplorer.inventory.getNets() + 1);
				CaveExplorer.print("You bought a net!");
			} else
				CaveExplorer.print("You don't have enough money for a net.");
		else
			CaveExplorer.print("There are no more nets.");
	}
}
