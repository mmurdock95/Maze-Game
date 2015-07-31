/**
 * DrawableMonster file for Project 3
 *
 *Extends Monster and allows user to implement draw method.
 *
 * @author Michael Murdock
 * @version Project 2
 * @version CPE102-11
 * @version Spring 2015
 */

public class DrawableMonster extends Monster implements Drawable
{
	public DrawableMonster(Maze maze)
	{
		super(maze);
	}

	public DrawableMonster(Maze maze, long seed)
	{
		super(maze, seed);
	}

	public DrawableMonster(Maze maze, Square location)
	{
		 super(maze, location);
	}

	public void draw()
	{
            // if (location().inView()==true)
            // {
            //     pushMatrix();
            //       translate(this.location().x(), this.location().y());
            //       translate(25, 25);
            //       noStroke();
                  
            //        //head 
            //        fill(255);
            //        ellipse(0,0,40,40);
            //        fill(255, 0 ,0);
            //        ellipse(-7, -7, 7, 7);
            //        ellipse(7, -7, 7, 7);
            //        fill(240,169,63);
            //        triangle(-1,0,-1,6,18,3);
            //        fill(107,87,49);
            //        rect(20,0,25,2);
            //        rect(-20,0,-25,2);
            //        pushMatrix();
            //          translate(10,-25);
            //          pushMatrix();
            //            rotate(.785);
            //            rect(35,0,10,2);
            //          popMatrix();
            //       popMatrix();
            //       pushMatrix();
            //         translate(10, 25);
            //         pushMatrix();
            //            rotate(5.5);
            //            rect(35,0,10,2);
            //          popMatrix();
            //       popMatrix();
                  
            //       pushMatrix();
            //         translate(0, 2);
            //         rotate(PI);
            //           pushMatrix();
            //              translate(10,-25);
            //              pushMatrix();
            //                rotate(.785);
            //                rect(35,0,10,2);
            //              popMatrix();
            //           popMatrix();
            //           pushMatrix();
            //             translate(10, 25);
            //             pushMatrix();
            //                rotate(5.5);
            //                rect(35,0,10,2);
            //              popMatrix();
            //           popMatrix();
            //       popMatrix();
                   
                  
                  
            //        //mouth
            //        fill(0);
            //        arc(0, 7, 15, 20, 0, PI/2+PI/2);
            //        fill(255,255,255);
            //        stroke(0);
            //        rect(-3.5, 7.5, 7, 5);
            //      popMatrix();
            // }
	}
}
