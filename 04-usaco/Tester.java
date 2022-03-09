import java.util.*;
import java.io.*;

public class Tester{
  public static void main(String args[]){
    try{
      long ans = Bronze.solve("lake1.input");
      System.out.println(ans);
      long ans2 = Silver.solve("cowPath1.input");
      System.out.println(ans2);

    }catch(FileNotFoundException e){
                //error handling code
    }
  }
}
