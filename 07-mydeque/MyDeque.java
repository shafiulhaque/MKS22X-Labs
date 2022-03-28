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
        start = data.length/2;
        end = start + 1;
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

      public void addFirst(E element){
        if (size == 0){
          data[start] = element;
        } else if (size == data.length){
          resize();
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
        if (size == 0){
          data[end] = element;
        } else if (size == data.length){
          resize();
        } else if (end == data.length){
          end = -1;
          addLast(element);
        } else {
          end++;
          data[end] = element;
          size++;
        }
      }

      private void resize(){
        
      }

      public E removeFirst(){
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

      public E getFirst(){
        return data[start];
      }
      public E getLast(){
        return data[end];
      }
    }
