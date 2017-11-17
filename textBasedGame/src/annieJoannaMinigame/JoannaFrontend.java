package annieJoannaMinigame;

import java.util.Scanner;

import caveExplorer.*;

public class JoannaFrontend implements AnnieSupport{

	
	private JoannaSupport backend;
	private int jellyfishCount;
	private AnnieJoannaPlot currentRoom;
	private boolean won;
	private int row;
	private int col;
	
	public static AnnieJoannaPlot[][] plots;
	
	public JoannaFrontend() {
		backend = new AnnieBackend(this);
		jellyfishCount = 0;
		won = false;
		row = 0;
		col = 0;
		currentRoom = plots[row][col];
		currentRoom.enter("S");
		CaveExplorer.in = new Scanner(System.in);
	} 

	public static void main(String[] args) {
		
		JoannaFrontend demo = new JoannaFrontend();
		demo.play();
	}

	public void play() {
		instructions();
		while(backend.stillPlaying()){
	        displayBoard();
	        displayScore();
	        String input = backend.getValidUserInput();
	        if(input.equals("cheat")) {
	        	winGame();
	        	break;
	        }
	        respondToInput(input);
	        backend.computerMove();
	        updateScore();
		}
        printGameOverMessage(backend.victorious());
	}

	private void winGame() {
		jellyfishCount += backend.getJellyfishNum();
    }

	private void instructions() {
		
	}

	private void printGameOverMessage(boolean victorious) {
		String s = "GAME OVER";
		if(victorious) {
			won = true;
			s+= determineWinner("Spongebob", getJellyfishCount());
			CaveExplorer.print(s);
	} 	else {
			s+= determineWinner(backend.getOpponent().getName(), backend.getOpponent().
			getJellyfishCount());
			CaveExplorer.print(s);
		}
	}

	private String determineWinner(String name, int n) {
		return "The winner is " + name +" with a total of " + n + " jellyfish.";
	}

	private void updateScore() {
		
	}

	private void respondToInput(String input) {
		int dir = changeToDir(input);
		if(dir == 0 && row != 0) {
			currentRoom.leave();
			currentRoom = plots[row--][col];
			currentRoom.enter("S");
		}else {
			if(dir == 1 && col != plots.length) {
				currentRoom.leave();
				currentRoom = plots[row][col++];
				currentRoom.enter("S");
			}else {
					if(dir == 2 && row != plots.length) {
						currentRoom.leave();
						currentRoom = plots[row++][col];
						currentRoom.enter("S");
					}else {
						if(dir == 3 && col != 0) {
							currentRoom.leave();
							currentRoom = plots[row][col--];
							currentRoom.enter("S");
						}else {
							findValidMoves();
						}
						
					}
				}
			}
		}

	private void findValidMoves() {
		CaveExplorer.print("You can't move that direction");
		
	}

	private int changeToDir(String input) {
		String s = "wdsa"; // 0 
		return s.indexOf(input); 
	}

	private void displayScore() {
	
	}

	private void displayBoard() {
		CaveExplorer.print(updateBoard());	
	}

	
	private String updateBoard() {
		String map = "\n ";
		for(int i = 0; i < plots[0].length - 1; i++)
			map += "____";
		map += "___\n";
		for(AnnieJoannaPlot[] row: plots)
			for(int i = 0; i < 3; i++) {
				String text = "";
				for(AnnieJoannaPlot plot: row) {
					if(plot.getConnection(AnnieJoannaPlot.WEST) != null )
						text += " ";
					else
						text += "|";
					if(i == 0)
						text += "   ";
					else if(i == 1)
						text += " " + plot.getContents() + " ";
					else if(i == 2)
						if(plot.getConnection(AnnieJoannaPlot.SOUTH) != null)
							text += "   ";
						else
							text += "___";
				}
				text += "|";
				map += text + "\n";
			}
		return map;
}

	
	/***
	 *   
 _______________________
|                       |
|                       |
|                       |
|                       |
|                       |
|                       |
|                       |
|                       |
|                       |
|                       |
|                       |
|                       |
|                       |
|                       |
|                       |
|                       |
|                       |
|___ ___ ___ ___ ___ ___|
 *  
	 * 
	 
	 * 
	 */
	
	public int getJellyfishCount() {
		return jellyfishCount;
	}
		

}
