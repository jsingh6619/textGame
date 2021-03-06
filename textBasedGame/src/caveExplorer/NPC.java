package caveExplorer;

public class NPC {
	
	private CaveRoom[][] floor;
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;

	public NPC() {
		this.floor = CaveExplorer.caves;
		this.activeDescription = "There is a person in the room waiting to talk to you. Press 'e' to talk.";
		this.inactiveDescription = "The person you talked to earlier was standing here.";
		this.currentRow = -1;
		this.currentCol = -1;
		currentRoom = null;
		setActive(true);
	}

	public boolean isActive() {
		return active;
	}

	public void interact() {
		CaveExplorer.print("Let's interact! Type 'bye' to stop.");
		String s = CaveExplorer.in.nextLine();
		while(!s.equals("bye")) {
			CaveExplorer.print("Yeah... I don't do a whole lot.");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Later, friend!");
		setActive(false);
	}

	public String getDescription() {
		return activeDescription;
	}

	public String getInactiveDescription() {
		return inactiveDescription;
	}

	public String getSymbol() {
		return "P";
	}

	public void setPosition(int row, int col) {
		if(row >= 0 && row < floor.length && col >= 0 && col < floor[row].length && floor[row][col] instanceof NPCRoom) {
			if(currentRoom != null)
				currentRoom.leaveNPC();
			currentRow = row;
			currentCol = col;
			currentRoom = (NPCRoom)floor[row][col];
			currentRoom.enterNPC(this);
		}
	}

	public void autoMove() {
		if(isActive()) {
			int[] move = calculateMove();
			int newRow = move[0];
			int newCol = move[1];
			setPosition(newRow, newCol);
		}
	}

	private int[] calculateMove() {
		int[][] possibleMoves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int index = (int)(Math.random() * possibleMoves.length);
		int[] newPosition = new int[2];
		newPosition[0] = currentRow + possibleMoves[index][0];
		newPosition[1] = currentCol + possibleMoves[index][1];
		while(currentRoom.getDoor(index) == null || !(CaveExplorer.caves[newPosition[0]][newPosition[1]] instanceof NPCRoom)) {
			index = (int)(Math.random() * possibleMoves.length);
			newPosition[0] = currentRow + possibleMoves[index][0];
			newPosition[1] = currentCol + possibleMoves[index][1];
		}
		return newPosition;
	}

	public void interact(int direction) {
		// TODO Auto-generated method stub
		
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
