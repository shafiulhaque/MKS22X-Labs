import java.util.*;
import java.io.*;

public class Calculator{
      /*Evaluate a postfix expression stored in s.
      *Assume valid postfix notation, of ints doubles and operators separated by spaces.
      *Valid operators are + - / * and % (remainder not modulo)
      *All results are doubles even if the operands are both int.
      *@throws IllegalArgumentException when there are too many or too few operands.
      *        Use the string parameter of your exception to indicate what happened.
      *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
      */
      public static double eval(String s){
        Deque<Double> bruh = new ArrayDeque<Double>();
        Scanner joe2 = new Scanner(s);
        while (joe2.hasNext()){
          String bruh2 = joe2.next();
          if(bruh2.equals("+")){
            if (hasSpace(bruh)){
              Double joe = bruh.removeLast();
              Double joe3 = bruh.removeLast();
              bruh.addLast(joe+joe3);
            } else {
              throw new IllegalArgumentException("too few operands for operation " + bruh2);
            }
          } else if(bruh2.equals("-")){
            if (hasSpace(bruh)){
              Double joe = bruh.removeLast();
              Double joe3 = bruh.removeLast();
              bruh.addLast(joe3-joe);
            } else {
              throw new IllegalArgumentException("too few operands for operation " + bruh2);
            }
          } else if(bruh2.equals("/")){
            if (hasSpace(bruh)){
              Double joe = bruh.removeLast();
              Double joe3 = bruh.removeLast();
              bruh.addLast(joe3/joe);
            } else {
              throw new IllegalArgumentException("too few operands for operation " + bruh2);
            }
          } else if(bruh2.equals("*")){
            if (hasSpace(bruh)){
              Double joe = bruh.removeLast();
              Double joe3 = bruh.removeLast();
              bruh.addLast(joe3*joe);
            } else {
              throw new IllegalArgumentException("too few operands for operation " + bruh2);
            }
          } else if(bruh2.equals("%")){
            if (hasSpace(bruh)){
              Double joe = bruh.removeLast();
              Double joe3 = bruh.removeLast();
              bruh.addLast(joe3%joe);
            } else {
              throw new IllegalArgumentException("too few operands for operation " + bruh2);
            }
          } else {
            bruh.addLast(Double.parseDouble(bruh2));
          }
        }
        if (bruh.size() > 1){
          throw new IllegalArgumentException("too many operands");
        } else if (bruh.size() == 1){
          return bruh.getLast();
        } else {
          throw new IllegalArgumentException("too few operands");
        }
      }
      public static boolean hasSpace(Deque<Double> bruh){
        return (bruh.size() >= 2);
      }

      public static void main(String[] args){
        System.out.println(eval("10 2.0 +"));
        System.out.println(eval("11 3 - 4 + 2.5 *"));
        System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
        System.out.println(eval("1 2 3 4 5 + * - -"));
        System.out.println(eval("5 9 + 2 * 6 5 * +"));
        System.out.println(eval("18"));
        System.out.println(eval(""));
        System.out.println(eval("18 0 /"));
      }
    }
