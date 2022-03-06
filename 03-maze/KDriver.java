import java.io.*;
  public class KDriver{
      public static void main(String[]args){
          if(args.length == 4){
            int rows = Integer.parseInt(args[0]);
            int cols = Integer.parseInt(args[1]);
            int startrow = Integer.parseInt(args[2]);
            int startcol = Integer.parseInt(args[3]);
            char[][]maze = new char[rows][cols];
            for (int i = 0; i < maze.length; i++){
              for (int j = 0; j < maze[i].length; j++){
                maze[i][j] = '#';
              }
            }
            MazeGenerator.generate(maze,startrow,startcol);
            MazeGenerator.toString(maze);
            Maze m = new Maze(maze);
            m.setAnimate(true);
            System.out.println(m.solve());
            System.out.println("MAZE!");//You need a way to show the maze without the array brackets etc.

          }else if(args.length == 1  || args.length == 2){
              try{
                  Maze m = new Maze(args[0]);
                  if(args.length == 2){ //any 2nd parameter turns on animate.
                      m.setAnimate(true);
                  }
                  System.out.println(m.solve());
                  System.out.println(m);
              }catch(FileNotFoundException e){
                  System.out.println(e);
              }
          }else{
              System.out.println("Usage:");
              System.out.println("To solve:    java KDriver FILE_NAME");
              System.out.println("To animate:  java KDriver FILE_NAME animated");
              System.out.println("To Generate: java KDriver rows cols startRow startCol");
          }

      }
  }
