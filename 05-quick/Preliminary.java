public class Preliminary{
  public static int partition ( int [] data, int start, int end){
//  System.out.println(toString(data));
  int p = (int)(Math.random()*(end - start + 1)) + start;
  int holder = data[start];
  data[start] = data[p];
  data[p] = holder;
  p = start;

//  System.out.println(toString(data));
//  System.out.println("p: " + p);
  int counter = 0;
  for (int i = start+1; i <= end; i++){
    boolean joe = data[i] > data[p];

    if (data[i] == data[p]){
      if(counter%2 == 0) joe = true;
      counter++;
    }

    if (joe){
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

  //  System.out.println(toString(data));
  //  System.out.println("p: " + p);
  }
  return p;
}

  public static int quickselect(int []data, int k){
    int joe = partition(data, 0, data.length-1);
    while (k != joe){
      if (k > joe){
        joe = partition(data, joe, data.length-1);
      } else {
        joe = partition(data, 0, joe);
      }
    }
    return data[k];
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
    System.out.println("PARTITION TEST CASES");
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
    int[] data6 = {4,3,2,1,0,997,998,999};
    System.out.println(partition(data6, 0, data6.length-1));
    int[] data7 = {0,0,0,0,0,0,0,0,0,0,0};
    System.out.println(partition(data7, 0, data7.length-1));

    System.out.println("QUICKSORT TEST CASES");
    int[] ary = {2, 10, 15, 23, 0, 5};
    for (int i = 0; i < ary.length; i++){
      System.out.println(quickselect(ary, i));
    }


  }

}
