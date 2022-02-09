public class partialSum{
  public static boolean partialSum(int[] arr, int target){
          return partialSum(0, arr, target);
        }

        public static boolean partialSum(int start, int[] arr, int target){
          if (target == 0) return true;
          if (target < 0) return false;
          boolean joe = false;
          if (start < arr.length){
          for (int i = start; i < arr.length; i++){
            joe = joe || partialSum(start+1, arr, target-arr[start]);
            joe = joe || partialSum(start+1, arr, target);
          }
        }
          return joe;
        }

  public static void main (String args[]){
      System.out.println("TEST PARTIAL SUM");
      int[] j1 = {2,4,8};
      System.out.println(partialSum(j1,7));
  }
}
