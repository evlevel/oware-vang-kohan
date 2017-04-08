
public class Board
{

	int[] pits;
	Player p1, p2;
	
	public Board(Player p1,Player p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		pits = new int[12];
		initializePits();
	}
	
	private void initializePits()
	{
		for(int i = 0 ; i < pits.length ; i ++)
		{
			pits[i] = 4;
		}
	}
	
	//sow seeds starting at pitNumber, return last sown pit number
	public int sowSeeds(int pitNumber)
	{
		int seedCount = getSeedsInPit(pitNumber);
		int currentPit = pitNumber;
		
		while(seedCount > 0)
		{
			currentPit = nextPit(currentPit);
			if (currentPit != pitNumber)
			{
				addSeedToPit(currentPit);
				seedCount -= 1;
			}
		}
		return currentPit;
	}

	//return owner of pitNumber
	private Player getPitOwner(int pitNumber) {
		return pitNumber <= 5 ? p1 : p2;
	}
	
	//return if playerToTest is owner of pitNumber	
	private boolean isPitOwnedByPlayer(Player playerToTest, int pitNumber) {
		Player validPlayer = getPitOwner(pitNumber);
		return validPlayer.equals(playerToTest);
	}

	//calculate score starting at pitNumber and add to currPlayer's score
	public void scoreMove(Player currPlayer, int pitNumber)
	{
		int score = calculateScore(currPlayer, pitNumber);
		currPlayer.addScore(score);
	}
	
	//calculate score starting at pitNumber and add to currPlayer's score	
	public int calculateScore(Player currPlayer, int pitNumber)
	{
		int currPitScore = scorePit(pitNumber);
		if (!isPitOwnedByPlayer(currPlayer,pitNumber) && currPitScore > 0) 
		{
			return currPitScore += calculateScore(currPlayer,previousPit(pitNumber));
		} else {
			return 0;
		}
	}
	
	//calculate score at pitNumber
	public int scorePit(int pitNumber)
	{
		int score = getSeedsInPit(pitNumber);
		if (score == 2 || score == 3) 
		{
			return score;
		} else {
			return 0;
		}
	}	
	
	private int nextPit(int pitNumber)
	{
		if (pitNumber >= 11)
		{
			return 0;
		} else {
			return pitNumber +1;
		}
	}
	
	private int previousPit(int pitNumber)
	{
		if (pitNumber == 0)
		{
			return 11;
		} else {
			return pitNumber - 1;
		}
	}

	private void addSeedToPit(int pitNumber)
	{
		addSeedToPit(pitNumber,1);
	}

	private void addSeedToPit(int pitNumber, int seedCount)
	{
		pits[pitNumber] += seedCount;		
	}
	
	private int getSeedsInPit(int pitNumber)
	{
		return pits[pitNumber]; 
	}

}
