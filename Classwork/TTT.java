import java.util.*;
public class TTT{
  public static int[] solve(int input){
    ArrayList<Integer> joe = new ArrayList<Integer>();
    for (int i = 1; i < input; i++){
      for (int j = 1; j < input; j++){
        if (j*j + i*i == input*input){
          joe.add(i);
          joe.add(j);
        }
      }
    }
    int[] bruh = new int[joe.size()];
    for(int i = 0; i < bruh.length; i++){
      bruh[i] = joe.get(i);
    }
    return bruh;
  }

  public static void main(String[] args){
    int joe = 25;
    System.out.println(Arrays.toString(solve(25)));
  }
}
