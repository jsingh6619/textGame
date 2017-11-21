package annieJoannaMinigame;

import caveExplorer.*;


public class JoannaStoreKeeper extends NPC {

	private String[] items;
	private boolean[] bought;
	
	public JoannaStoreKeeper() {
		String[] temp = {"eggs", "milk", "flour","Gary's food","clarient"};
		items = temp;
		boolean[] arr = {false,false,false,false,false};
		bought = arr;
	
	}
	
	public void interact(int n) { 
		printS('z',0,10);
		printS('x',1,10);
		printS('c',2,10);
		printS('v',3,20);
		printS('b',4,50);
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
		String s = CaveExplorer.in.nextLine();
		while(!s.equals("bye")) {
			CaveExplorer.print("Yeah... I don't do a whole lot.");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Later, friend!");
		
	}

	public void printS(char l, int idx, int amt) {
		CaveExplorer.print("Press '" + l+"' to buy " + items[idx] + " for $" +amt);
	}
	
	public String getSymbol() {
		return "W";
	}
	
	public String getDescription(){
		return "You approach the stop keeper. Press 'e' to browse the items in store.";
	}
	
	public void boughtItem(int idx, int amt) {
		CaveExplorer.print("You have successfully bought " + items[idx] + ". This item is no longer in stock.");
		CaveExplorer.inventory.setBooleanAtIndex(bought, idx, true);
		CaveExplorer.inventory.setMoney(CaveExplorer.inventory.getMoney()-amt);
	}
}




