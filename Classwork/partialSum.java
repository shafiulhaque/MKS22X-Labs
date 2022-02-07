public class partialSum{
  public static boolean partialSum(int[] arr, int target){
          return partialSum(arr, target, 0);
        }

        public static boolean partialSum(int[] arr, int target, int total){
          if (target == total) return true;
          for (int i = 0; i < arr.length; i++){
            if (total == 0 || arr[i] != total){
              partialSum(arr, target, total + arr[i]);
            }
          }
          return false;
        }
  public static void main (String args[]){
      System.out.println("TEST PARTIAL SUM");
      int[] j1 = {2,4,8};
      System.out.println(partialSum(j1,10));
  }
}
