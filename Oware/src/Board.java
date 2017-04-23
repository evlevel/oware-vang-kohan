
public class Board
{

	private int[] pits;
	private Player p1, p2;
	
	public Board(Player p1,Player p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		pits = new int[12];
		initializePits();
	}
	
	private void initializePits()
	{
		for(int i = 0 ; i < pits.length ; i++)
		{
			addSeedToPit(i,4);
		}
	}
	
	//sow seeds starting at pitNumber, return last sown pit number
	public int sowSeeds(int pitNumber)
	{
		int seedCount = takeSeedsFromPit(pitNumber);
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
	
	//calculate score starting at pitNumber and add to currPlayer's score
	public void scoreMove(Player currPlayer, int pitNumber)
	{
		int score = calculateScore(currPlayer, pitNumber);
		currPlayer.addScore(score);
	}
	
	//calculate score starting at pitNumber and add to currPlayer's score	
	public int calculateScore(Player currPlayer, int pitNumber)
	{
		if (!currPlayer.isPitOwnedByPlayer(pitNumber) && isPitEligibleForScore(pitNumber)) 
		{
			return takeSeedsFromPit(pitNumber) + 
					calculateScore(currPlayer,previousPit(pitNumber));
		} else {
			return 0;
		}
	}
	
	//calculate score at pitNumber
	public boolean isPitEligibleForScore(int pitNumber)
	{
		int score = getSeedsInPit(pitNumber);
		return (score == 2 || score == 3);
	}	
	
	public int nextPit(int pitNumber)
	{
		if (pitNumber >= 11)
		{
			return 0;
		} else {
			return pitNumber +1;
		}
	}
	
	public int previousPit(int pitNumber)
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

	private int takeSeedsFromPit(int pitNumber)
	{	
		int i = pits[pitNumber];
		pits[pitNumber] = 0;
		return i;
	}

	public int getTotalSeedCount()
	{
		return getSeedCount(0,12);
	}

	public int getSeedCount(int pitNumber)
	{
		return getSeedCount(pitNumber,1);
	}

	private int getSeedCount(int pitNumber, int pitCount)
	{
		if (pitCount==0)
		{
			return 0;
		} else {
			return getSeedsInPit(pitNumber) + getSeedCount(nextPit(pitNumber),pitCount-1);
		}
	}
	
}
