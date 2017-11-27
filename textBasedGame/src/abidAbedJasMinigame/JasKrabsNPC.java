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
		if(CaveExplorer.inventory.getJellyfish() > 0) {
			CaveExplorer.print("Mr. Krabs: Hey SpongeBob, I see you have jellyfish. How about you sell it to me and I give you money? \nRespond with 'ok' to sell your jellyfish for $" + exchange + " each.");
			if(CaveExplorer.in.nextLine().equals("ok")) {
				sellJellyfish(CaveExplorer.inventory.getJellyfish());
				CaveExplorer.print("Mr. Krabs: It's a pleasure doing business, SpongeBob.");
			} else {
				CaveExplorer.print("Okay, I guess not.");
			}
		}
		else {
			CaveExplorer.print("Mr. Krabs: Get back to flipping patties!");
		}
	}

	public void sellJellyfish(int jellyfish) {
		CaveExplorer.inventory.setMoney(CaveExplorer.inventory.getMoney() + jellyfish * exchange);
		resetJellyfish();
	}
	
	public void resetJellyfish() {
		int jellyfish = 0;
		CaveExplorer.inventory.setJellyfish(jellyfish);
	}
}