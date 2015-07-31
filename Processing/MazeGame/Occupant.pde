/**
 * Occupant file for Project 3
 * The base file for the rest of the players(parent class).
 * @author Michael Murdock
 * @version Project 2
 * @version CPE102-11
 * @version Spring 2015
 */

public abstract class Occupant
{
	private Square square_location;

	public Occupant()
	{}

	public Occupant(Square square_location)
	{
		this.square_location=square_location;
	}

	public Square location()
	{
		return square_location;
	}

	public void moveTo(Square square_location)
	{
		this.square_location=square_location;
	}

}

