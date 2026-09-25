class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }
        for (int i = 0 ; i < s.length(); i++) {
            int frequency = freq.get (s.charAt(i));
            if (frequency == 1) {
                return i;
            }
        }
        return -1;
    } 
}