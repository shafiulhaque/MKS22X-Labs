public class Tester{
  public static void main (String args[]){
    QueenBoard joe = new QueenBoard(10);
    System.out.println(joe);
    System.out.println(Text.CLEAR_SCREEN);
    System.out.println(Text.HIDE_CURSOR);
    System.out.println(Text.go(1,1));
    joe.solve();
    System.out.println(Text.RESET);
    System.out.println(joe);
  }
}
