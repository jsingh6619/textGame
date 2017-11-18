package annieJoannaMinigame;

import java.util.Scanner;

import caveExplorer.*;

public class JoannaFrontend implements AnnieSupport{

	
	private JoannaSupport backend;
	private int jellyfishCount;
	private AnnieJoannaPlot currentRoom;
	private boolean won;
	private AnnieAI opponent;
	
	public static AnnieJoannaPlot[][] plots;
	
	public JoannaFrontend() {
		backend = new AnnieBackend(this);
		opponent = backend.getOpponent();
		jellyfishCount = 0;
		won = false;
		currentRoom = plots[0][0];
		currentRoom.enter("X");
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
	        backend.computerMove();
	        String input = backend.getValidUserInput();
	        if(input.equals("cheat")) {
	        	winGame();
	        	break;
	        }
	        respondToInput(input);
	        updateScore();
		}
		 displayBoard();
        printGameOverMessage(backend.victorious());
        
	}

	private void winGame() {
		jellyfishCount += backend.getJellyfishNum();
    }

	private void instructions() {
		CaveExplorer.print("Compete against " + opponent.getName() + " in jellyfishing.  Whoever catches the most jellyfish wins.\nIf you win, you get to keep 1 of every 3 jellyfish you caught; if you tie, you don't get anything.");
	}

	private void printGameOverMessage(boolean victorious) {
		String s = "-----GAME OVER-----" + "\n";
		if(victorious) {
			won = true;
			s+= determineWinner("You", getJellyfishCount());
		}else {
			if(opponent.getJellyfishCount() != jellyfishCount) {
				s+= determineWinner(opponent.getName(), opponent.getJellyfishCount());
			} else {
				s+= "You tied with" +opponent.getName(); 
			}
		}
		CaveExplorer.print(s);
	}

	private String determineWinner(String name, int n) {
		return  name +" won. " + name+ " caught a total of " + n + " jellyfish.";
	}

	private void updateScore() {
		CaveExplorer.print("You: " + jellyfishCount + "\n" + opponent.getName() +": "+ opponent.getJellyfishCount() );
		
	}

	private void respondToInput(String input) {
		int dir = changeToDir(input);
		if(currentRoom.getConnection(dir) != null) {
			currentRoom.leave();
			currentRoom = currentRoom.getPlot(dir);
			currentRoom.enter("X");
			if(currentRoom.isJellyfishPresent()) {
				currentRoom.catchJellyfish();
				jellyfishCount++;
			}
			
		}else {
			CaveExplorer.print("There's something blocking your way.");
		}
	}

	
	private int changeToDir(String input) {
		String s = "wasd"; // 0 
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

	public boolean isWon() {
		return won;
	}

	
		

}
