public class recursionForReal{
  public static boolean groupSum6(int start, int[] nums, int target) {
    if (target == 0 && start == nums.length) return true;
            if (target < 0) return false;
            boolean joe = false;
            if (start < nums.length){
              joe = joe || groupSum6(start+1, nums, target-nums[start]);
              if (nums[start] != 6) joe = joe || groupSum6(start+1, nums, target);
          }
    return joe;
  }
  public static boolean groupSum5(int start, int[] nums, int target) {
  if (target == 0 && start == nums.length) return true;
          if (target < 0) return false;
          boolean joe = false;
          if (start < nums.length){
            if(start == 0 || nums[start-1]%5 != 0 || nums[start] != 1) joe = joe || groupSum5(start+1, nums, target-nums[start]);
            if (nums[start]%5 != 0) joe = joe || groupSum5(start+1, nums, target);
        }
  return joe;
}

public static boolean splitOdd10(int[] arr){
    return splitOdd10(arr, 0, 0, 0);
  }
  public static boolean splitOdd10(int[] arr, int start, int total1, int total2){
    if (start == arr.length){
      if (total1%10 == 0 && total2%2 == 1 || total2%10 == 0 && total1%2 == 1) return true;
      return false;
    }
    boolean joe = false;
    joe = joe || splitOdd10(arr, start+1, total1, total2+arr[start]);
    joe = joe || splitOdd10(arr, start+1, total1+arr[start], total2);
    return joe;
  }

}
