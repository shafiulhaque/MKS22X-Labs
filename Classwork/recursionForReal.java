public class recursionForReal{
  public static boolean groupSum(int start, int[] nums, int target) {
  if (target == 0) return true;
          if (target < 0) return false;
          if (start < nums.length){
            return groupSum(start+1, nums, target-nums[start]) || groupSum(start+1, nums, target);
        }
          return false;
}

public static boolean splitArray(int[] arr){
    return splitArray(arr, 0, 0, 0);
  }
  public static boolean splitArray(int[] arr, int start, int total1, int total2){
    if (start == arr.length){
      if (total1 == total2) return true;
      return false;
    }
    return splitArray(arr, start+1, total1, total2+arr[start]) || splitArray(arr, start+1, total1+arr[start], total2);
  }

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

  public static boolean split53(int[] arr){
    return split53(arr, 0, 0, 0);
  }
  public static boolean split53(int[] arr, int start, int total1, int total2){
    if (start == arr.length){
      if (total1 == total2) return true;
      return false;
    }
    boolean joe = false;
    if (arr[start]%5 == 0){
      joe = joe || split53(arr, start+1, total1+arr[start], total2);
    } else if (arr[start]%3 == 0){
      joe = joe || split53(arr, start+1, total1, total2+arr[start]);
    } else {
      joe = joe || split53(arr, start+1, total1+arr[start], total2);
    joe = joe || split53(arr, start+1, total1, total2+arr[start]);
    }
    return joe;
  }

  public static boolean groupNoAdj(int start, int[] arr, int target){
          if (target == 0) return true;
          if (target < 0) return false;
          boolean joe = false;
          if (start < arr.length){
            joe = joe || groupNoAdj(start+2, arr, target-arr[start]);
            joe = joe || groupNoAdj(start+1, arr, target);
        }
          return joe;
        }

        public static boolean groupSumClump(int start, int[] arr, int target){
          if (target == 0) return true;
          if (target < 0) return false;
          boolean joe = false;
            if (start < arr.length){
              int i = start;
              int sum = 0;
              while(i < arr.length && arr[start] == arr[i]) {
                sum += arr[i];
                i++;
              }
              i = i - start;
                joe = joe || groupSumClump(start+i, arr, target-sum);
                joe = joe || groupSumClump(start+i, arr, target);

            }
          return joe;
        }

}
