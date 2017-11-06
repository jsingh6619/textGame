package abidAbedJasMinigame;

import caveExplorer.CaveRoom;

public class JasRoom extends CaveRoom {

	private int reward;

	public JasRoom(String description) {
		super(description);
		reward = giveReward();
	}
	
	public int giveReward(){
		int reward = (int)((Math.random()*5)*1000);
		CaveExplorer.inventory.setMoney(CaveExplorer.inventory.getMoney() + reward);
		return reward;
	}
}
