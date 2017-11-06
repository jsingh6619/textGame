package caveExplorer;

import annieJoannaMinigame.AnnieRoom;
import annieJoannaMinigame.JoannaRoom;
 
public class CaveRoom {
	
	private String description;
	private String directions;
	private String contents;
	private String defaultContents;
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;

	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i = 0; i < doors.length; i++)
			if(doors[i] != null) {
				doorFound = true;
				directions += "There is a " + doors[i].getDescription() + " to the " + toDirection(i) + ". " + doors[i].getDetails() + "\n";
			}
		if(!doorFound)
			directions = "There is no way out. You are trapped in this room.";
	}

	public static String toDirection(int dir) {
		String[] directions = {"North", "East", "South", "West"};
		return directions[dir];
	}
	
	public void enter() {
		contents = "X";
	}
	
	public void leave() {
		contents = defaultContents;
	}
	
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}

	public void addRoom(int dir, CaveRoom caveRoom, Door door) {
		borderingRooms[dir] = caveRoom;
		doors[dir] = door;
		setDirections();
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			printValidMoves();
			input = CaveExplorer.in.nextLine();
		}
		int direction = validMoves().indexOf(input);
		if(direction < 4)
			goToRoom(direction);
		else
			performAction(direction);
	}
	
	public void performAction(int direction) {
		CaveExplorer.print("That key does nothing.");
	}

	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd'.");
	}
	
	public String validMoves() {
		return "wdsa";
	}

	private boolean isValid(String input) {
		return validMoves().indexOf(input) > -1 && input.length() == 1;
	}
	
	public static void setUpCaves() {
		CaveExplorer.caves = new NPCRoom[5][5];
		CaveRoom[][] c = CaveExplorer.caves;
		for(int row = 0; row < c.length; row++)
			for(int col = 0; col < c[row].length; col++)
				c[row][col] = new NPCRoom("This cave has coordinates (" + row + ", " + col + ").");
		CaveExplorer.currentRoom = c[0][1];
		CaveExplorer.currentRoom.enter();
		c[3][3] = new AnnieRoom("This cave has coordinates (" + 3 + ", " + 3 + ").", 20);
		c[4][1] = new AnnieRoom("This cave has coordinates (" + 4 + ", " + 1 + ").", 30);
		c[2][0] = new AnnieRoom("This cave has coordinates (" + 2 + ", " + 0 + ").", 50);
		
		c[2][2]= new JoannaRoom("This cave has coordinates (" + 2 + ", " + 2 + ").And it's the jellyfish room...Gotta catch them all!!!!press 'p' to play, but first you need a net so press 'n'");
		for(int row = 0; row < c.length - 1; row++)
			for(int col = 0; col < c[row].length - 1; col++) {
				c[row][col].setConnection(SOUTH, c[row + 1][col], new Door());
				c[row][col].setConnection(EAST, c[row][col + 1], new Door());
			}
		for(int row = 0; row < c.length - 1; row++)
			c[row][c[row].length - 1].setConnection(SOUTH, c[row + 1][c[row].length - 1], new Door());
		for(int col = 0; col < c[c.length - 1].length - 1; col++)
			c[c[c.length - 1].length - 1][col].setConnection(EAST, c[c[c.length - 1].length - 1][col + 1], new Door());
	}

	public void goToRoom(int direction) {
		if(borderingRooms[direction] != null && doors[direction] != null && doors[direction].isOpen()) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		} else
			System.out.println("You can't do that!");
	}

	public static int oppositeDirection(int dir) {
		return (dir + 2) % 4;
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Door getDoor(int direction) {
		return doors[direction];
	}

}
