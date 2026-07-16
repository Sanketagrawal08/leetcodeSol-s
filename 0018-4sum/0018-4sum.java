class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        HashSet<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {

                int p = j + 1;
                int q = nums.length - 1;

                while (p < q) {
                    long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum < target) {
                        p++;
                    } else if (sum > target)
                        q--;
                    else {
                        ans.add(List.of(nums[i], nums[j], nums[p], nums[q]));
                        p++;
                        q--;
                    }
                }
            }
        }
        ArrayList<List<Integer>> ans2 = new ArrayList<>();
        for (List<Integer> list : ans) {
            ans2.add(list);
        }
        return ans2;
    }
}