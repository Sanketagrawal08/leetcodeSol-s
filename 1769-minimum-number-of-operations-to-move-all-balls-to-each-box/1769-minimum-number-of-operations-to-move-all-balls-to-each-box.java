class Solution {
    public int[] minOperations(String boxes) {
      
        int[] ans = new int[boxes.length()];

        int bc = 0,cost = 0;
        for(int left = 0;left < boxes.length();left++) {
            char ch = boxes.charAt(left);
            cost = cost + bc;
            ans[left] = cost;
            if (ch == '1') bc++;
        }
        bc=0;
        cost=0;
        for (int right = boxes.length()-1;right >= 0;right--) {
             char ch = boxes.charAt(right);
            cost = cost + bc;
            ans[right] = ans[right] + cost;
            if (ch == '1') bc++;
        }
        return ans;
    }
}