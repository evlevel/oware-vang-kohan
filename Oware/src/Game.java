
public class Game {

	private Board board;
	Player p1,p2;
	
	public void makeMove(int pitNumber)
	{
		int lastPitNumber = board.sowSeeds(pitNumber);
		board.scorePit(lastPitNumber);
		evaluateGame();
	}

	private void evaluateGame() {
		
		//get score of each player
		
		
		//get remaining seeds on board
		
		
	}
	
	
	
}
