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
    if (counter1 == left.length){
      for (int i = counter2; i < right.length; i++){
        joe[joelen] = right[i];
        joelen++;
      }
    } else {
      for (int i = counter1; i < left.length; i++){
        joe[joelen] = left[i];
        joelen++;
      }
    }
    return joe;
        }

    public static void mergesort(int[] data){
      int[] temp = mergeSortH(data);
      data = temp;
    }
        //
        // int[] mergesortH(data){
        //   if more than 1 element{
        //     left = copy half of data
        //     right = copy other half of data
        //     return merge(mergesortH(left),mergesortH(right))
        //   }
        // }

        public static String toString(int[] data){
          String joe = "";
          for (int i = 0; i < data.length-1; i++){
            joe += data[i] + ", ";
          }
          joe += data[data.length - 1];
          return joe;
        }

        public static void main(String args[]){
          int[] bruh = {1, 3, 7, 9, 11, 14, 19, 22};
          int[] bruh2 = {2, 4, 5, 7, 8, 12, 14, 18, 19, 27};
          int[] bro = merge(bruh, bruh2);
          System.out.println(toString(bro));
        }
}
