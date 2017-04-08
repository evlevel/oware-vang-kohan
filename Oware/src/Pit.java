
public class Pit
{
	private int numSeeds;
	private Pit next, previous;
	
	public Pit(Pit next,Pit previous)
	{
		this.next = next;
		this.previous = previous;
	}
	
	public Pit(int numSeeds, Pit next,Pit previous)
	{
		this(next,previous);
		this.setNumSeeds(numSeeds);
	}
	
	public Pit getNext() {
		return next;
	}

	public Pit getPrevious() {
		return previous;
	}

	public int getNumSeeds()
	{
		return this.numSeeds;
	}

	public void setNumSeeds(int num)
	{
		this.numSeeds = num;
	}

	public void addSeeds(int num)
	{
		this.numSeeds += num;
	}

}
