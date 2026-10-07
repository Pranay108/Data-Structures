class Solution {
    public static int solve(int currR,int currC, int[][] grid,int m,int n,int[][] dp){
      if(currR >= m || currC >= n) return Integer.MAX_VALUE;
      if(dp[currR][currC]!=-1) return dp[currR][currC];
      if(currR == m-1 && currC==n-1) return grid[currR][currC];
      int right = solve(currR,currC+1,grid,m,n,dp);
      int down = solve(currR+1,currC,grid,m,n,dp);
      return dp[currR][currC]=grid[currR][currC] + Math.min(right,down);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i =0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(0,0,grid,m,n,dp);
        
    }
}