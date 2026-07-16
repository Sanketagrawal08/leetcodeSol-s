class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int dir = 0;

        int top = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;

        // dir == 0 then print left to right
        // dir == 1 then print top to down
        // dir  == 2 then print right to left
        // dir == 3  then print down to top;

        while(top <= down && left <= right) {
            if (dir == 0) {
                // left to right constant is row(top) 
                for(int i = left ;i <= right;i++) {
                    res.add(matrix[top][i]);
                }
                top++;
            }
            if (dir == 1) {
                //  top to down print and column is constant(right)
                for(int i = top;i<=down;i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            if (dir == 2) {
                // right to left print row is constant (down)
                for(int i = right;i >= left;i--) {
                    res.add(matrix[down][i]);
                }
                down--;
            }
            if (dir == 3) {
                // down to top and col is constant(left)
                for(int i = down;i >= top;i--) {
                    res.add(matrix[i][left]);
                }
                left++; 
            }
            dir++;
            if (dir == 4) dir = 0;
        }
        return res;
    }
}