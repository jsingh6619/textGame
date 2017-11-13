package caveExplorer;

public class Inventory {
	
	private String map;
	private int garyFood;
	private int money;
	private int nets;
	private int jellyfish;
	private boolean gotClarinet;
	private String[] tasks;
	private boolean[] done;
	private String[] ingredients;
	private boolean[] have;
	
	public Inventory() {
		money = nets = jellyfish = 0;
		gotClarinet = false;
		String[] temp = {"Feed Gary breakfast", "Catch jellyfish", "Feed Gary lunch", "Go to work", "Get cake from Sandy", "Feed Gary dinner", "Go to Squidward's recital"};
		tasks = temp;
		boolean[] temp2 = {false, false, false, false, false, false, false};
		done = temp2;
		String[] arr = {"eggs", "milk", "flour"};
		ingredients = arr;
		boolean[] gotten = {false, false, false};
		have = gotten;
		updateMap();
	}
	
	public void updateMap() {
		map = "\n ";
		for(int i = 0; i < CaveExplorer.caves[0].length - 1; i++)
			map += "____";
		map += "___\n";
		for(CaveRoom[] row: CaveExplorer.caves)
			for(int i = 0; i < 3; i++) {
				String text = "";
				for(CaveRoom cr: row) {
					if(cr.getDoor(CaveRoom.WEST) != null && cr.getDoor(CaveRoom.WEST).isOpen())
						text += " ";
					else
						text += "|";
					if(i == 0)
						text += "   ";
					else if(i == 1)
						text += " " + cr.getContents() + " ";
					else if(i == 2)
						if(cr.getDoor(CaveRoom.SOUTH) != null && cr.getDoor(CaveRoom.SOUTH).isOpen())
							text += "   ";
						else
							text += "___";
				}
				text += "|";
				map += text + "\n";
			}
	}
	
	public String getDescription() {
		String description = map + "\n" + listTasks();
		if(money > 0)
			description += "\n" + "You have $" + money + ".";
		if(nets > 0)
			description += "\n" + "You have " + nets + " net(s).";
		if(jellyfish > 0)
			description += "\n" + "You have " + jellyfish + " jellyfish (you can sell it to Mr. Krabs for money).";
		return description;
	}

	private String listTasks() {
		String list = "Things you need to do:\n";
		for(int i = 0; i < tasks.length; i++)
			if(!done[i])
				list += "- " + tasks[i] + "\n";
		return list;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getNets() {
		return nets;
	}

	public void setNets(int nets) {
		this.nets = nets;
	}
	
	public String[] getTasks() {
		return tasks;
	}

	public void setTaskAtIndex(int index, String task) {
		tasks[index] = task;
	}

	public String[] getIngredients() {
		return ingredients;
	}
	
	public boolean[] getDone() {
		return done;
	}
	
	public boolean[] getHave() {
		return have;
	}
	
	public void setBooleanAtIndex(boolean[] arr, int index, boolean value) {
		arr[index] = value;
	}

	public boolean gotClarinet() {
		return gotClarinet;
	}

	public void setGotClarinet(boolean value) {
		this.gotClarinet = value;
	}

	public int getGaryFood() {
		return garyFood;
	}

	public void setGaryFood(int garyFood) {
		this.garyFood = garyFood;
	}
	
	public int numTasksLeft() {
		int count = 0;
		for(int i = 0; i < done.length; i++)
			if(!done[i])
				count++;
		return count;
	}

}