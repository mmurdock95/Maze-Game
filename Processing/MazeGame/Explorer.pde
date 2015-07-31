/**
 * Explorer file for Project 3
 * The main player that will be moving around and controlled by the user.
 * @author Michael Murdock
 * @version Project 2
 * @version CPE102-11
 * @version Spring 2015
 */
import java.lang.Object;
import java.awt.event.KeyEvent;


public class Explorer extends Occupant
{
	private String name;
	private Maze maze;

	public Explorer(Square location, Maze maze, String name)
	{
		super(location);
		this.name=name;
		this.maze=maze;
		maze.lookAround(location);
	}

	public String name()
	{
		return name;
	}

	public void move(int key)
	{
		int rows=maze.rows();
		int cols=maze.cols();
		Square square= super.location();
		int row=square.row();
		int col=square.col();

		if (key==KeyEvent.VK_UP || key==KeyEvent.VK_DOWN || key==KeyEvent.VK_LEFT || key==KeyEvent.VK_RIGHT || 
			key==KeyEvent.VK_KP_UP || key==KeyEvent.VK_KP_DOWN || key==KeyEvent.VK_KP_LEFT || key==KeyEvent.VK_KP_RIGHT)
		{
			if(key==KeyEvent.VK_LEFT || key==KeyEvent.VK_KP_LEFT) //left arrow key
			{
				if (square.wall(Square.LEFT)==false)
				{
					if (square.col()!=0)
					{
						moveTo(maze.getSquare(row, col-1));
					}
				}
			}

			if(key==KeyEvent.VK_UP || key==KeyEvent.VK_KP_UP) //up arrow key
			{
				if (square.wall(Square.UP)==false)
				{
					if (square.row()!=0)
					{
						moveTo(maze.getSquare(row-1, col));
					}
				}	
			}

			if(key==KeyEvent.VK_RIGHT || key==KeyEvent.VK_KP_RIGHT) //right arrow key
			{
				if (square.wall(Square.RIGHT)==false)
				{
					if (square.col()!=cols)
					{
						moveTo(maze.getSquare(row, col+1));
					}
				}
			}

			if(key==KeyEvent.VK_DOWN || key==KeyEvent.VK_KP_DOWN) //down arrow key
			{
				if(square.wall(Square.DOWN)==false)
				{
					if (square.row()!=rows)
					{
						moveTo(maze.getSquare(row+1, col));
					}	
				}
			}	
			
		}
	}

	public void moveTo(Square s)
	{
		super.moveTo(s);
		s.enter();
		maze.lookAround(s);
	}
}
