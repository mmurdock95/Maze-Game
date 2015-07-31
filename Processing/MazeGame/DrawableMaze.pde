/**
 * DrawableMaze file for Project 3
 *
 * Extends Maze and allows user to implement draw() method. 
 *
 * @author Michael Murdock
 * @version Project 2
 * @version CPE102-11
 * @version Spring 2015
 */

public class DrawableMaze extends Maze implements Drawable
{

	public DrawableMaze(DrawableSquare[][] maze, int rows, int cols)
	{
          super(maze, rows, cols);
	}

	public void draw()
	{
          noStroke();
          fill(16, 68, 200);
          rect(0,0, 500 , 500);
             mountains = loadImage("data/photo2.png");
           mountains.loadPixels();
         image(mountains, 0, 0);
    

          for (int i = 0; i<rows(); i++) 
          {
           for (int j = 0; j<cols(); j++) 
           {
             ((DrawableSquare)getSquare(i, j)).draw();
           }
          }
  
          for(int i=0; i<getNumRandOccupants(); i++)
          {
            if (getRandomOccupant(i) instanceof Treasure)
            {
              ((DrawableTreasure)getRandomOccupant(i)).draw();
            }
            if (getRandomOccupant(i) instanceof Monster)
            {
              ((DrawableMonster)getRandomOccupant(i)).draw();
            }
          }
          ((DrawableExplorer)getExplorer()).draw();

        }
        
        

}


