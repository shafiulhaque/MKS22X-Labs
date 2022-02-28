import java.io.*;
import java.util.*;

public class MazeReader {
  //fields
  private char[][] maze;
  private boolean animated;
  private int delay;

  //constructor
  public MazeReader(String filename) throws FileNotFoundException{
    this.maze = getVals(filename);
    this.delay = 1000;
    this.animated = false;
  }

  //mutator methods
  public void setAnimate(boolean newValue){
    this.animated = newValue;
  }

  public void setDelay(int newValue){
    if (newValue < 0) this.delay = 0;
    this.delay = newValue;
  }

  //reading methods
  public char[][] getVals(String filename) throws FileNotFoundException{
    ArrayList<char[]> joe = new ArrayList<char[]>();
    int counter = 0;
    File text = new File(filename);
    Scanner input = new Scanner(text);
    while (input.hasNextLine()){
      String line = input.nextLine();
      char[] bruh = line.toCharArray();
      joe.add(bruh);
      counter++;
    }
    input.close();
    char[][] maze = new char[counter][];
    for (int i = 0; i < counter; i++){
      maze[i] = joe.get(i);
    }
    return maze;
  }

  public String toString(){
    String mr = "";
    for (int i = 0; i < maze.length; i++){
      for (int j = 0; j < maze[i].length; j++){
        System.out.print(maze[i][j]);
      }
      System.out.println();
    }
    return mr;
  }

  //solvers
  public int[] findStart(){
    int[] bruh = new int[2];
    for (int i = 0; i < maze.length; i++){
      for (int j = 0; j < maze[i].length; j++){
        if (maze[i][j] == 'S'){
          bruh[0] = i;
          bruh[1] = j;
        }
      }
    }
    return bruh;
  }

  // private int[] canGo(){
  //
  // }
  //
  // public int[][] moveWhere(){
  //   int[] joe = findStart();
  //   if (joe[0] > 1){
  //     if ()
  //   }
  // }




}
