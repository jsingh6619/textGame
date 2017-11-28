package abidAbedJasMinigame;

import caveExplorer.*;

public class Gary extends NPC{

	private boolean isHungry;

	public Gary() {
		this.isHungry = true;
	}
	public String getDescription() {
		return "Hey look, it's your beloved pet Gary. Press 'e' to interact.";
	}
	public void setHungry(boolean isHungry) {
		this.isHungry = isHungry;
	}
	public boolean getIsHungry() {
		return isHungry;
	}
	public void interact() {
		if(!isHungry) {
			CaveExplorer.print("Hey would you look at that Gary's reading a book. "
					+ "\"How to Play Plankton's Game\" \nThere are two players playing on a 4 by 4 board.\nThey are both given a hand of 5 randomly generated cards with "
					+ "\nrandomly generated numbers on the top, bottom, left, and right."
					+ "\nThe middle letter signifies who the card belongs to. Ex: This card says P for Plankton"
					+ "\n_______\n|  8  |\n|7 P 5|\n|__6__|\n"
					+ "\nEach player puts down a card on the board. If a player chooses to put his card adjacent to the other players card the cards will \"fight\"."
					+ "\nEx: In this scenario Mr.Krabs puts his card under Plankton's. Since 7 is higher than 6 Krabs wins this fight."
					+ "\n_______\n|  8  |\n|7 P 5|\n|__6__|\n|  7  |\n|5 K 4|\n|__7__|"
					+ "\nThe winner of the fight is the card with the higher number. The losing card's ownership changes to the winners."
					+ "\nEx: In this scenario Krabs is the winner so he owns Plankton's card now.\n"
					+ "\n_______\n|  8  |\n|7 K 5|\n|__6__|\n|  7  |\n|5 K 4|\n|__7__|"
					+ "\nThe winner of the game is the player that has ownership of most cards on the board at the end.");
			
		}else {
			if(CaveExplorer.inventory.getHasFood()) {
				setHungry(false);
				CaveExplorer.inventory.setHasFood(false);
				CaveExplorer.inventory.setBooleanAtIndex(CaveExplorer.inventory.getDone(), 0 , true);
				CaveExplorer.print("Gary: Meow. \nYou've successfully fed Gary.");
				setActive(false);
			}
			else {
				CaveExplorer.print("You don't have any snail food. You can buy more at the store.");
			}
		}
	}
	public String getSymbol() {
		return "G";
	}
	
}
