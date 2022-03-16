public class Quick{
  public static int partition ( int [] data, int start, int end){

  int p = (int)(Math.random()*(end - start + 1)) + start;
  int holder = data[start];
  data[start] = data[p];
  data[p] = holder;
  p = start;

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

  }
  return p;
}

  public static int[] partitionDutch(int[] data,int start, int end){
    int p = (int)(Math.random()*(end - start + 1)) + start;
    int holder = data[start];
    data[start] = data[p];
    data[p] = holder;
    p = start;
    int holder3 = 1;

  int counter = 0;
  for (int i = start+1; i <= end; i++){
    boolean joe = data[i] > data[p];

    if (data[i] == data[p]){
      p++;
      holder3++;
    } else if (joe){
      int holder2 = data[end];
      data[end] = data[i];
      data[i] = holder2;
      i--;
      end--;
    } else {
      int holder2 = data[i-holder3];
      data[i-holder3] = data[i];
      data[i] = holder2;
      p++;
    }
  }
  int[] joe = {p-holder3+1, p};
  return joe;
}

  public static int quickselect(int[]data, int k){
    int start = 0;
    int end = data.length-1;
    int joe = partition(data, start, end);
    while (k != joe){
      if (k < joe){
        end = joe - 1;
      } else {
        start = joe + 1;
      }
      joe = partition(data, start, end);
    }
    return data[k];
  }

  public static void quicksort(int[]data){
    quicksort(data, 0, data.length-1);
  }

  public static void quicksort(int[]data, int low, int high){
    if (high > low && high != low){
      int[] joe = partitionDutch(data, low, high);
      quicksort(data, low, joe[0]-1);
      quicksort(data, joe[1]+1, high);
    }
  }

  public static void quicksort2(int[]data, int low, int high){
    if (high > low && high != low){
      int joe = partition(data, low, high);
      quicksort(data, low, joe-1);
      quicksort(data, joe+1, high);
    }
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

    System.out.println("QUICKSELECT TEST CASES");
    int[] ary = {2, 10, 15, 23, 0, 5};
    for (int i = 0; i < ary.length; i++){
      System.out.println(quickselect(ary, i));
    }
    int[] randish = new int[1000000];
    for(int i = 0 ; i < 1000000; i++){
      randish[i] =(int)(Math.random()*100000);
    }
    // for (int i = 0; i < randish.length; i++){
    //   System.out.println(quickselect(randish, i));
    // }

    System.out.println("QUICKSORT TEST CASES");
    int[] data10 = {3, 5, 1, 7, 2, 9, 3, 6, 1, 1, 9, 4};
    quicksort(data10);
    System.out.println(toString(data10));
    int[] randish2 = new int[1000000];
    for(int i = 0; i < 1000000; i++){
      randish2[i] =(int)(Math.random()*100000);
    }
    System.out.println("starting sort...");
    quicksort(randish2);
    // for(int i = 0; i < 1000000; i++){
    //   System.out.println(randish2[i]);
    // }
    System.out.println("finished!");

    System.out.println("DUTCH PARTITION TEST CASES");
    int[] data11 = {312, 412, 51, 51, 51, 51, 16, 190, 91};
    int[] bruh = partitionDutch(data11, 0, data11.length-1);
    System.out.println(toString(data11));
    System.out.println(bruh[0]);
    System.out.println(bruh[1]);
  }

}
