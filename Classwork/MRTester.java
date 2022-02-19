import java.io.*;
import java.util.*;

public class MRTester{
  public static void main (String args[]){
    char[][]nums;
    try{
      nums = MazeReader.getVals("Maze1.txt");
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
