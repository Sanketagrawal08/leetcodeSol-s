class Solution {
    public int minDeletions(String s) {
        HashSet<Integer> set = new HashSet<>();
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 97]++;
        }
        int ans = 0;
        for(int i = 0;i < freq.length;i++) {

                while (set.contains(freq[i]) && freq[i] > 0){
                        freq[i]-= 1;
                        ans++;
                }
        set.add(freq[i]);
        }
        return ans;
    }
}