import java.io.*;
import java.util.*;

public class MRTester{
  public static void main (String args[]){
    try{
      MazeReader joe = new MazeReader("Maze1.txt");
      System.out.println(joe);
      int[] joe2 = joe.findStart();
      System.out.println(joe2[0] + " " + joe2[1]);
    }catch(FileNotFoundException e){
      System.out.println("FileNotFoundException is occurred");
    }
  }
}
