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
        return data[start];
      }
      public E getLast(){
        return data[end];
      }
      public String toString(){
        String joe = "[";
        for(int i = 0; i < data.length-1; i++){
          joe += data[i] + ", ";
        }
        joe += data[data.length-1] + "]";
        return joe;
      }

      //adding
      public void addFirst(E element){
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
        } else if(start > end){
          for(int i = 0; i <= end; i++){
            L[i] = data[i];
          }
          for(int i = start; i < data.length; i++){
            L[i + data.length] = data[i];
          }
          start += data.length;
        } else {
          for(int i = 0; i <= start; i++){
            L[i] = data[i];
          }
          for(int i = end; i < data.length; i++){
            L[i + data.length] = data[i];
          }
          end += data.length;
        }
        data = L;
      }

      //remove
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
    }
