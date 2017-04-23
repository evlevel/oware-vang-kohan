
public class Game {

	private Board board;
	private Player p1, p2, currPlayer, winningPlayer;
	private boolean isGameActive;
	
	public Game()
	{
		p1 = new Player("Player 1",0);
		p2 = new Player("Player 2",6);
		board = new Board(p1,p2);
		isGameActive = true;
		currPlayer = p1;
	}
	
	public void makeMove(int pitNumber)
	{
		int lastPitNumber = board.sowSeeds(pitNumber);
		board.scoreMove(currPlayer,lastPitNumber);
		updateGameStatus();
		if (isGameActive)
			switchPlayer();
	}

	//returns true when game is to continue
	private void updateGameStatus() {

		if (!hasMovesRemaining())
		{
			int score1 = p1.getScore();
			int score2 = p2.getScore();
			
			if (!isDrawScore(score1,score2)) {
				setWinningPlayer(p1.getScore() < p2.getScore() ? p2 : p1);
			}
			
			setGameActive(false);

		}
	}
	
	public Board getGameBoard()
	{
		return board;
	}
	
	public int getPlayerScore(int playerNum)
	{
		if (playerNum == 1) 
		{
			return p1.getScore();
		} else if (playerNum == 2) {
			return p2.getScore();
		} else {
			return currPlayer.getScore();
		}
	}
	
	public String getPlayerName(int playerNum)
	{
		if (playerNum == 1) 
		{
			return p1.getName();
		} else if (playerNum == 2) {
			return p2.getName();
		} else {
			return currPlayer.getName();
		}
	}
	
	private boolean hasMovesRemaining()
	{
		return (board.getTotalSeedCount() > 2);
	}
	
	private boolean isWinningScore(int score)
	{
		return score > 25;
	}
	
	private boolean isDrawScore(int score1, int score2)
	{
		return score1 == 24 && score2 == 24;
	}

	public boolean isGameDraw()
	{
		return isDrawScore(p1.getScore(),p2.getScore());
	}	
	
	public Player getCurrPlayer() {
		return currPlayer;
	}
	
	public void setCurrPlayer(Player currPlayer) {
		this.currPlayer = currPlayer;
	}

	private void switchPlayer()
	{
		if (getCurrPlayer().equals(p1))
		{
			setCurrPlayer(p2);		
		} else {
			setCurrPlayer(p1);
		}
		//StdOut.println(getCurrPlayer().getName());
	}

	public Player getWinningPlayer() {
		return winningPlayer;
	}

	private void setWinningPlayer(Player winningPlayer) {
		this.winningPlayer = winningPlayer;
	}

	public boolean isGameActive() {
		return isGameActive;
	}

	private void setGameActive(boolean isGameActive) {
		this.isGameActive = isGameActive;
	}
	
	
	
}
