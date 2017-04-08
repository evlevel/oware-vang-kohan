
public class Controller
{

	private Game game;
	
	public String makeMove(int pitNumber)
	{
		String msg = null;
		game.makeMove(pitNumber);
		return msg;
	}


}
