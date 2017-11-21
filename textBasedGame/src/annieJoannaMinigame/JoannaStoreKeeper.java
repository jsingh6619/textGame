package annieJoannaMinigame;

import caveExplorer.*;


public class JoannaStoreKeeper extends NPC {

	private String[] items;
	private boolean[] bought;
	private int[] price;
	public JoannaStoreKeeper() {
		String[] temp = {"eggs", "milk", "flour","Gary's food","clarient"};
		items = temp;
		boolean[] arr = {false,false,false,false,false};
		bought = arr;
		int[] money = {10,10,10,20,50};
		price = money;
	}
	
	public void interact(int n) { 
		if(n ==4) {
			printS('z',0);
			printS('x',1);
			printS('c',2);
			printS('v',3);
			printS('b',4);
		}
		if(n == 5)//z
		{
			boughtItem(0,10);
		}
		if(n == 6)//x
		{
			boughtItem(1,10);
		}
		if(n == 7)//c
		{
			boughtItem(2,10);
		}
		if(n == 8)//v
		{
			boughtItem(3,20);
		}
		if(n == 9)//b
		{
			boughtItem(4,50);
		}
		
		
	}

	public void printS(char l, int idx) {
		CaveExplorer.print("Press '" + l+"' to buy " + items[idx] + " for $" +price[idx]);
	}
	
	public String getSymbol() {
		return "W";
	}
	
	public String getDescription(){
		return "You approach the stop keeper. Press 'e' to browse the items in store.";
	}
	
	public void boughtItem(int idx, int amt) {
		if(!bought[idx]) {
			if(CaveExplorer.inventory.getMoney() >= amt) {
				CaveExplorer.print("You have successfully bought " + items[idx] + ". This item is no longer in stock.");
				CaveExplorer.inventory.setBooleanAtIndex(bought, idx, true);
				CaveExplorer.inventory.setMoney(CaveExplorer.inventory.getMoney()-amt);
			} else {
				CaveExplorer.print("You don't have enough to buy (a)" +items[idx]+".");
			}
		} else {
			CaveExplorer.print("You already bought this item. It is no longer in stock.");
		}
		
	}
}




