public class Tester{
  public static void main(String[] args){
    MyDeque<Integer> joe = new MyDeque<Integer>(10);
    System.out.println(joe.toString());
    joe.addFirst(21);
    joe.addFirst(42);
    joe.addFirst(652);
    joe.addFirst(8);
    joe.addFirst(62);
    joe.addFirst(97);
    joe.addLast(22);
    joe.removeLast();
    joe.addLast(22);
    System.out.println(joe.toString());
  }
}
