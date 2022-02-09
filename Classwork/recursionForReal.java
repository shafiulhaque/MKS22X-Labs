public class recursionForReal{
  public static boolean groupSum6(int start, int[] nums, int target) {
    if (target == 0 && start == nums.length-1) return true;
            if (target < 0) return false;
            boolean joe = false;
            if (start < nums.length){
            for (int i = start; i < nums.length; i++){
              joe = joe || groupSum6(start+1, nums, target-nums[start]);
              if (nums[start] != 6) joe = joe || groupSum6(start+1, nums, target);
            }
          }
    return joe;
  }

}
