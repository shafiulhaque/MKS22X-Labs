public class MyDeque<E>{
      private E[] data;
      private int size;
      private int start, end;

      //constructors
      public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        size = 0;
        start = data.length/2;
        end = start + 1;
      }

      public MyDeque(int initialCapacity){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[initialCapacity];
        data = d;
        size = 0;
      }

      public int size(){
        return size;
      }

      public String toString(){
        String joe = "[";
        for(int i = 0; i < data.length-1; i++){
          joe += data[i] + ", ";
        }
        joe += data[data.length-1] + "]";
        return joe;
      }
      
      public void addFirst(E element){ }
      public void addLast(E element){ }
      public E removeFirst(){ }
      public E removeLast(){ }
      public E getFirst(){ }
      public E getLast(){ }
    }
