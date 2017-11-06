package abidAbedJasMinigame;

import caveExplorer.*;

public class AbidRoom extends NPCRoom{
	
	
	public AbidRoom(String description) {
		super(description);
		
	}
	
	
	public String validMoves() {
		return "wdsaez";
	}
	public void printValidMoves() {
		super.printValidMoves();
		System.out.println("Press 'z' to whistle for Gary");
	}
	public void performAction(int direction) {
		if(direction == 5) {
			//pressed z
			
		}else{
			
			super.performAction(direction);
		}
	}


}
