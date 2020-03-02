// Given an array of integers, return indices of the two numbers 
// such that they add up to a specific target.

// You may assume that each input would have exactly one solution, 
// and you may not use the same element twice.

// Example:
// Given nums = [2, 7, 11, 15], target = 9,

// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

import java.util.HashMap;

class TwoSumSolution {
    public static void main(String[] args) {
        int[] test = new int[]{2, 7, 11, 15};
        System.out.println("Result: " + twoSum(test, 9)[0]
        + " and " + twoSum(test, 9)[1]); 
        System.out.println("Result should be 0 and 1");   
    }
    
    /**Fast because doing a single pass over the array means 
     * a much faster runtime.
     * The HashMap saves the previous values that have been 
     * seen, rather than having
     * to check each pair one at a time
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valIndex = new HashMap<>();
        for (int i = 0; i < nums.length-1; i++) {
            int val = nums[i];
            int complement = target - val;
            if (valIndex.containsKey(complement)) {
                return new int[]{i, valIndex.get(complement)};
            }
            valIndex.put(val, i);
        }
        return new int[]{-1, -1};
    }
}