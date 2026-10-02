class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int low = 0;
        int high = 0;
        int maxFreq = 0;
        int maxLength = 0;
        for (high = 0; high < s.length(); high ++) {
            char ch = s.charAt(high);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            int windowLength = high - low + 1;
            int replacements = windowLength - maxFreq;
            if (replacements > k) {
                freq[s.charAt(low) - 'A']--;
                low++;
            }
            maxLength = Math.max(maxLength, high-low+1);
        }
        return maxLength;
    }
}