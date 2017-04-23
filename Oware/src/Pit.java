
public class Pit
{
	private int numSeeds;
	private Pit next, previous;
	private Player owner;
	
	public Pit(Pit next,Pit previous, Player owner)
	{
		this.next = next;
		this.previous = previous;
		this.owner = owner;
	}
	
	public Pit(int numSeeds, Pit next, Pit previous, Player owner)
	{
		this(next,previous,owner);
		this.setNumSeeds(numSeeds);
	}
	
	public Player getOwner()
	{
		return owner;
	}
	
	public boolean isOwner(Player playerToTest)
	{
		return playerToTest.equals(owner);
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
