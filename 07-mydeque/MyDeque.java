import java.util.*;

public class MyDeque<E>{
      //fields
      private E[] data;
      private int size;
      private int start, end;

      //constructors
      public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        size = 0;
        start = (data.length/2);
        end = start-1;
      }
      public MyDeque(int initialCapacity){
        if (initialCapacity == 0) initialCapacity = 2;
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[initialCapacity];
        data = d;
        size = 0;
        start = (data.length/2);
        end = start - 1;
      }

      //accessor methods
      public int size(){
        return size;
      }
      public E getFirst(){
        if (data[start] == null) throw new NoSuchElementException();
        return data[start];
      }
      public E getLast(){
        if (data[end] == null) throw new NoSuchElementException();
        return data[end];
      }
      public String toStringD(){
        String joe = "[";
        if (data.length > 0){
        for(int i = 0; i < data.length-1; i++){
          joe += data[i] + ", ";
        }
        joe += data[data.length-1];
      }
        joe += "]";
        joe += "\n" + "START: " + start;
        joe += "\n" + "END: " + end;
        return joe;
      }
      public String toString(){
        String joe = "[";
        if (size != 0){
          if (start > end){
            for (int i = start; i < data.length; i++){
              joe += data[i] + ", ";
            }
            for (int i = 0; i < end; i++){
              joe += data[i] + ", ";
            }
            joe += data[end];
          } else {
            for (int i = start; i < end; i++){
              joe += data[i] + ", ";
            }
            joe += data[end];
          }
        }
        return joe + "]";
      }

      //adding
      public void addFirst(E element){
        if (element == null) throw new NullPointerException();
        if (size == 0){
          start--;
          data[start] = element;
          size++;
        } else if (size == data.length){
          resize();
          addFirst(element);
        } else if (start == 0){
          start = data.length;
          addFirst(element);
        } else {
          start--;
          data[start] = element;
          size++;
        }
      }
      public void addLast(E element){
        if (element == null) throw new NullPointerException();
        if (size == 0){
          end++;
          data[end] = element;
          size++;
        } else if (size == data.length){
          resize();
          addLast(element);
        } else if (end+1 == data.length){
          end = -1;
          addLast(element);
        } else {
          end++;
          data[end] = element;
          size++;
        }
      }

      //resize
      private void resize(){
        @SuppressWarnings("unchecked")
        E[] L = (E[])new Object[data.length*2];
        if (start == 0 && end == data.length - 1){
          int joe = data.length/2;
          for (int i = 0; i < joe; i++){
            L[i] = null;
          }
          for (int i = 0; i < data.length; i++){
            L[i+joe] = data[i];
          }
          for (int i = data.length + joe; i < data.length*2; i++){
            L[i] = null;
          }
          start += joe;
          end += joe;
        } else {
          for(int i = 0; i <= end; i++){
            L[i] = data[i];
          }
          for(int i = start; i < data.length; i++){
            L[i + data.length] = data[i];
          }
          start += data.length;
        }
        data = L;
      }

      //remove
      public E removeFirst(){
        if (size == 0) throw new NoSuchElementException();
        E joe = data[start];
        data[start] = null;
        if (start == data.length-1){
          start = 0;
        } else {
          start++;
        }
        size--;
        return joe;
      }
      public E removeLast(){
        if (size == 0) throw new NoSuchElementException();
        E joe = data[end];
        data[end] = null;
        if (end == 0){
          end = data.length - 1;
        } else {
          end--;
        }
        size--;
        return joe;
      }
    }
