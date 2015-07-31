/**
 * Maze file for Project 3
 * 
 * @author Michael Murdock
 * @version Project 2
 * @version CPE102-11
 * @version Spring 2015
 */

import java.util.*;
import java.io.*;

/**
 * Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author Michael Murdock
 * @version April 24, 2015
 */

public class Maze
{
   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
    
    // instance variables
   private Square[][] squares;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */

   public Maze()
   {
      randOccupants = new ArrayList<RandomOccupant>();    
   }
   public Maze(Square[][] squares, int rows, int cols)
   {
      this.squares=squares;
      this.rows=rows;
      this.cols=cols;
    
      randOccupants = new ArrayList<RandomOccupant>();    
   }
  
   // QUERIES
   public Square getSquare(int row, int col) { return squares[row][col]; }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}
  
   public RandomOccupant getRandomOccupant(int index) {return randOccupants.get(index);}
   public int getNumRandOccupants() {return randOccupants.size();}
  
   // COMMANDS
   public void addRandomOccupant(RandomOccupant ro) { randOccupants.add(ro); }
  
   public void setExplorer(Explorer e) {explorer = e;}
  
   public void explorerMove(int key)
   {
      explorer.move(key);
   }
  
   public void randMove()
   {
      for (int i=0; i<randOccupants.size(); i++)
      {
        randOccupants.get(i).move();
      }
   }
  
   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *    it is in the same location as the Explorer, return
    *    MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;
        
      if(foundAllTreasures()==true)
      {
        status=EXPLORER_WIN;
      }

      for (int i=0; i<randOccupants.size(); i++)
      {
        if(randOccupants.get(i) instanceof Monster)
        {
          if(explorer.location()==randOccupants.get(i).location())
          {
            status=MONSTER_WIN;
          }
        }
      }

      return status;
   }
  
   private boolean foundAllTreasures()
   {
      boolean foundAll = true;
        
      for (int i=0; i<randOccupants.size(); i++)
      {
        if(randOccupants.get(i) instanceof Treasure)
        {
          if(randOccupants.get(i).location().treasure().found()==false)
            foundAll=false;  
        }
      }

              
      return foundAll;
   }
    
   public void lookAround(Square s)
   {
      int row = s.row();
      int col = s.col();
        
      // Clear what was previously in view
      resetInView();
        
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);
        
      // CHANGE - Check the adjacent squares.  If there isn't a wall in the way, set their inview to true.
      //        - Check the diagonal squares.  If there isn't a wall in the way, set their inview to true.
      // dont be stressed be blessed
      if (s.wall(0)==false) //check up
      {
        Square sUP = getSquare(row-1, col);
        getSquare(row-1, col).setInView(true); //set down

        if (sUP.wall(3)==false) //check left
        {
          getSquare(row-1, col-1).setInView(true);
         // getSquare(row, col-1).setInView(true);
        }
        if (sUP.wall(1)==false) //check right
        {
          getSquare(row-1, col+1).setInView(true);
         // getSquare(row, col+1).setInView(true);    
        }
      }

      if (s.wall(1)==false) //right
      {
        Square sRight = getSquare(row, col+1);
        getSquare(row, col+1).setInView(true); //set right

        if (sRight.wall(0)==false) //up
        {
          getSquare(row-1, col+1).setInView(true);
         // getSquare(row-1, col).setInView(true);
          
        }
        if (sRight.wall(2)==false) //down
        {
          getSquare(row+1, col+1).setInView(true);
        //  getSquare(row+1, col).setInView(true);
        }
      }

      if (s.wall(2)==false) //down
      {
        Square sDown = getSquare(row+1, col);
        getSquare(row+1, col).setInView(true);

        if (sDown.wall(1)==false) //right
        {
          getSquare(row+1, col+1).setInView(true);
        //  getSquare(row, col+1).setInView(true);
        }
        if (sDown.wall(3)==false) //left
        {
          getSquare(row+1, col-1).setInView(true);
        }
      }

      if (s.wall(3)==false) //left
      {
              Square sLeft= getSquare(row, col-1);
              getSquare(row, col-1).setInView(true);
      
              if (sLeft.wall(0)==false) //up
              {
                getSquare(row-1, col-1).setInView(true);
               // getSquare(row-1, col).setInView(true);
              }
              if (sLeft.wall(2)==false) //down
              {
                getSquare(row+1, col-1).setInView(true);
              }
       }
      }
//      if (col!=0)
//      {
//        if (getSquare(row, col-1).wall(Square.RIGHT)==true && getSquare(row+1, col).wall(Square.UP))
//          getSquare(row+1, col-1).setInView(false);
//      }



   
    
   private void resetInView()
   {
      for (int i = 0; i<rows; i++) {
         for (int j = 0; j<cols; j++) {
            squares[i][j].setInView(false);
         }
      }
   }

   public void writeMazeToFile(String fileName) throws IOException
   {
      File out = new File(fileName);
      FileOutputStream fos = new FileOutputStream(out);

      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

      bw.write(rows + "," + cols);
      bw.newLine();

      for (int i=0; i<rows; i++)
      {
        for (int j=0; j<cols; j++)
        {
          bw.write(squares[i][j].toText(','));
          bw.newLine();
        }
      }
      bw.write(explorer.toText(','));
      bw.newLine();

      for (int l=0; l<randOccupants.size(); l++)
      {
        if(randOccupants.get(l) instanceof Treasure)
        {
          bw.write(randOccupants.get(l).toText(','));
          bw.newLine();
        }
      }

      for (int m=0; m<randOccupants.size(); m++)
      {
        if(randOccupants.get(m) instanceof Monster)
        {
          bw.write(randOccupants.get(m).toText(','));
          bw.newLine();
        }
      }

      bw.close();

   }
  public void readMazeFromFile(String fileName) throws IOException, FileNotFoundException, MazeReadException
  {
    Scanner s = new Scanner(new File(fileName));
    String line;
    int numLine = 1;

    while (s.hasNextLine())
    {
      line = s.nextLine();
      try
      {
        Scanner newS = new Scanner(line);
        newS.useDelimiter(",");
        
        if (numLine == 1)
        {
          try
          {
             rows = newS.nextInt();
             cols = newS.nextInt();
          }
          catch (NoSuchElementException n)
          {
            throw new MazeReadException("Rows and columns not specified.",line,numLinex1x);
          }
          squares = new Square[rows][cols];
          numLine+=1;
          continue;
        }

        String kind = newS.next();
        if (kind.equals("Square"))
        {
          Square newSquare = new Square(newS.nextInt(), newS.nextInt());
          newSquare.toObject(newS);

          if (squares[newSquare.row()][newSquare.col()] != null)
          {
            throw new MazeReadException("Duplicate square.", line, numLine);
          }

          squares[newSquare.row()][newSquare.col()] = newSquare;
        }
        else if (kind.equals("Explorer"))
        {
          Explorer newExplorer = new Explorer(this);
          newExplorer.toObject(newS);
          setExplorer(newExplorer);
        }
        else if (kind.equals("Treasure"))
        {
          Treasure newTreasure = new Treasure(this);
          newTreasure.toObject(newS);
          randOccupants.add(newTreasure);

        }
        else if (kind.equals("Monster"))
        {
          Monster newMonster = new Monster(this);
          newMonster.toObject(newS);
          randOccupants.add(newMonster);
        }
        else
        {
          throw new MazeReadException("Unknown type.", line, numLine);
        }
      }
      catch (NoSuchElementException e)
      {
        throw new MazeReadException("Line format or other error.", line, numLine);
      }
      numLine+=1;
    }
  }
}






