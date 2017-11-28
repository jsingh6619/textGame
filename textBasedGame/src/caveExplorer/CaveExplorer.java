package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	
	public static CaveRoom[][] caves;
	public static Scanner in;
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	public static boolean playing = true;
	public static NPC[] npcs;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		inventory = new Inventory();
		startExploring();
	}
	
	public static void print(String s) {
		System.out.println(s);
	}

	private static void startExploring() {
		print("Your name is SpongeBob SquarePants and you live in a pineapple under the sea, located in Bikini Bottom. \nYour objective is to get through the day."
				+ "\n(Your last task is to attend Squidward's recital, but this event will be held at the end of the day; \ntherefore, you must complete all other tasks before you can access the concert hall.)");
		while(playing) {
			print(inventory.getDescription());
			print(currentRoom.getDescription()); 
			print(currentRoom.getDirections());
			print("What would you like to do?");
			currentRoom.interpretInput(in.nextLine());
			if(inventory.numTasksLeft() == 1)
				CaveRoom.openCloseCH(true);
			if(inventory.numTasksLeft() == 0)
				playing = false;
		}
		print("\nSquidward was able to put on his recital, and you completed the day! \nYou did it!");
	}

}
