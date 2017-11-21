package annieJoannaMinigame;

import caveExplorer.*;

public class AnnieNPC extends NPC {
	
	private int netsLeft;
	private int netCost;

	public AnnieNPC() {
		netsLeft = 6;
		netCost = 15;
	}
	
	public String getSymbol() {
		return "N";
	}
	
	public String getDescription() {
		return "There is a merchant here. Press 'e' to buy a net for $" + netCost + ".";
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
			CaveExplorer.print("The merchant does not have any more nets.");
	}
}
