public class splitArray{
  public static boolean splitArray(int[] arr){
    return splitArray(arr, 0, 0, 0);
  }
  public static boolean splitArray(int[] arr, int start, int total1, int total2){
    if (start == arr.length){
      if (total1 == total2) return true;
      return false;
    }
    boolean joe = false;
    joe = joe || splitArray(arr, start+1, total1, total2+arr[start]);
    joe = joe || splitArray(arr, start+1, total1+arr[start], total2);
    return joe;
  }


  public static void main (String args[]){
      System.out.println("TEST SPLITARRAY SUM");
      int[] j1 = {2,5,8};
      System.out.println(splitArray(j1));
  }
}
