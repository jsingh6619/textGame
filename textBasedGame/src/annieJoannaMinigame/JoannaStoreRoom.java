package annieJoannaMinigame;

import caveExplorer.CaveExplorer;
import caveExplorer.NPCRoom;

public class JoannaStoreRoom extends NPCRoom {
	
	private String[] items;
	private boolean[] bought;

	public JoannaStoreRoom(String description) {
		super(description);
		String[] temp = {"eggs", "milk", "flour","Gary's food","clarient"};
		items = temp;
		boolean[] arr = {false,false,false,false,false};
		bought = arr;

	}
	
	public void performAction(int direction) {
		if(direction == 4)
		{
			printS('z',0,10);
			printS('x',1,10);
			printS('c',2,10);
			printS('v',3,20);
			printS('b',4,50);
		}
		if(direction == 5)//z
		{
			boughtItem(0,10);
		}
		if(direction == 6)//x
		{
			boughtItem(1,10);
		}
		if(direction == 7)//c
		{
			boughtItem(2,10);
		}
		if(direction == 8)//v
		{
			boughtItem(3,20);
		}
		if(direction == 9)//b
		{
			boughtItem(4,50);
		}
	}
	
	

	public void printS(char l, int idx, int amt) {
		CaveExplorer.print("Press '" + l+"' to buy " + items[idx] + " for $" +amt);
	}
	
	public void boughtItem(int idx, int amt) {
		CaveExplorer.print("You have successfully bought " + items[idx] + ". This item is no longer in stock.");
		CaveExplorer.inventory.setBooleanAtIndex(bought, idx, true);
		CaveExplorer.inventory.setMoney(CaveExplorer.inventory.getMoney()-amt);
		
	}
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move, or you can press 'e' to look at the products available.");
	}
	
	public String validMoves() {
		return "wdsaezxcvb";
	}

}
