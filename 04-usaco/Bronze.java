import java.util.*;
import java.io.*;

public class Bronze{
  public static long solve(String filename) throws FileNotFoundException {
    File text = new File(filename);
    Scanner input = new Scanner(text);

    String line = input.nextLine();
    String[] joe = line.split(" ");
    int[] starting = new int[joe.length];
    for (int i = 0; i < joe.length; i++){
      starting[i] = Integer.parseInt(joe[i]);
    }
    int row = starting[0];
    int col = starting[1];
    int elevation = starting[2];
    int no = starting[3];

    int[][] grid = new int[row][col];
    for (int i = 0; i < row; i++){
      String line2 = input.nextLine();
      String[] joe2 = line2.split(" ");
      for (int j = 0; j < col; j++){
        grid[i][j] = Integer.parseInt(joe2[j]);
      }
    }

    int[][] cmnd = new int[no][3];
    for (int i = 0; i < no; i++){
      String line3 = input.nextLine();
      String[] joe3 = line3.split(" ");
      for (int j = 0; j < 3; j++){
        cmnd[i][j] = Integer.parseInt(joe3[j]);
      }
    }
    input.close();
    toString(grid);
    for (int i = 0; i < no; i++){
      grid = cowStomp(cmnd[i][0], cmnd[i][1], cmnd[i][2], grid);
      toString(grid);
    }
    elevation(grid, elevation);
    toString(grid);
    return calc(grid);
  }

  public static void toString(int[][] joe){
    for (int i = 0; i < joe.length; i++){
      for (int j = 0; j < joe[i].length; j++){
        System.out.print(joe[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int[][] cowStomp(int row, int col, int sub, int[][] grid){
    int big = grid[row-1][col-1];
    for (int i = row-1; i < row+2; i++){
      for (int j = col-1; j < col+2; j++){
      if (i < grid.length && j < grid[i].length){
        if (big < grid[i][j]) big = grid[i][j];
      }
    }
    }
    System.out.println(big);

    int diff = big - sub;

    for (int i = row-1; i < row+2; i++){
      for (int j = col-1; j < col+2; j++){
      if (i < grid.length && j < grid[i].length){
        if (diff < grid[i][j]) grid[i][j] = diff;
      }
    }
  }
  return grid;
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
}
