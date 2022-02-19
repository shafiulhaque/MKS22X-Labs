import java.io.*;
import java.util.*;

public class MazeReader {
  public static char[][] getVals(String filename) throws FileNotFoundException{
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

}
