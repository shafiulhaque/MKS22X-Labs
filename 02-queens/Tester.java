public class Tester{
  public static void main (String args[]){

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
          System.out.println("MR. K'S TESTER");
          System.out.println(b);

    System.out.println("TESTING NO OF SOLUTIONS");
    for (int i = 1; i <= 10; i++){
      QueenBoard joe = new QueenBoard(i);
      System.out.println(joe.countSolutions());
    }



  }
}
