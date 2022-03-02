import java.io.*;
import java.util.*;
public class Driver{
            public static void main(String[]args){

              //files do not require an extension like .txt or .dat
              String filename = "maze1";

              try{
                Maze f;
                f = new Maze(filename);
                f.setAnimate(true);
                System.out.println(f);
                System.out.println(f.solve()+" steps");
                System.out.println(f);
              }catch(FileNotFoundException e){
                System.out.println("Invalid filename: "+filename);
              }
            }
          }
