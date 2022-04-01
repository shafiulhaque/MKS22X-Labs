import java.util.*;
import java.io.*;

public class FF{
  public static int[] solve(String filename){
    int[] joe = new int[2];
    try{
    File text = new File(filename);
    Scanner input = new Scanner(text);
    int x1 = input.nextInt();
    int x2 = input.nextInt();
    int y1 = input.nextInt();
    int y2 = input.nextInt();
    int z1 = input.nextInt();
    int z2 = input.nextInt();
    int xs = 0;
    int ys = 0;
    while (x1*xs + y1*ys != z1 && x2*xs + y2*ys != z2){
      if(x1*xs + y1*ys > z1 && x2*xs + y2*ys > z2){
        joe[0] = -1;
        joe[1] = -1;
        return joe;
      }
      if ((xs+ys)%2 == 0){
        xs++;
      } else {
        ys++;
      }
    }
    joe[0] = xs;
    joe[1] = ys;
    return joe;
  } catch (FileNotFoundException e){
    e.printStackTrace();
  }
  return joe;
  }
  public static void main (String[] args){
    System.out.println(Arrays.toString(solve("bruh.txt")));
  }

}
