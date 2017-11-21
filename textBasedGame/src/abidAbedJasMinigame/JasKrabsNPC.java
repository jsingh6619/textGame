package abidAbedJasMinigame;

import caveExplorer.*;

public class JasKrabsNPC extends NPC {
	
	private int exchange;
	
	public JasKrabsNPC() {
		exchange = 15;
	}
	
	public String getDescription() {
		return "You come across Mr. Krabs talking to his safe about plans to fill it up even more. Press 'e' to interact.";
	}
	
	public String getSymbol() {
		return "K";
	}
	
	public void interact() {
		CaveExplorer.print("Hey SpongeBob, I see you have jellyfish. How about you sell it to me and I give you money? \nRespond with 'yes' to sell your jellyfish for $" + exchange + " each.");
		if(CaveExplorer.in.nextLine().toLowerCase().equals("yes")) {
			sellJellyfish(CaveExplorer.inventory.getJellyfish());
		}
	}

	private void sellJellyfish(int jellyfish) {
		CaveExplorer.inventory.setMoney(CaveExplorer.inventory.getMoney() + jellyfish * exchange);
		CaveExplorer.inventory.resetJellyfish();
	}
}