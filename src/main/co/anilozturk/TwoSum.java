package src.main.co.anilozturk;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 8, 5, 9, 1}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 5, 5, 11}, 10)));
    }

    static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length - 1; j++){
                if (j < i) j = i;
                if(nums[i] + nums[j + 1] == target){
                    return new int[]{i, j + 1};
                }
            }
        }
        return null;
    }
}
