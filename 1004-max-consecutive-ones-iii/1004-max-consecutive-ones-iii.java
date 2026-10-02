class Solution {
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int high = 0;
        int zeroCount = 0;
        int maxLength = 0;
        for (high = 0; high < nums.length; high++) {
            if (nums[high] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[low] == 0) {
                    zeroCount--;
                }
                low++;
            }
            int windowLength = high - low + 1;
            maxLength = Math.max(maxLength, windowLength);
        }  
        return maxLength;
    }
}