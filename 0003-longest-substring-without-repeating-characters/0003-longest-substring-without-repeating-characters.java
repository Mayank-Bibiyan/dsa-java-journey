class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int high = 0;
        int res = -1;
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();
        for (high = 0; high < n; high++) {
            char c = s.charAt(high);
            freq.put(c, freq.getOrDefault (c, 0) + 1);
            while (freq.get(c) > 1) {
                char leftChar = s.charAt(low);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                low ++;
            }
            res = Math.max(res, high - low + 1);
        } 
        if (res > 0) {
            return res;
        } else {
            return 0;
        }
        
    }
}