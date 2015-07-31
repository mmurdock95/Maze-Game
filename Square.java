/**
 * Square file for Project 3
 * Creates the square each object will be represented on.
 * @author Michael Murdock
 * @version Project 2
 * @version CPE102-11
 * @version Spring 2015
 */

import java.util.Scanner;

public class Square implements DelimitedTextIO
{
        public static final int SQUARE_SIZE=50; 
        public static final int UP=0;
        public static final int RIGHT=1;
        public static final int DOWN=2;
        public static final int LEFT=3;

	private boolean[] walls= new boolean[4];
	private boolean seen=false;
	private boolean inView=false;
	private int row=0;
	private int col=0;
	private Treasure treasure;

	public Square(int row, int col)
	{
		this.row=row;
		this.col=col;
	}

	public Square(boolean up, boolean right, boolean down, boolean left, int row, int col)
	{
		walls[0]=up;
		walls[1]=right;
		walls[2]=down;
		walls[3]=left;
		this.row=row;
		this.col=col;
	}

	public boolean wall(int direction)
	{
		if (direction==UP)
			return walls[UP];
		if (direction==RIGHT)
			return walls[RIGHT];
		if (direction==DOWN)
			return walls[DOWN];
		if (direction==LEFT)
			return walls[LEFT];
		return false;
	}

	public boolean seen()
	{
		return seen;
	}
	public boolean inView()
	{
		return inView;
	}
	public int row()
	{
		return row;
	}
	public int col()
	{
		return col;
	}
	public Treasure treasure()
	{
		return treasure;
	}

	public int x()
	{
		return col*SQUARE_SIZE;
	}

	public int y()
	{
		return row*SQUARE_SIZE;
	}

	public void setInView(boolean inView)
	{
		if (inView==true)
		{
			this.seen=true;
		}

		this.inView=inView;	
	}

	public void setTreasure(Treasure treasure)
	{

		this.treasure=treasure;
	}

	public void enter()
	{
		if (this.treasure!=null)
		{
			treasure.setFound();
		}
	}

	public String toText(char delimiter)
	{
		return getClass().getName() + delimiter + row() + delimiter + col() + delimiter + String.valueOf(wall(0))
			   + delimiter + String.valueOf(wall(1)) + delimiter + String.valueOf(wall(2)) + delimiter + String.valueOf(wall(3))
			   + delimiter + String.valueOf(seen) + delimiter + String.valueOf(inView); 
	}

	public void toObject(Scanner input)
	{
		walls[UP]=input.nextBoolean();
		walls[RIGHT]=input.nextBoolean();
		walls[DOWN]=input.nextBoolean();
		walls[LEFT]=input.nextBoolean();
		seen=input.nextBoolean();
		inView=input.nextBoolean();
	}

}
