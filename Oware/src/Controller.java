
public class Controller
{

	private Game game;
	
	public Controller()
	{
		game = new Game();
	}
	
	public boolean isGameActive()
	{
		return game.isGameActive();
	}
	
	public String makeMove(int pitNumber)
	{
		pitNumber = pitNumber-1;
		String msg = "";
		if (!game.getCurrPlayer().isPitOwnedByPlayer(pitNumber))
		{
			msg = "Invalid move. Selected pit is not owned by " + game.getCurrPlayer().getName();
		} else if (game.getGameBoard().getSeedCount(pitNumber) == 0) {
			msg = "Invalid move. Selected pit does not have any seeds.";
		} else {
			game.makeMove(pitNumber);
		}
		return msg;
	}

	public String movePrompt()
	{
		String s = getGameSummary() + "\n" + displayBoard();
		if (game.isGameActive())
			s += "\n" + game.getPlayerName(0) + " - enter pit for move " + displayPlayerPitRange() + ": ";
		return s;
	}

	private String getGameSummary()
	{
		String s,sDraw,sActive;
		sDraw = game.isGameDraw() ? "is a draw" : "is not a draw";
		sActive = game.isGameActive() ? "is active" : "is not active and " + sDraw;
		//sTurn = game.getCurrPlayer().getName();
		
		s = "Game " + sActive + "\nScore is " + listGameScore();
		
		return s;
	}
	
	private String listGameScore()
	{
		String s;
		s = game.getPlayerName(1) + ": " + game.getPlayerScore(1) + " to " +
			game.getPlayerName(2) + ": " + game.getPlayerScore(2); 
		return s;		
	}
	
	private String displayPit(int pitNumber)
	{
		String s = "  " + game.getGameBoard().getSeedCount(pitNumber);
		s = "( " + s.substring(s.length()-2, s.length()) + " )";
		//StdOut.println(game.getGameBoard().getSeedCount(pitNumber));
		return s;
	}
	
	private String displayPits(int startPitNumber, int endPitNumber)
	{
		String s = "";
		if (startPitNumber < endPitNumber)
		{
			s = displayPit(startPitNumber) + " " + 
				displayPits(game.getGameBoard().nextPit(startPitNumber),endPitNumber);
		} else if (startPitNumber > endPitNumber) {
			s = displayPit(startPitNumber) + " " + 
				displayPits(game.getGameBoard().previousPit(startPitNumber),endPitNumber);			
		} else {
			s = displayPit(startPitNumber);
		}
		return s;
	}
	
	public String displayBoard()
	{
		String s = displayPits(5,0) + "\n" + displayPits(6,11);
		return s;
	}
	
	private String displayPlayerPitRange()
	{
		return "(" + (game.getCurrPlayer().getStartPit()+1) + "-" + (game.getCurrPlayer().getEndPit()+1) + ")";
	}
	
}
