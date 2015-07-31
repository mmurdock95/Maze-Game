/**
 * RandomOccupant file for Project 3
 * To create randomly placed objects on the screen and move them randomly.
 * @author Michael Murdock
 * @version Project 2
 * @version CPE102-11
 * @version Spring 2015
 */
import java.lang.Object;
import java.util.*;


public abstract class RandomOccupant extends Occupant
{
	private Random rand = new Random();
	private Maze maze;

	public RandomOccupant(Maze maze) 
	{
		this.maze=maze;
		moveTo(maze.getSquare(rand.nextInt((maze.rows())), rand.nextInt((maze.cols()))));
	}

	public RandomOccupant(Maze maze, long seed)
	{
		this.maze=maze;
		rand = new Random(seed);
		moveTo(maze.getSquare(rand.nextInt((maze.rows())), rand.nextInt((maze.cols()))));
	}

	public RandomOccupant(Maze maze, Square location)
	{		
		this.maze=maze;
		moveTo(location);
	}

	public void move()
	{
		int rows=maze.rows();
		int cols=maze.cols();
		Square square= this.location();
		boolean moving=true;

		while(moving)
		{
			int x=rand.nextInt(4);

			if (x==0) //up
			{
				if(square.wall(0)==false)
				{
					if (square.row()!=0)
					{
						moveTo(maze.getSquare(square.row()-1, square.col()));
						moving=false;
					}
				}
			}
			if(x==1) //right
			{
				if(square.wall(1)==false)
				{
					if (square.col()!=cols)
					{
						moveTo(maze.getSquare(square.row(), square.col()+1));
						moving=false;
					}
				}
			}
			if(x==2) //down
			{
				if(square.wall(2)==false)
				{
					if (square.row()!=rows)
					{
						moveTo(maze.getSquare(square.row()+1, square.col()));
						moving=false;
					}
				}
			}
			if(x==3) //left
			{
				if(square.wall(3)==false)
				{
					if (square.col()!=0)
					{
						moveTo(maze.getSquare(square.row(), square.col()-1));
						moving=false;
					}
				}
			}
		}
	}

	public void toObject(Scanner input)
	{
		moveTo(maze.getSquare(input.nextInt(), input.nextInt()));
	}

}
