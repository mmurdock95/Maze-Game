/**
 * Monster file for Project 3
 * The oppenent in the game that will move at random to attack the Explorer.
 * @author Michael Murdock
 * @version Project 2
 * @version CPE102-11
 * @version Spring 2015
 */
import java.lang.Object;

public class Monster extends RandomOccupant
{
	public Monster(Maze maze)
	{
		super(maze);
	}

	public Monster(Maze maze, long seed)
	{
		super(maze, seed);
	}

	public Monster(Maze maze, Square location)
	{
		super(maze, location);
	}
}