public class Driver2{
  public static void main(String args[]){
    char[][] joe = new char[10][15];
    for (int i = 0; i < joe.length; i++){
      for (int j = 0; j < joe[i].length; j++){
        joe[i][j] = '#';
      }
    }
    MazeGenerator.generate(joe, 4, 5);
    System.out.println(MazeGenerator.toString(joe));
  }
}
