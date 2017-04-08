
public class Oware
{

	private static Controller c;
	
	public static void main(String[] args)
	{
		c = new Controller();
		StdOut.println("Welcome to Oware.");
		
		while(true)
		{
			StdOut.println(c.movePrompt());
			c.makeMove(StdIn.readInt());
		}

	}

}
