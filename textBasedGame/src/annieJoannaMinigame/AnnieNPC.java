package annieJoannaMinigame;

import caveExplorer.*;

public class AnnieNPC extends NPC {
	
	private int netCost;

	public AnnieNPC() {
		netCost = 25;
	}
	
	public String getSymbol() {
		return "N";
	}
	
	public String getDescription() {
		return "There is a merchant here. Press 'e' to buy a net for $" + netCost + ".";
	}
	
	public void interact() {
		if(CaveExplorer.inventory.getMoney() >= netCost) {
			CaveExplorer.inventory.setMoney(CaveExplorer.inventory.getMoney() - netCost);
			CaveExplorer.inventory.setNets(CaveExplorer.inventory.getNets() + 1);
			CaveExplorer.print("You bought a net!");
		} else
			CaveExplorer.print("You don't have enough money for a net.");
	}
}
