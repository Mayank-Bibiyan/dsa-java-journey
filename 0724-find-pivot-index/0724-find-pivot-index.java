class Solution {
    public int pivotIndex(int[] nums) {

        int [] prefix = new int[nums.length];
        int [] suffix = new int[nums.length];

        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];

        for ( int i = 1; i < nums.length ; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        for ( int i = nums.length-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] + nums[i];
        }
        for ( int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            if (i>0) {
                left = prefix[i-1];
            }
            if (i<nums.length-1) {
                right = suffix[i+1];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
        
    }
}