/**
 * Treasure file for Project 3
 * The pieces that the Explorer will be searching for before getting eaten by the monster.
 * @author Michael Murdock
 * @version Project 2
 * @version CPE102-11
 * @version Spring 2015
 */
import java.lang.Object;
import java.util.Scanner;


public class Treasure extends RandomOccupant
{
	private boolean found=false;

	public Treasure(Maze maze)
	{
		super(maze);
		found=false;
		super.location().setTreasure(this);
	}
	public Treasure(Maze maze, long seed)
	{
		super(maze, seed);
		found=false;
		super.location().setTreasure(this);
	}

	public Treasure(Maze maze, Square location)
	{
		super(maze, location);
		found=false;
		location.setTreasure(this);
	}

	public boolean found()
	{
		return found;
	}

	public void setFound()
	{
		found=true;
	}

	public void move()
	{
            
	}

	public void moveTo(Square square_location)
	{
		if (super.location()!=null)
			location().setTreasure(null);
		
		super.moveTo(square_location);
		location().setTreasure(this);
	}

	public String toText(char delimiter)
	{
		return super.toText(delimiter) + delimiter +String.valueOf(found); 
	}

	public void toObject(Scanner input)
	{
		moveTo(new Square(input.nextInt(), input.nextInt()));
		found = input.nextBoolean();
	}

}
