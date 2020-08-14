package leetcode;

public class MaxValue {
    static class Solution {
        public int maxValue(int[][] grid) {
            int rowCount = grid.length;
            int colCount = grid[0].length;
            int[][] dp = new int[rowCount][colCount];
            dp[0][0] = grid[0][0];
            for(int i = 1; i < rowCount; i ++)
                dp[i][0] = dp[i-1][0] + grid[i][0];
            for(int j= 1; j < colCount; j ++)
                dp[0][j] = dp[0][j-1] + grid[0][j];

            for(int i = 1; i < rowCount; i ++){
                for(int j = 1; j < colCount ; j ++)
                    dp[i][j] = Math.max(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]);
            }

            for(int i = 0; i < rowCount; i ++){
                for(int j = 0; j < colCount ; j ++)
                    System.out.print(dp[i][j]  + "  ");
                System.out.println();
            }
            return dp[rowCount-1][colCount-1];
        }
    }
    public static void main(String[] args) {
        int[][] grid = {{1,1,5}, {2,1,6}, {2,2,1}, {1,1,1}};
        new Solution().maxValue(grid);
    }
}
