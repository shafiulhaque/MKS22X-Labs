public class Merge{
  public static int[] merge(int [] left, int[] right){
    //return a new array that is the merged version of left and right
    int counter1 = 0;
    int counter2 = 0;
    int joelen = 0;
    int[] joe = new int[left.length + right.length];
    while(counter1 < left.length && counter2 < right.length){
      if(left[counter1] < right[counter2]){
        joe[joelen] = left[counter1];
        joelen++;
        counter1++;
      } else {
        joe[joelen] = right[counter2];
        joelen++;
        counter2++;
      }
    }
      for (int i = counter2; i < right.length; i++){
        joe[joelen] = right[i];
        joelen++;
      }
      for (int i = counter1; i < left.length; i++){
        joe[joelen] = left[i];
        joelen++;
      }
    return joe;
  }

    public static void mergesort(int[] data){
      int[] temp = mergesortH(data);
      for(int i = 0; i < data.length; i++){
        data[i] = temp[i];
      }
    }

    public static int[] mergesortH(int[] data){
      if (data.length < 2){
        return data;
      } else {
        int half = data.length/2;
        int other = data.length - half;
        int[] left = new int[half];
        int[] right = new int[other];
        for (int i = 0; i < half; i++){
          left[i] = data[i];
        }
        for (int j = 0; j < other; j++){
          right[j] = data[j+half];
        }
        return merge(mergesortH(left), mergesortH(right));
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
          System.out.println("MERGE TEST CASES");
          int[] bruh = {1, 3, 7, 9, 11, 14, 19, 22};
          int[] bruh2 = {2, 4, 5, 7, 8, 12, 14, 18, 19, 27};
          int[] bro = merge(bruh, bruh2);
          System.out.println(toString(bro));
          System.out.println();

          System.out.println("MERGE SORT TEST CASES");
          int[] data = {999,999,999,4,3,2,1,0,999,999,999};
          mergesort(data);
          System.out.println(toString(data));
          int[] data2 = {32, 42, 5, 62, 6, 2, 6, 190, 9};
          mergesort(data2);
          System.out.println(toString(data2));
          int[] data3 = {4, 3, 2, 6, 1, 9, 5, 7, 2, 2, 10};
          mergesort(data3);
          System.out.println(toString(data3));
          int[] data4 = {103, 294, 209, 289, 104, 603, 952, 234, 509, 203};
          mergesort(data4);
          System.out.println(toString(data4));
          int[] data5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
          mergesort(data5);
          System.out.println(toString(data5));
          int[] data6 = {4,3,2,1,0,997,998,999};
          mergesort(data6);
          System.out.println(toString(data6));
          int[] data7 = {0,0,0,0,0,0,0,0,0,0,0};
          mergesort(data7);
          System.out.println(toString(data7));
        }
}
