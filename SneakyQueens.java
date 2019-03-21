//Michael Groff COP 3503C

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.lang.*;

public class SneakyQueens
{
  public static ArrayList<Integer> ParseString(String queen, int boardSize)
  {//takes in strings from arryalist and parses them into 4 keys representing the 
    //rows, columns, and two diagonals the queen can attack in
    ArrayList<Integer> KeyLocations = new ArrayList<Integer>();
    int j=0;
    int k=0;
    int rows=0;
    int columns=0;
    int i=queen.length()-1;
    //starts the while loop at the end of the string in order to count up to avoid looping 
    //through twice just to get the length so we know which character is in what place
    while (i >= 0)
    {
      char point = queen.charAt(i);
      int numval = (int)point;
      //System.out.println(numval);
      if(numval < 58) //ascii for 9 is 57 all alphabet chars are higher than this
        rows += (numval-48)*Math.pow(10,j++);//converts to a integer denoting the row position
      else
        columns += (numval-96)*Math.pow(26,k++);//copnverts to an integer denoting the column postion
      i--;
    }

    KeyLocations.add(rows-1);//placing row keys in 0 to boardsize-1 position
    KeyLocations.add(-columns);//placing column keys into -boardsize to -1 positions
    KeyLocations.add(-rows + columns - 2*boardSize- 1);//placing first diagonals into -3*boardsize-1 to m-1 positions
    KeyLocations.add(columns + rows + boardSize);// placing second diagonals into boardsize to 3*boardsize postions
    return KeyLocations;
  }

  public static boolean allTheQueensAreSafe(ArrayList<String> coordinateStrings, int boardSize)
  {
    HashMap<Integer, Integer> UsedQueens = new HashMap<Integer, Integer>();
    //hash map where keys denote the rows, columns, and two diagonals the queen can attack in,
    // Using integers seems does put a bound on how big the boardsize can be which is 715827882
    ArrayList<Integer> KeyLocations = new ArrayList<Integer>();
    //makes an arraylist to hold the keys parsestring is going to return,
    // made more sense for the function to return all 4 at the same time instead of breaking it up into cases

    for(String queens : coordinateStrings)
    {
      KeyLocations = ParseString(queens, boardSize);
      //returns 4 keys representing all places where a queen can attack
      //System.out.println(KeyLocations);
      for(int j : KeyLocations)
      {
        if(UsedQueens.get(j) != null)//sees if another queen can attack for each of the 4 keys
          return false;
        else
          UsedQueens.put(j, 1);// if not places these keys in the map to check if other queens can attack
      }
    }
    return true;//if no queens were able to attack each other the function returns true
  }

  public static double difficultyRating()
  {
    return 2.1;// 
  }

  public static double hoursSpent()
  {
    return 3.0;// 
  }
}