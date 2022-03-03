import java.io.*;
import java.util.*;
public class Driver{
            public static void main(String[]args){

              //files do not require an extension like .txt or .dat
              String filename = args[0];
              boolean thing = Boolean.parseBoolean(args[1]);

              try{
                Maze f;
                f = new Maze(filename);
                f.setAnimate(thing);
                System.out.println(f);
                System.out.println(f.solve()+" steps");
                System.out.println(f);
              }catch(FileNotFoundException e){
                System.out.println("Invalid filename: "+filename);
              }
            }
          }
