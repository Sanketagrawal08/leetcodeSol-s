class Solution {
    public int characterReplacement(String s, int k) {
       int left = 0;
        int[] freq = new int[26];
        int maxfreq = 0;
        int maxwindowsize = 0;

        for (int right =0;right < s.length();right++) {
            char ch = s.charAt(right);  
            freq[ch - 'A']++;
            maxfreq = Math.max(maxfreq , freq[ch - 'A']);
            int windowlength = right - left + 1;
           
            int character_need_to_be_changed = windowlength - maxfreq;

            if (character_need_to_be_changed > k) {
                 freq[s.charAt(left) - 'A']--;
                 left++;
            }
            windowlength = right - left + 1;
            maxwindowsize = Math.max(windowlength , maxwindowsize);
        }
        return maxwindowsize;
    }
}