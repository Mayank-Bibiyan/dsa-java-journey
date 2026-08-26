import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer >> result = new ArrayList<>();

        // sort the array 
        Arrays.sort(nums);

        // fix the first element
        for ( int i = 0; i < nums.length-2; i++) {
            // skip duplicate first elements
            if ( i > 0 && nums[i] == nums[i-1] ) {
                continue;
            }
            if ( nums[i] > 0 ) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;

            // two pointer approach
            while ( left < right ) {
                int sum = nums[i] + nums[left] + nums[right];

                if ( sum == 0 ) {
                    result.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));
                    
                    // skip duplicate left values
                    while( left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // skip duplicate right vallues
                    while ( left < right && nums[right] == nums[right-1]) {
                        right --;
                    }
                    left++;
                    right--;
                }
                else if ( sum < 0) {
                    left ++;
                }
                else {
                    right --;
                }
            }
        
        }
        return result;

    }
}