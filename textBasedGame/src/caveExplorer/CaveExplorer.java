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
		while(playing) {

			print(inventory.getDescription());

			print(currentRoom.getDescription()); 
			print("You currently have $" + inventory.getMoney() + ".");
			print(currentRoom.getDirections());
			print("What would you like to do?");
			currentRoom.interpretInput(in.nextLine());
		}
	}

	

}
