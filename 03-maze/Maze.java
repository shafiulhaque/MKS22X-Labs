import java.util.*;
import java.io.*;

          public class Maze{
            private char[][]maze;
            private boolean animate;//false by default
            private int startRow,startCol;

            /*Constructor loads a maze text file, and sets animate to false by default.
            When the file is not found then:
            throw a FileNotFoundException

            You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
            '#' - Walls - locations that cannot be moved onto
            ' ' - Empty Space - locations that can be moved onto
            'E' - the location of the goal if any (0 or more per file)
            'S' - the location of the start(exactly 1 per file)

            You may also assume the maze has a border of '#' around the edges.
            So you don't have to check for out of bounds!
            Some text editors always include a newline at the end of a file, but that is not always present.
            Make sure your file reading is able to handle this.
            */

            public Maze(String filename) throws FileNotFoundException{
              //COMPLETE CONSTRUCTOR
              getVals(filename);
              findStart();
              this.animate = false;
            }
            public Maze(char[][] maze){
              this.maze = maze;
              findStart();
              this.animate = false;
            }


            private void wait(int millis){
              try {
                Thread.sleep(millis);
              }
              catch (InterruptedException e) {
              }
            }

            public void setAnimate(boolean b){
              this.animate = b;
            }

            public static void clearTerminal(){
              //erase terminal
              System.out.println("\033[2J");
            }
            public static void gotoTop(){
              //go to top left of screen
              System.out.println("\033[1;1H");
            }


            /*Return the string that represents the maze.
            It should look like the text file with some characters replaced.
            */
            public String toString(){
                String mr = "";
                for (int i = 0; i < maze.length; i++){
                  for (int j = 0; j < maze[i].length; j++){
                    System.out.print(maze[i][j]);
                  }
                  System.out.println();
                }
                return mr;
            }

            public void getVals(String filename) throws FileNotFoundException{
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
              this.maze = new char[counter][];
              for (int i = 0; i < counter; i++){
                maze[i] = joe.get(i);
              }
            }

            public void findStart(){
              for (int i = 0; i < maze.length; i++){
                for (int j = 0; j < maze[i].length; j++){
                  if (maze[i][j] == 'S'){
                    this.startRow = i;
                    this.startCol = j;
                  }
                }
              }
            }

            /*Wrapper Solve Function returns the helper function
            Note the helper function has the same name, but different parameters.
            Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
            */
            public int solve(){
              //only clear the terminal if you are running animation
              if(animate){
                clearTerminal();
              }
              //start solving at the location of the s.
              return solve(startRow,startCol);

            }

            /*
            Recursive Solve function:

            A solved maze has a path marked with '@' from S to E.

            Returns the number of @ symbols from S to E when the maze is solved,
            Returns -1 when the maze has no solution.

            Postcondition:
            The 'S' is replaced with '@'
            The 'E' remain the same
            All visited spots that were not part of the solution are changed to '.'
            All visited spots that are part of the solution are changed to '@'
            */
            private int solve(int row, int col){ //you can add more parameters since this is private
              //automatic animation! You are welcome.
              //COMPLETE SOLVE

              if(maze[row][col] == 'E'){
                return 0;
              } else if (maze[row][col] == '@' || maze[row][col] == '#' || maze[row][col] == '.'){
                return -1;
              } else {
                maze[row][col] = '@';
                if(animate){
                  gotoTop();
                  System.out.println(this);
                  wait(50);
                }
                int s = solve(row+1, col);
                if (s > -1) return s+1;
                int n = solve(row-1, col);
                if (n > -1) return n+1;
                int w = solve(row, col-1);
                if (w > -1) return w+1;
                int e = solve(row, col+1);
                if (e > -1) return e+1;
                maze[row][col] = '.';
                if(animate){
                  gotoTop();
                  System.out.println(this);
                  wait(50);
                }
                return -1;
              }
            }
          }
