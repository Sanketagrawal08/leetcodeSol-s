class Solution {
   

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int rc = t.length();
        int i = 0;
        int minwindowsize = Integer.MAX_VALUE;
        int starti = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {

                if (map.get(ch) > 0) {
                    rc--;
                }

                map.put(ch, map.get(ch) - 1);
            }

            while (rc == 0) {
                int currwindowsize = j - i + 1;

                if (minwindowsize > currwindowsize) {
                    minwindowsize = currwindowsize;
                    starti = i;
                }
                char left = s.charAt(i);

                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);

                    if (map.get(left) > 0) {
                        rc++;
                    }
                }

                i++;

            }
        }
        if (minwindowsize == Integer.MAX_VALUE)
            return "";

        return s.substring(starti, starti + minwindowsize);
    }
}