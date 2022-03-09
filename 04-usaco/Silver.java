import java.util.*;
import java.io.*;

public class Silver {
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
    int time = starting[2];

    char[][] grid = new char[row][col];
    for (int i = 0; i < row; i++){
      String line2 = input.nextLine();
      for (int j = 0; j < col; j++){
        grid[i][j] = line2.charAt(j);
      }
    }

    String line3 = input.nextLine();
    String[] joe3 = line3.split(" ");
    int[] end = new int[joe3.length];
    for (int i = 0; i < joe3.length; i++){
      end[i] = Integer.parseInt(joe3[i]);
    }
    int x1 = end[0];
    int y1 = end[1];
    int x2 = end[2];
    int y2 = end[3];
    toString(grid);
    int[][] bruh = toStringChar(grid);
    toString(bruh);
    bruh = solver(bruh, time);
    toString(bruh);
    return bruh[x2-1][y2-1];
  }

  public static void toString(char[][] grid){
    for (int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[i].length; j++){
        System.out.print(grid[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void toString(int[][] grid){
    for (int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[i].length; j++){
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static int[][] toStringChar(char[][] grid){
    int[][] joe = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[i].length; j++){
        if (grid[i][j] == '.') joe[i][j] = 0;
        if (grid[i][j] == '*') joe[i][j] = -1;
      }
    }
    return joe;
  }

  public static int[][] spread(int[][] grid){
    int[][] joe = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[i].length; j++){
        if (grid[i][j] > 0){
          if(i > 0 && grid[i-1][j] != -1) joe[i-1][j] += grid[i][j];
          if(i < grid.length-1 && grid[i+1][j] != -1) joe[i+1][j] += grid[i][j];
          if(j > 0 && grid[i][j-1] != -1) joe[i][j-1] += grid[i][j];
          if(j < grid[i].length-1 && grid[i][j+1] != -1) joe[i][j+1] += grid[i][j];
        }
      }
    }
    return joe;
  }

  public static int[][] solver(int[][] grid, int time){
    if (time == 0) return grid;
    grid = spread(grid);
    return solver(grid, time-1);
  }



}
