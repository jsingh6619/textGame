package abidAbedJasMinigame;

import caveExplorer.*;

public class JasKrabsNPC extends NPC {
	
	private int exchange;
	
	public JasKrabsNPC() {
		exchange = 15;
	}
	
	public String getDescription() {
		return "You come across Mr. Krabs talking to his safe about plans to fill it up even more. You overhear your name in the process. Press 'e' to interact.";
	}
	
	public String getSymbol() {
		return "K";
	}
	
	public void interact() {
		CaveExplorer.print("Hey Spongebob, I see you have some jellyfish. How about you sell them to me and I give you money?");
		if(CaveExplorer.in.nextLine().toLowerCase().equals("yes")) {
			sellJellyfish(CaveExplorer.inventory.getJellyfish());
		}
	}

	private void sellJellyfish(int jellyfish) {
		CaveExplorer.inventory.setMoney(CaveExplorer.inventory.getMoney() + jellyfish * exchange);
		CaveExplorer.inventory.resetJellyfish();
	}
}