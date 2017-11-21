package caveExplorer;

import annieJoannaMinigame.*;
import abidAbedJasMinigame.*;

public class CaveRoom {
	
	private static CaveRoom[][] c;

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
		CaveExplorer.caves = new CaveRoom[5][10];
		c = CaveExplorer.caves;
		for(int row = 0; row < c.length; row++)
			for(int col = 0; col < c[row].length; col++)
				c[row][col] = new NPCRoom("You are at (" + row + ", " + col + ").");
		setUpTreasure();
		setUpRoads();
        setUpBuildings();
        setUpNPCs();
        CaveExplorer.currentRoom = c[0][2];
        CaveExplorer.currentRoom.enter();
	}
	
	private static void setUpNPCs() {
		NPC sandy = new JoannaNPC();
		sandy.setPosition(4, 0);
		NPC squid = new AnnieSquidwardNPC();
		squid.setPosition(0, 8);
		NPC merchant = new AnnieNPC();
		merchant.setPosition(4, 5);
		NPC plankton = new Plankton();
		plankton.setPosition(1, 6);
		NPC gary = new Gary();
		gary.setPosition(0, 1);
		NPC krabs = new JasKrabsNPC();
		krabs.setPosition(1, 7);
		NPC seller = new JoannaStoreKeeper();
		seller.setPosition(2, 1);
 	}

	private static void setUpBuildings() {
		setUpPineapple();
		setUpKK();
		setUpConcertHall();
		setUpMarket();
		setUpTree();
		setUpJFF();
	
	}

	

	private static void setUpJFF() {
		for(int col = 5; col <= 8; col++) {
			String description = c[4][col].getDescription() + " You are in the Jellyfish Fields.";
			if(col == 5)
				c[4][col].setDescription(description);
			else
				c[4][col] = new JoannaRoom(description + " Press 'e' to catch jellyfish.");
		}
		setBlock(new int[] {4, 5}, new int[] {4, 8});
		setDoorway(c[4][8], c[3][8], NORTH, true);
	}

	private static void setUpTree() {
		for(int col = 0; col <= 2; col++) {
				String description = c[4][col].getDescription() + " You are at Sandy's treedome.";
				c[4][col].setDescription(description);
		}
		setBlock(new int[] {4, 0}, new int[] {4, 2});
		setDoorway(c[4][2], c[3][2], NORTH, true);
	}

	private static void setUpMarket() {
		for(int col = 0; col <= 1; col++) {
			String description = c[2][col].getDescription() + " You are at the Barg'N-Mart.";
			c[2][col] = new JoannaStoreRoom(description + " Press 'e' to look through the products.");
		
		}
		setBlock(new int[] {2, 0}, new int[] {2, 1});
		setDoorway(c[2][0], c[1][0], NORTH, true);
	}

	private static void setUpConcertHall() {
		for(int row = 0; row <= 1; row++)
			for(int col = 8; col <= 9; col++) {
				String description = c[row][col].getDescription() + " You are at the Philharmonic Concert Hall.";
				c[row][col].setDescription(description);
			}
		setBlock(new int[] {0, 8}, new int[] {1, 9});
		openCloseCH(false);
	}
	
	public static void openCloseCH(boolean open) {
		setDoorway(c[1][9], c[2][9], SOUTH, open);
	}
	
	private static void setUpKK() {
		for(int col = 5; col <= 7; col++) {
			String description = c[1][col].getDescription() + " You are at the Krusty Krab.";
			if(col == 6)
				c[1][col] = new AbedRoom(description);
			c[1][col].setDescription(description);
		}
		setBlock(new int[] {1, 5}, new int[] {1, 7});
		setDoorway(c[1][5], c[2][5], SOUTH, true);
	}
		
	private static void setUpPineapple() {
		for(int col = 1; col <= 2; col++) {
			String description = c[0][col].getDescription() + " You are in your pineapple under the sea.";
			c[0][col].setDescription(description);
		}
		setBlock(new int[] {0, 1}, new int[] {0, 2});
		setDoorway(c[0][2], c[1][2], SOUTH, true);
	}

	private static void setUpRoads() {
		int[][][] coords = {
				{{0, 0}, {1, 0}}, 
				{{1, 0}, {1, 4}}, 
				{{0, 3}, {0, 7}}, 
				{{0, 3}, {4, 4}}, 
				{{1, 2}, {3, 4}}, 
				{{2, 2}, {3, 9}}, 
				{{3, 0}, {3, 9}}, 
				{{2, 9}, {4, 9}}, 
		};
		for(int i = 0; i < coords.length; i++)
			setBlock(coords[i][0], coords[i][1]);
	}
	
	private static void setUpTreasure() {
		int[][] coords = {{0, 6}, {3, 9}, {4, 4}, {2, 3}};
		int[] amounts = {10, 20, 30, 40};
		for(int i = 0; i < coords.length; i++) {
			String description = c[coords[i][0]][coords[i][1]].getDescription();
			c[coords[i][0]][coords[i][1]] = new AnnieRoom(description, amounts[i]);
		}
	}

	public static void setDoorway(CaveRoom room, CaveRoom otherRoom, int direction, boolean open) {
		Door door = new Door();
		door.setOpen(open);
		if(!open)
			door.setDescription("closed door");
		else
			door.setDescription("doorway");
		room.setConnection(direction, otherRoom, door);
	}

	public static void setBlock(int[] topLeft, int[] bottomRight) {
		for(int row = topLeft[0]; row < bottomRight[0]; row++)
			for(int col = topLeft[1]; col < bottomRight[1]; col++) {
				c[row][col].setConnection(SOUTH, c[row + 1][col], new Door());	
				c[row][col].setConnection(EAST, c[row][col + 1], new Door());
			}
		for(int row = topLeft[0]; row < bottomRight[0]; row++)
			c[row][bottomRight[1]].setConnection(SOUTH, c[row + 1][bottomRight[1]], new Door());	
		for(int col = topLeft[1]; col < bottomRight[1]; col++)
			c[bottomRight[0]][col].setConnection(EAST, c[bottomRight[0]][col + 1], new Door());
	}
	
	public void goToRoom(int direction) {
		if(borderingRooms[direction] != null && doors[direction] != null && doors[direction].isOpen()) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
			if(CaveExplorer.currentRoom instanceof AnnieRoom)
				CaveExplorer.currentRoom.performAction(-1);
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
