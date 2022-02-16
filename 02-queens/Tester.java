public class Tester{
  public static void main (String args[]){
    // QueenBoard joe = new QueenBoard(8);
    // System.out.println(joe);
    // // System.out.println(Text.CLEAR_SCREEN);
    // // System.out.println(Text.HIDE_CURSOR);
    // // System.out.println(Text.go(1,1));
    // System.out.println(joe.countSolutions());
    // // System.out.println(Text.RESET);
    // System.out.println(joe);

    int SIZE = 8;
          if(args.length > 0){
            SIZE = Integer.parseInt(args[0]);
          }
          QueenBoard b = new QueenBoard(SIZE);
          if(args.length > 1){
            b.setAnimate(true);
            b.setDelay(Integer.parseInt(args[1]));
          }
          System.out.println(Text.CLEAR_SCREEN);
          System.out.println(Text.HIDE_CURSOR);
          System.out.println(Text.go(1,1));
          b.solve();
          System.out.println(Text.RESET);
          System.out.println(Text.go(1,1));
          System.out.println(b);
  }
}
