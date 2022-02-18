import java.io.*;
import java.util.*;

public class MazeReader {
  public static char[][] getVals(String filename) throws FileNotFoundException{
    int col = 0;
    int row = 0;
    File text = new File(filename);
    Scanner input = new Scanner(text);
    while (input.hasNextLine()){
      String line = input.nextLine();
      row++;
      for (int i = 0; i < line.length(); i++){
        col++;
      }
    }
    col = col/row;
    input.close();

    char[][] joe = new char[row][col];
    File text2 = new File(filename);
    Scanner input2 = new Scanner(text2);
    int countrow = 0;
    while (input2.hasNextLine()){
      String line = input2.nextLine();
      for (int i = 0; i < line.length(); i++){
        joe[countrow][i] = line.charAt(i);
      }
      countrow++;
    }
    return joe;
  }

  public static void main (String args[]){
    char[][]nums;
    try{
      nums = getVals("Maze1.txt");
      for (int i = 0; i < nums.length; i++){
        for (int j = 0; j < nums[i].length; j++){
          System.out.print(nums[i][j]);
        }
        System.out.println();
      }
    }catch(FileNotFoundException e){
      System.out.println("FileNotFoundException is occurred");
    }
  }

}
