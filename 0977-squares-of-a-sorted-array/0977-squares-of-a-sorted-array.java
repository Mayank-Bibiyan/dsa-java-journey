class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        // separate negative and positive numbers

        for (int num : nums) {
            if (num<0) {
                neg.add(num);
            } else {
                pos.add(num);
            }
        }

        // case 1 : No negative numbers

        if (neg.size() == 0) {
            int [] result = new int [nums.length];
            for (int i = 0; i < nums.length; i++){
                result[i] =  nums[i] * nums[i];
            }
            return result;
        }
        // case 2 : No positive numbers 
        if (pos.size() == 0) {
            int [] result = new int [nums.length];
            for(int i = 0; i < nums.length; i++){
                result[nums.length - 1 - i] = nums[i] * nums[i];
            }
            return result;
        }

        // case 3: Both negative and positive numbers exist

        int i = 0;
        int j = 0;
        int id = 0;
        int n1 = neg.size();
        int n2 = pos.size();
        int [] res = new int [n1+n2];
        int [] sqrd_Neg = new int [n1];
        for ( i = 0; i < n1; i++) {
            int num = neg.get(i);
            sqrd_Neg[n1-1-i] = num * num;
        }
        int [] sqrd_Pos = new int [n2]; 
        for ( i = 0; i < n2; i++) {
            int num = pos.get(i);
            sqrd_Pos[i] = num * num;
            
        }

        // Merge two sorted list

        i = 0;
        j = 0;
        while (i < n1 && j < n2)  {
            if(sqrd_Neg[i] <= sqrd_Pos[j]) {
                res[id++] = sqrd_Neg[i++];
            } else {
                res[id++] = sqrd_Pos[j++];
            }
        }
        while (i<n1) {
            res[id++] = sqrd_Neg[i++];
        }
        while (j<n2) {
            res[id++] = sqrd_Pos[j++];
        }

        return res;
    }
}