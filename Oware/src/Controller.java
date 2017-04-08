
public class Controller
{

	private Game game;
	
	public Controller()
	{
		game = new Game();
	}
	
	
	public String makeMove(int pitNumber)
	{
		String msg = null;
		game.makeMove(pitNumber);
		return msg;
	}

	public String movePrompt()
	{
		return getGameSummary() + "\n" + game.getPlayerName(0) + " - enter pit for move: ";
	}

	private String getGameSummary()
	{
		String s,sDraw,sActive,sTurn;
		sDraw = game.isGameDraw() ? "is a draw" : "is not a draw";
		sActive = game.isGameActive() ? "is active" : "is not active and " + sDraw;
		sTurn = game.getCurrPlayer().getName();
		
		s = "Game " + sActive + "\nScore is " + listGameScore();
		
		return s;
	}
	
	private String listGameScore()
	{
		String s;
		s = game.getPlayerName(1) + ": " + game.getPlayerScore(1) + " vs " +
			game.getPlayerName(2) + ": " + game.getPlayerScore(2); 
		return s;		
	}
	
}
