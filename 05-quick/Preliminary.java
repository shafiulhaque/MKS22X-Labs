public class Preliminary{
  public static int partition2 ( int [] data, int start, int end){
  int p = (int)(Math.random()*(end - start + 1)) + start;
  System.out.println(toString(data));
    for (int i = start; i <= end; i++){
      if (i != p){
        if (data[i] >= data[p]){
          if (end != p){
          int holder = data[end];
          data[end] = data[i];
          data[i] = holder;
          i--;
          end--;
        } else {
          int holder = data[end];
          data[end] = data[i];
          data[i] = holder;
          p = i;
          end--;
        }
        } else {
          if (i != start && p == i-1){
          int holder = data[i-1];
          data[i-1] = data[i];
          data[i] = holder;
          p++;
        } else if (i != start){
          int holder = data[i-1];
          data[i-1] = data[i];
          data[i] = holder;
        }
        }
      }
      System.out.println(toString(data));
      System.out.println("p: " + p);
    }
    System.out.println();
    return p;
  }

  public static int partition ( int [] data, int start, int end){
  System.out.println(toString(data));
  int p = (int)(Math.random()*(end - start + 1)) + start;
  int holder = data[start];
  data[start] = data[p];
  data[p] = holder;
  p = start;
  System.out.println(toString(data));
  System.out.println("p: " + p);
  for (int i = start+1; i <= end; i++){
    if (data[i] >= data[p]){
      int holder2 = data[end];
      data[end] = data[i];
      data[i] = holder2;
      i--;
      end--;
    } else {
      int holder2 = data[i-1];
      data[i-1] = data[i];
      data[i] = holder2;
      p++;
    }
    System.out.println(toString(data));
    System.out.println("p: " + p);
  }
  return p;
}

  public static String toString(int[] data){
    String joe = "";
    for (int i = 0; i < data.length-1; i++){
      joe += data[i] + ", ";
    }
    joe += data[data.length - 1];
    return joe;
  }

  public static void main(String args[]){
    int[] data = {999,999,999,4,3,2,1,0,999,999,999};
    System.out.println(partition(data, 3, 7));
    int[] data2 = {32, 42, 5, 62, 6, 2, 6, 190, 9};
    System.out.println(partition(data2, 3, 7));
    int[] data3 = {4, 3, 2, 6, 1, 9, 5, 7, 2, 2, 10};
    System.out.println(partition(data3, 3, 7));
    int[] data4 = {103, 294, 209, 289, 104, 603, 952, 234, 509, 203};
    System.out.println(partition(data4, 3, 7));
    int[] data5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(partition(data5, 3, 7));

  }
}
