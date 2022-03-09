import java.util.*;
import java.io.*;

public class Tester{
  public static void main(String args[]){
    try{
      long ans = Bronze.solve("lake1.input");
      System.out.println(ans);
    }catch(FileNotFoundException e){
                //error handling code
    }
  }
}


  public static int[][] elevation(int[][]grid, int elev){
    for(int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[i].length; j++){
        if (grid[i][j] > elev){
          grid[i][j] = 0;
        } else {
          grid[i][j] = elev - grid[i][j];
        }
      }
    }
    return grid;
  }

  public static long calc(int[][] grid){
    long counter = 0;
    for(int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[i].length; j++){
        counter += grid[i][j];
      }
    }
    counter = counter*72*72;
    return counter;
  }
