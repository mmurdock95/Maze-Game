public class Explorer
{

  private PVector direction; 
  private double x;
  private double y;
  
  public Explorer(double x, double y)
  {
    this.x=x;
    this.y=y;
    direction= new PVector(0,0);
  }
  
  public void draw()
  {
    pushMatrix();
      noStroke();
      translate((int)x, (int)y);
          
       //head 
       fill(255);
       ellipse(0,0,40,40);
       fill(255, 0 ,0);
       ellipse(-7, -7, 7, 7);
       ellipse(7, -7, 7, 7);
       fill(240,169,63);
       triangle(-1,0,-1,6,18,3);
          
       //mouth
       fill(0);
       arc(0, 7, 15, 20, 0, PI/2+PI/2);
       fill(255,255,255);
       stroke(0);
       rect(-3.5, 7, 7, 5);
     popMatrix();
  }
  
  public double getX()
  {
    return x;
  }
  
  public double getY()
  {
    return y;
  }
  
  public void move()
  {
    x=x+direction.x;
    y=y+direction.y;
  }
  
  public void setVector(PVector direction)
  {
    this.direction=direction;
  }


}
