/**
 * DrawableTreasure file for Project 3
 *
 * Extends Treasure and allows user to implent draw method.
 *
 * @author Michael Murdock
 * @version Project 2
 * @version CPE102-11
 * @version Spring 2015
 */

public class DrawableTreasure extends Treasure implements Drawable
{
	public DrawableTreasure(Maze maze)
	{
		super(maze);
	}

	public DrawableTreasure(Maze maze, long seed)
	{
		super(maze, seed);
	}

	public DrawableTreasure(Maze maze, Square location)
	{
		super(maze, location);
	}

	public void draw()
	{

      //         if(location().seen()==true)
      //         {
      //           pushMatrix();
      //              translate(this.location().x(), this.location().y());
      //              translate(25, 25);

      //             noStroke();
      //             //white outline
      //             fill(255);
      //             ellipse(0,0,50,50);
      //             fill(0,0,255);
      //             //blue triangles
      //             triangle(-13, 0, 13, 0, 0, 25); 
      //             triangle(-13, 0, 13, 0, 0, -25);  
      //             triangle(0, -13, 0, 13, 25, 0); 
      //             triangle(0, -13, 0, 13, -25, 0);
      //             triangle(-18, 18, -8, -8, 8, 8); 
      //             triangle(18, 18, 8, -8, -8, 8);  
      //             triangle(18, -18, 8, 8, -8, -8);  
      //             triangle(-18, -18, 8, -8, -8, 8); 
      //             //white middle
      //             fill(76, 181, 234);
      //             ellipse(-7,-4,6,6);
      //             ellipse(7,-4,6,6);
      //             fill(255, 40, 40);
      //             arc(0, 4, 13, 16, 0, PI/2+PI/2);
      //           popMatrix();
                
      //           if (found()==true)
      //           {
      //             pushMatrix();
      //               translate(this.location().x(), this.location().y());
      //               translate(25, 25);
    
      //               noStroke();
      //               //white outline
      //               fill(200);
      //               ellipse(0,0,50,50);
      //               fill(0,0,175);
      //               //blue triangles
      //               triangle(-13, 0, 13, 0, 0, 25); 
      //               triangle(-13, 0, 13, 0, 0, -25);  
      //               triangle(0, -13, 0, 13, 25, 0); 
      //               triangle(0, -13, 0, 13, -25, 0);
      //               triangle(-18, 18, -8, -8, 8, 8); 
      //               triangle(18, 18, 8, -8, -8, 8);  
      //               triangle(18, -18, 8, 8, -8, -8);  
      //               triangle(-18, -18, 8, -8, -8, 8); 
      //               //white middle
      //               fill(76, 181, 234);
      //               ellipse(-7,-4,6,6);
      //               ellipse(7,-4,6,6);
      //               fill(255, 40, 40);
      //              // arc(0, 4, 13, 16, 0, PI/2+PI/2);
      //             popMatrix();
      //           }
      //       } 
         
      
        
   }
                     
}

