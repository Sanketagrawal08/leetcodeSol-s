class Solution {
    int solve(int[] nums , int idx, int[] dp) {
        if (idx >= nums.length) return 0;
        if (dp[idx] != -1) return dp[idx];

        int steal = nums[idx]  + solve(nums, idx+2 , dp);
        int skip = solve(nums, idx+1 , dp);

        return dp[idx] = Math.max(steal, skip);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp , -1);
        return solve(nums ,  0, dp);
    }
}