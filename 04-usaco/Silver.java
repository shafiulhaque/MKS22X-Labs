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
        System.out.println(grid[i][j]);
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

    return 0;
  }
}
