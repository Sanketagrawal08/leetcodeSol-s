class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        
        int[] lookforneighbours = new int[ratings.length];
        Arrays.fill(lookforneighbours , 1);

        for(int i = 1;i < n;i++) {
            if (ratings[i] > ratings[i-1]) {
               lookforneighbours[i] = lookforneighbours[i-1] + 1;
            }
        }

        for (int i = n-2;i >= 0;i--) {
            if (ratings[i] > ratings[i+1]) {
                if(lookforneighbours[i] <= lookforneighbours[i+1]) {
                    lookforneighbours[i] = lookforneighbours[i+1] + 1;
                }
            }
        }
        int sum = 0;
        for (int num : lookforneighbours) sum += num;
        
        return sum;
    }
}