
public class Player
{
	
	private int score;
	private String name;
	private int startPit,endPit;
	
	public Player(String playerName, int startPit)
	{
		this.setName(playerName);
		this.startPit = startPit;
		this.endPit = startPit + 5;
	}

	public Player(int startPit)
	{
		this("Player", startPit);
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void addScore(int scoreAdd)
	{
		this.score += scoreAdd;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public boolean isPitOwnedByPlayer(int pitNumber)
	{
		//StdOut.println(pitNumber +">="+ startPit +"&&"+ pitNumber +"<="+ endPit);
		return (pitNumber >= startPit && pitNumber <= endPit);
	}
	
	public int getStartPit()
	{
		return startPit;
	}

	public int getEndPit()
	{
		return endPit;
	}

	
}

