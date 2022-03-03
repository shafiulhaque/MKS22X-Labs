public class MazeGenerator{
  public static boolean canCarve(char[][]maze, int row, int col){
    if (row == 0 || row == maze.length-1 || col == 0 || col == maze[0].length-1) return false;
    int counter = 0;
    if (maze[row][col-1] == '#') counter++;
    if (maze[row][col+1] == '#') counter++;
    if (maze[row-1][col] == '#') counter++;
    if (maze[row+1][col] == '#') counter++;
    return (counter < 2);
  }
  public static void generate(char[][]maze, int startrow, int startcol){
    if (canCarve(maze, startrow, startcol)){
      maze[startrow][startcol] = ' ';
    }
    generate(maze, startrow+1, startcol);
    generate(maze, startrow-1, startcol);
    generate(maze, startrow, startcol+1);
    generate(maze, startrow, startcol-1);

  }
  public String toString(char[][]maze){
      String mr = "";
      for (int i = 0; i < maze.length; i++){
        for (int j = 0; j < maze[i].length; j++){
          System.out.print(maze[i][j]);
        }
        System.out.println();
      }
      return mr;
  }
}
