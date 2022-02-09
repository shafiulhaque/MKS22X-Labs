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

}
